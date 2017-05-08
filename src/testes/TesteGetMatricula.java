package testes;

import consultas.AlunoDAO;

public class TesteGetMatricula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(""+AlunoDAO.getMatricula("000.000.000-00"));
		System.out.println(AlunoDAO.existe("111.111.111-11"));
		System.out.println(AlunoDAO.existe("111.111.111-12"));
	}

}
