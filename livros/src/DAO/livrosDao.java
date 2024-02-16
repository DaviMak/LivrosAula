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
	public void remover(int id) {
		try {
			ConexaoBanco conexaobanco = new ConexaoBanco();
			conexao = conexaobanco.getCon();
			conexao.setAutoCommit(false);
			
			String sql = "DELETE FROM livros WHERE id = ?";
			statement = conexao.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(Exception ex){
			try {
				conexao.rollback();
			}catch(SQLException e) {
				ex.printStackTrace();
			}
			finally {
				try {
					conexao.setAutoCommit(true);
					statement.close();
					conexao.close();
				}catch(Exception e) {
					ex.printStackTrace();
				}
			}
		}
	}
	public void alterar(modelo livros) {
		try {
			ConexaoBanco conexaobanco = new ConexaoBanco();
			conexao = conexaobanco.getCon();
			conexao.setAutoCommit(false);
			
			String sql = "UPDATE livros SET titulo = ?, autor = ?, ano = ?, localidade = ?, editora = ?";
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
			}catch(SQLException e){
				ex.printStackTrace();
			}
		}finally {
			try {
				conexao.setAutoCommit(true);
				statement.close();
				conexao.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public List<modelo> listar(){
		try {
			ConexaoBanco conexaobanco = new ConexaoBanco();
			conexao = conexaobanco.getCon();
			conexao.setAutoCommit(false);
			
			String sql = "SELECT * FROM livros";
			statement = conexao.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			List<modelo> ListaLivros = new ArrayList<modelo>();
			while(result.next()) {
				modelo livros = new modelo();
				livros.setId(result.getInt(1));
				livros.setTitulo(result.getString(2));
				livros.setAno(result.getString(3));
				livros.setAutor(result.getString(4));
				livros.setLocalidade(result.getString(5));
				livros.setEditora(result.getString(6));
			}
			return ListaLivros;
		}catch(Exception ex) {
			try {
				conexao.rollback();
			}catch(SQLException e) {
				ex.printStackTrace();
			}
			ex.printStackTrace();
			return null;
		}
//		finally {
//			try {
//				
//			}
//		}
	}
}
