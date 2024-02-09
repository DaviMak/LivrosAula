package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.modelo;

public class livrosDao {
	private Connection conexao;
	private PreparedStatement statement;
	
	public void inserir(modelo livros) {
		try {
			ConexaoBanco conexaobanco = new ConexaoBanco();
			conexao = conexaobanco.getCon();
			conexao.setAutoCommit(false);
			
			String sql = "INSERT INTO livros values (?,?,?,?,?)";
			statement = conexao.prepareStatement(sql);
			
			statement.setString(1, livros.getTitulo());
			statement.setString(2, livros.getAutor());
			statement.setString(3, livros.getAno());
			statement.setString(4, livros.getLocalidade());
			statement.setString(5, livros.getEditora());
			
			statement.executeUpdate();
		}catch(Exception ex) {
			try {
				conexao.rollback();
			}catch(SQLException e) {
				ex.printStackTrace();
			}
			ex.printStackTrace();
		}
		finally {
			try {
				conexao.setAutoCommit(true);
				statement.close();
				conexao.close();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
