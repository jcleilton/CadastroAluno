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
		System.out.println("O aluno do cpf 047.308.283-08 existe? " + aluno.existeAluno("047.308.283-08"));
		System.out.println("O aluno do cpf 000.000.000-00 existe? " + aluno.existeAluno("000.000.000-00"));
	}

}
