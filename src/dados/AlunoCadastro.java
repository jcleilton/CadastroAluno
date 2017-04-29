/**
 * 
 */
package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author jcleilton
 *
 */
public class AlunoCadastro {
	private boolean fezCursoUtd;
	private String nomeAluno;
	private String cpfAluno;
	private String sexoAluno;
	private String dataNasc;
	private String estadoCivil;
	private String endereco;
	private String bairro;
	private String cidade;
	private String telefone;
	private String curso;
	private String turma;
	private int quantosCursos;
	private String quaisCursos;
	private String quandoFez;

	/**
	 * 
	 */
	
	public AlunoCadastro(){
		
	}
	
	public AlunoCadastro(boolean fezCursoUtd,String nomeAluno,String cpfAluno,String sexoAluno,String dataNasc,String estadoCivil,String endereco,String bairro,String cidade,String telefone,String curso,String turma,int quantosCursos, String quaisCursos,String quandoFez) {
		this.fezCursoUtd = fezCursoUtd;
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.sexoAluno = sexoAluno;
		this.dataNasc = dataNasc;
		this.estadoCivil = estadoCivil;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.telefone = telefone;
		this.curso = curso;
		this.turma = turma;
		this.quantosCursos = quantosCursos;
		this.quaisCursos = ""+quaisCursos;
		this.quandoFez = ""+quandoFez;
		try {
			this.salvaAluno();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao salvar aluno "+this.nomeAluno+"!\n"+e);
		}
	}
	
	private void salvaAluno() throws IOException{
		OutputStream os = new FileOutputStream(this.cpfAluno+".txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write(""+this.fezCursoUtd);
		bw.newLine();
		bw.write(this.nomeAluno);
		bw.newLine();
		bw.write(this.cpfAluno);
		bw.newLine();
		bw.write(this.sexoAluno);
		bw.newLine();
		bw.write(this.dataNasc);
		bw.newLine();
		bw.write(this.estadoCivil);
		bw.newLine();
		bw.write(this.endereco);
		bw.newLine();
		bw.write(this.bairro);
		bw.newLine();
		bw.write(this.cidade);
		bw.newLine();
		bw.write(this.telefone);
		bw.newLine();
		bw.write(this.curso);
		bw.newLine();
		bw.write(this.turma);
		bw.newLine();
		bw.write(""+this.quantosCursos);
		bw.newLine();
		bw.write(this.quandoFez);
		bw.newLine();
		bw.close();
	}
	public boolean existeAluno(String cpf){
		try{
			InputStream is = new FileInputStream(cpf+".txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			AlunoCadastro alunoExistente = new AlunoCadastro();
			alunoExistente.setFezCursoUtd(Boolean.parseBoolean(br.readLine()));
			alunoExistente.setNomeAluno(br.readLine());
			alunoExistente.setCpfAluno(br.readLine());
			alunoExistente.setSexoAluno(br.readLine());
			alunoExistente.setDataNasc(br.readLine());
			alunoExistente.setEstadoCivil(br.readLine());
			alunoExistente.setEndereco(br.readLine());
			alunoExistente.setBairro(br.readLine());
			alunoExistente.setCidade(br.readLine());
			alunoExistente.setTelefone(br.readLine());
			alunoExistente.setCurso(br.readLine());
			alunoExistente.setTurma(br.readLine());
			alunoExistente.setQuantosCursos(Integer.parseInt(br.readLine()));
			alunoExistente.setQuandoFez(br.readLine());
			alunoExistente.setQuaisCursos(br.readLine());
			br.close();
			System.out.println(alunoExistente);
			return true;
		}catch (Exception e){
			return false;
		}
	}
	
	public AlunoCadastro consultaAluno(String cpf){
		
		return null;
	}

	public boolean isFezCursoUtd() {
		return this.fezCursoUtd;
	}

	public void setFezCursoUtd(boolean fezCursoUtd) {
		this.fezCursoUtd = fezCursoUtd;
	}

	public String getNomeAluno() {
		return this.nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getCpfAluno() {
		return this.cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getSexoAluno() {
		return this.sexoAluno;
	}

	public void setSexoAluno(String sexoAluno) {
		this.sexoAluno = sexoAluno;
	}

	public String getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTurma() {
		return this.turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public int getQuantosCursos() {
		return this.quantosCursos;
	}

	public void setQuantosCursos(int quantosCursos) {
		this.quantosCursos = quantosCursos;
	}

	public String getQuaisCursos() {
		return this.quaisCursos;
	}

	public void setQuaisCursos(String quaisCursos) {
		this.quaisCursos = quaisCursos;
	}

	public String getQuandoFez() {
		return this.quandoFez;
	}

	public void setQuandoFez(String quandoFez) {
		this.quandoFez = quandoFez;
	}

	@Override
	public String toString() {
		return "AlunoCadastro [fezCursoUtd=" + fezCursoUtd + ", nomeAluno=" + nomeAluno + ", cpfAluno=" + cpfAluno
				+ ", sexoAluno=" + sexoAluno + ", dataNasc=" + dataNasc + ", estadoCivil=" + estadoCivil + ", endereco="
				+ endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", telefone=" + telefone + ", curso=" + curso
				+ ", turma=" + turma + ", quantosCursos=" + quantosCursos + ", quaisCursos=" + quaisCursos
				+ ", quandoFez=" + quandoFez + "]";
	}

	


}
