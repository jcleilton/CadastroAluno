/**
 * 
 */
package testes;

import dados.AlunoCadastro;

/**
 * @author jcleilton
 *
 */
public class TesteExisteAluno {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AlunoCadastro aluno = new AlunoCadastro();
		System.out.println("O aluno do cpf 615.695.853.-34 existe? " + aluno.existeAluno("615.695.853-34"));
		System.out.println("O aluno do cpf 000.000.000-00 existe? " + aluno.existeAluno("000.000.000-00"));
	}

}
