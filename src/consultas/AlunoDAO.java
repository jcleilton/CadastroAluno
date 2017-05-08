/**
 * Classe responsável pelas consultas e manipulação de dados.
 */
package consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexoes.Conexao;
import conexoes.ConstantesBD;
import dados.AlunoCadastro;
import dados.Estrutura;


/**
 * @author jcleilton
 *
 */
public class AlunoDAO extends ConstantesBD{
	private static String sql;
	private static PreparedStatement ps;
	private static ResultSet rs;

	public static boolean existe(String cpf){
		sql = "SELECT * FROM "+TABELA+" WHERE cpf = \""+cpf+"\"";

		try {
			ps = Conexao.conecta().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				if (rs.getString("cpf").equals(cpf)){
					return true;
				}else{
					return false;
				}
			}
			return false;


		} catch (SQLException e) {
			return false;
		}
	}

	public static int getMatricula(String cpf){
		sql = "SELECT * FROM "+TABELA+" WHERE cpf = \""+cpf+"\"";

		try {
			ps = Conexao.conecta().prepareStatement(sql);
			rs = ps.executeQuery();
			int a = -1;
			if (rs != null){
				while (rs.next())
				{
					a = rs.getInt("matricula");
				}
			}else{
				return -1;
			}

			ps.close();
			rs.close();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				ps.close();
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return -1;
		}	
	}


	public static Estrutura<AlunoCadastro> alunosArray(){
		sql = "SELECT cpf FROM "+TABELA;
		try {
			Estrutura<AlunoCadastro> estrutura = new Estrutura<>();
			ps = Conexao.conecta().prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs != null){
				Estrutura<String> cpfString = new Estrutura<>();
				while (rs.next())
				{
					cpfString.adiciona(rs.getString("cpf"));
				}
				rs.close();
				ps.close();
				while (!cpfString.estaVazia())
				{
					estrutura.adiciona(new AlunoCadastro().recuperaAluno(cpfString.apagaPrimeiroFila()));
				}
				
			}else{
				return null;
			}
			return estrutura;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}

	public static AlunoCadastro recupera(String cpf){
		sql = "SELECT * FROM "+TABELA+" WHERE cpf = \""+cpf+"\"";
		try {
			AlunoCadastro aluno = new AlunoCadastro();
			ps = Conexao.conecta().prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs != null){
				while (rs.next())
				{
					aluno.setMatricula(rs.getInt("matricula"));
					aluno.setFezCursoUtd(rs.getBoolean("fezCursoUtd"));
					aluno.setQuantosCursos(rs.getInt("quantosCursos"));
					aluno.setNomeAluno(rs.getString("nome"));
					aluno.setCpfAluno(rs.getString("cpf"));
					aluno.setSexoAluno(rs.getString("sexo"));
					aluno.setDataNasc(rs.getString("dataNasc"));
					aluno.setEstadoCivil(rs.getString("estadoCivil"));
					aluno.setEndereco(rs.getString("endereco"));
					aluno.setBairro(rs.getString("bairro"));
					aluno.setCidade(rs.getString("cidade"));
					aluno.setTelefone(rs.getString("telefone"));
					aluno.setCurso(rs.getString("curso"));
					aluno.setTurno(rs.getString("turno"));
					aluno.setQuaisCursos(rs.getString("quaisCursos"));
					aluno.setQuandoFez(rs.getString("quandoFez"));
				}
				rs.close();
				ps.close();
			}else{
				return null;
			}
			return aluno;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}

	public static void update(AlunoCadastro aluno){
		sql = "UPDATE "+TABELA+" SET fezCursoUtd = ?, quantosCursos = ?, nome = \"?\", cpf  = \"?\", sexo  = \"?\", dataNasc = \"?\", estadoCivil = \"?\", endereco = \"?\", bairro = \"?\", cidade = \"?\", telefone = \"?\", curso = \"?\", turno = \"?\", quaisCursos = \"?\", quandoFez = \"?\" WHERE matricula = ?";
		try {
			ps = Conexao.conecta().prepareStatement(sql);
			ps.setBoolean(1, aluno.isFezCursoUtd());
			ps.setInt(2, aluno.getQuantosCursos());
			ps.setString(3, aluno.getNomeAluno());
			ps.setString(4, aluno.getCpfAluno());
			ps.setString(5, aluno.getSexoAluno());
			ps.setString(6, aluno.getDataNasc());
			ps.setString(7, aluno.getEstadoCivil());
			ps.setString(8, aluno.getEndereco());
			ps.setString(9, aluno.getBairro());
			ps.setString(10, aluno.getCidade());
			ps.setString(11, aluno.getTelefone());
			ps.setString(12, aluno.getCurso());
			ps.setString(13, aluno.getTurno());
			ps.setString(14, aluno.getQuaisCursos());
			ps.setString(15, aluno.getQuandoFez());
			ps.setInt(16, aluno.getMatricula());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}

	public static void delete(String cpf){
		sql = "DELETE FROM "+ TABELA +" WHERE cpf = ?";
		try {
			ps = Conexao.conecta().prepareStatement(sql);
			ps.setString(1, cpf);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}

	public static void salvar(AlunoCadastro aluno){
		sql = "INSERT INTO "+TABELA+"(fezCursoUtd,quantosCursos,nome,cpf,sexo,dataNasc,estadoCivil,endereco,bairro,cidade,telefone,curso,turno,quaisCursos,quandoFez) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = Conexao.conecta().prepareStatement(sql);
			ps.setBoolean(1, aluno.isFezCursoUtd());
			ps.setInt(2, aluno.getQuantosCursos());
			ps.setString(3, aluno.getNomeAluno());
			ps.setString(4, aluno.getCpfAluno());
			ps.setString(5, aluno.getSexoAluno());
			ps.setString(6, aluno.getDataNasc());
			ps.setString(7, aluno.getEstadoCivil());
			ps.setString(8, aluno.getEndereco());
			ps.setString(9, aluno.getBairro());
			ps.setString(10, aluno.getCidade());
			ps.setString(11, aluno.getTelefone());
			ps.setString(12, aluno.getCurso());
			ps.setString(13, aluno.getTurno());
			ps.setString(14, aluno.getQuaisCursos());
			ps.setString(15, aluno.getQuandoFez());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}

	}
}
