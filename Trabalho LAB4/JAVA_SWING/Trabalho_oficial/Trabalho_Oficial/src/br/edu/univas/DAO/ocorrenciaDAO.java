package br.edu.univas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import br.edu.univas.Model.OcorrenciaModel;
import br.edu.univas.Model.empresaModel;

public class ocorrenciaDAO {

	private Connection connection;
	
	public ocorrenciaDAO() throws SQLException {
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(OcorrenciaModel ocorrencia) {
		String sql = "INSERT INTO ocorrencia (titulo, departamento, problemas, produto, nomecliente, status, idproduto, idrevendedor, iddepartamento,data)"
				+ "VALUES (?,?,?,?,?,?,(select idproduto from produto where idproduto = '"+ ocorrencia.getIdProduto() +"'),(select idrevendedor from revendedor where nome = '"+ ocorrencia.getNomeCliente() +"'),(select iddepartamento from departamento where nomedepartamento = '"+ocorrencia.getComboSetor() +"'),NOW());"
				+ "INSERT INTO observacao (titulo, mensagem, revendedor, data, departamento, protocolo) "
				+ "VALUES (?,?,?,'NOW()',?,(SELECT MAX(protocolo) FROM ocorrencia))";
		
		int index = 1;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, ocorrencia.getTitulo());
			statement.setString(index++, ocorrencia.getComboSetor());
			statement.setString(index++, ocorrencia.getProblemas());
			statement.setString(index++, ocorrencia.getProduto());
			statement.setString(index++, ocorrencia.getNomeCliente());
			statement.setString(index++, "Em Atendimento");
			statement.setString(index++, ocorrencia.getTitulo());
			statement.setString(index++, ocorrencia.getObservação());
			statement.setString(index++, ocorrencia.getNomeCliente());
			statement.setString(index++, ocorrencia.getComboSetor());
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<OcorrenciaModel> getAll(String model) {
		ArrayList<OcorrenciaModel> data = new ArrayList<>();
		
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

		String sql = "SELECT * FROM ocorrencia WHERE nomecliente = '"+ model + "' ORDER BY protocolo DESC";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				OcorrenciaModel ocorrencia = new OcorrenciaModel();
				ocorrencia.setProtocolo(resultSet.getString("protocolo"));
				ocorrencia.setTitulo(resultSet.getString("titulo"));
				ocorrencia.setComboSetor(resultSet.getString("departamento"));
				ocorrencia.setProblemas(resultSet.getString("problemas"));
				ocorrencia.setStatus(resultSet.getString("status"));
				ocorrencia.setProduto(resultSet.getString("produto"));
				ocorrencia.setNomeCliente(resultSet.getString("nomecliente"));
				ocorrencia.setData(f.format(resultSet.getDate("data")));
				ocorrencia.setIdCnpj(resultSet.getInt("idrevendedor"));
				ocorrencia.setIdDepartamento(resultSet.getInt("iddepartamento"));
				ocorrencia.setIdProduto(resultSet.getInt("idproduto"));
				data.add(ocorrencia);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return data;
	}
	
	public ArrayList<OcorrenciaModel> getAllAdm(String model) {
		ArrayList<OcorrenciaModel> data = new ArrayList<>();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String sql = "SELECT * FROM ocorrencia WHERE departamento ILIKE '"+ model +"' ORDER BY protocolo DESC";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				OcorrenciaModel ocorrencia = new OcorrenciaModel();
				ocorrencia.setProtocolo(resultSet.getString("protocolo"));
				ocorrencia.setTitulo(resultSet.getString("titulo"));
				ocorrencia.setComboSetor(resultSet.getString("departamento"));
				ocorrencia.setProblemas(resultSet.getString("problemas"));
				ocorrencia.setStatus(resultSet.getString("status"));
				ocorrencia.setProduto(resultSet.getString("produto"));
				ocorrencia.setNomeCliente(resultSet.getString("nomecliente"));
				ocorrencia.setData(f.format(resultSet.getDate("data")));
				ocorrencia.setIdCnpj(resultSet.getInt("idrevendedor"));
				ocorrencia.setIdDepartamento(resultSet.getInt("iddepartamento"));
				ocorrencia.setIdProduto(resultSet.getInt("idproduto"));
				data.add(ocorrencia);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return data;
	}
	
	public void updateStatus(OcorrenciaModel ocorrencia, String status, String ID) {
		String sql = "UPDATE ocorrencia SET status = ?" + "WHERE protocolo = ?";
		
		int	idprotocolo = Integer.parseInt(ID);
		
		try {
		
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, status);
			statement.setInt(2, idprotocolo);
			
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cadEmpresa(empresaModel empresa) {
		String sql = "INSERT INTO revendedor (nome, cnpj, endereco, telefone, responsavel, email) "
				+ "VALUES (?,?,?,?,?,?)";
		
		int index = 1;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, empresa.getNome());
			statement.setString(index++, empresa.getCnpj());
			statement.setString(index++, empresa.getEndereco());
			statement.setString(index++, empresa.getTelefone());
			statement.setString(index++, empresa.getResponsavel());
			statement.setString(index++, empresa.getEmail());
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void saveMensagemAdm(OcorrenciaModel mensagem) {
		
		String sql ="INSERT INTO observacao (titulo, mensagem, revendedor, data, departamento, protocolo) "
				+ "VALUES (?,?,?,'NOW()',?,?)";;
		
		int index = 1;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(index++, mensagem.getTitulo());
			statement.setString(index++, mensagem.getObservação());
			statement.setString(index++, mensagem.getNomeCliente());
			statement.setString(index++, mensagem.getComboSetor());
			statement.setInt(index++, Integer.parseInt(mensagem.getProtocolo()));
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}