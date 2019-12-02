package br.edu.univas.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import br.edu.univas.Model.mensagemModel;

public class observacaoDAO {
	private Connection connection;
	
	public observacaoDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public ArrayList<mensagemModel> showMensagem(String titulo, String cliente) {
		ArrayList<mensagemModel> data = new ArrayList<>();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String sql = "SELECT * FROM observacao WHERE titulo ='" + titulo + "' and revendedor = '" + cliente + "' ORDER BY idmensagem ASC";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				mensagemModel mensagem = new mensagemModel();
				mensagem.setMensagem(resultSet.getString("mensagem"));
				mensagem.setData(f.format(resultSet.getDate("data")));
				data.add(mensagem);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return data;
	}
	
	public ArrayList<mensagemModel> showMensagemUsuario(String titulo, String departamento) {
		ArrayList<mensagemModel> data = new ArrayList<>();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String sql = "SELECT * FROM observacao WHERE titulo ='" + titulo + "' and departamento = '" + departamento + "' ORDER BY idmensagem ASC";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				mensagemModel mensagem = new mensagemModel();
				mensagem.setMensagem(resultSet.getString("mensagem"));
				mensagem.setData(f.format(resultSet.getDate("data")));
				
				data.add(mensagem);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return data;
	}
}
