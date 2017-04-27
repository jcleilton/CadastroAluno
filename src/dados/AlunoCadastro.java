/**
 * 
 */
package dados;

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
		this.SalvaAluno();
	}
	
	private void SalvaAluno(){
		
	}
	public boolean existeAluno(String cpf){
		return false;
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

	


}
