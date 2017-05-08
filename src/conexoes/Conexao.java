/*
 * Classe responsável pela conexão com o banco de dados externo.
 * */

package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao extends ConstantesBD{
	private static Connection bancoDados;
	public static Connection conecta() throws SQLException{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (bancoDados != null){
			return bancoDados;
		}
		bancoDados = DriverManager.getConnection(URL,USUARIO,SENHA);
		return bancoDados;
	}
}
