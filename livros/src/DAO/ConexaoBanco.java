package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {
	private String login = "root";
	private String senha = "root";
	private String nomebase = "revisao";
	private String servidor = "localhost:3306";
	
	public Connection getCon() throws Exception {
		Connection conexao = null;
		try {
			if(conexao == null || conexao.isClosed()) {
				Class.forName("com.mysql.cj.jbdc.Driver");
				String dados = servidor + "/" + nomebase;
				conexao = DriverManager.getConnection("jdbc:mysql://"+dados+"?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC",login,senha);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return conexao;
	}
}
