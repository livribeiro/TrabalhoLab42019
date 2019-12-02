package br.edu.univas.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.Model.UsuarioModel;


public class autenticacaoDAO {
	private Connection connection;
	
	public autenticacaoDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public ArrayList<UsuarioModel> autenticaUsuario(){
		ArrayList<UsuarioModel> data = new ArrayList<>();
		
		String sql = "SELECT * FROM revendedor";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				UsuarioModel usuario = new UsuarioModel();
				usuario.setCnpj(resultSet.getString("cnpj"));
				usuario.setNomeSetor(resultSet.getString("nome"));
				data.add(usuario);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}	
		return data;
	}
	
	public ArrayList<UsuarioModel> autenticaAdm(){
		ArrayList<UsuarioModel> data = new ArrayList<>();
		
		String sql = "SELECT * FROM departamento";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				UsuarioModel usuario = new UsuarioModel();
				usuario.setSetor(resultSet.getInt("codigodepartamento"));
				usuario.setNomeSetor(resultSet.getString("nomedepartamento"));
				data.add(usuario);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}	
		return data;
	}
}
