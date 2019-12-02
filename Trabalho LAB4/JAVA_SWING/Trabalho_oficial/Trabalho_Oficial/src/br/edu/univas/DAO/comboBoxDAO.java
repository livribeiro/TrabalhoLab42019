package br.edu.univas.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.univas.Model.UsuarioModel;
import br.edu.univas.Model.produtoModel;
import br.edu.univas.Model.setorModel;


public class comboBoxDAO {
	private Connection connection;
	
	public comboBoxDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public ArrayList<produtoModel> produto(){
		ArrayList<produtoModel> data = new ArrayList<>();
		
		String sql = "SELECT * FROM produto ORDER BY idproduto ASC";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				produtoModel produtos = new produtoModel();
				produtos.setNome(resultSet.getString("nomeproduto"));
				produtos.setCodProduto(resultSet.getString("modeloproduto"));
				produtos.setIdproduto(resultSet.getInt("idproduto"));
				data.add(produtos);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}	
		return data;
	}
	
	public ArrayList<setorModel> setor(){
		ArrayList<setorModel> data = new ArrayList<>();
		
		String sql = "SELECT * FROM departamento";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				setorModel setor = new setorModel();
				setor.setNomeSetor(resultSet.getString("nomedepartamento"));
				setor.setNumSetor(resultSet.getInt("codigodepartamento"));
				setor.setIddepartametno(resultSet.getInt("iddepartamento"));
				data.add(setor);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}	
		return data;
	}
}
