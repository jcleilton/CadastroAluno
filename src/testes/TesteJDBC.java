package testes;

import consultas.AlunoDAO;
import dados.AlunoCadastro;

public class TesteJDBC {
	public static void main(String[] args) {
		AlunoCadastro aluno = new AlunoCadastro();
		aluno.setFezCursoUtd(false);
		aluno.setNomeAluno("Teste");
		aluno.setCpfAluno("999-999-999-99");
		aluno.setSexoAluno("Masculino");
		aluno.setDataNasc("01/02/2001");
		aluno.setEstadoCivil("Solteiro");
		aluno.setEndereco("Rua a, s/n");
		aluno.setBairro("Centro");
		aluno.setCidade("Fortaleza");
		aluno.setTelefone("(85) 99999-9999");
		aluno.setCurso("Jaca com bd");
		aluno.setTurno("Tarde");
		
		AlunoDAO.salvar(aluno);
	}
	

}
