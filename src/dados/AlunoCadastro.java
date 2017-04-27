/**
 * 
 */
package dados;

/**
 * @author jcleilton
 *
 */
public class AlunoCadastro {
	
	private static boolean fezCursoUtd;
	private static String nomeAluno;
	private static String cpfAluno;
	private static String sexoAluno;
	private static String dataNasc;
	private static String estadoCivil;
	private static String endereco;
	private static String bairro;
	private static String cidade;
	private static String telefone;

	private static String curso;
	private static String turma;
	private static int quantosCursos;
	private static String quaisCursos;
	private static String quandoFez;

	/**
	 * 
	 */
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
		this.quaisCursos = quaisCursos;
		this.quandoFez = quandoFez;
	}
	

}
