package br.edu.univas.Controller;

import java.sql.SQLException;

import javax.swing.JPanel;

import br.edu.univas.DAO.observacaoDAO;
import br.edu.univas.DAO.ocorrenciaDAO;
import br.edu.univas.Listener.saveReg;
import br.edu.univas.Model.OcorrenciaModel;
import br.edu.univas.View.TelaUsuarioPanel;
import br.edu.univas.View.respondeView;


public class respondeController {
	private TelaUsuarioPanel telaPanel;
	public TelaAdmController telaController;
	private respondeView responde;
	observacaoDAO observacao;
	private ocorrenciaDAO ocorrencia;
	private OcorrenciaModel ocorrenciaModel;
	String numero, titulo, cliente, departamento;
	
	public respondeController(String n, String titulo, String cliente, String departamento) throws SQLException {
		ocorrenciaModel = new OcorrenciaModel();
		observacao = new observacaoDAO();
		ocorrencia = new ocorrenciaDAO();
		telaController = new TelaAdmController();
		responde = new respondeView(n, titulo);
		responde.pack();
		this.titulo = titulo;
		this.departamento = departamento;
		numero = n;
		this.cliente = cliente;
		getMensagem();
		telaController.getComponent();
		responde.setVisible(true);
		responde.setLocationRelativeTo(null);
		responde.setListener(new saveReg() {
			
			@Override
			public void saveReg() {
				saveMensagem();
			}
		});
	}
	
	private void saveMensagem() {
		ocorrenciaModel = new OcorrenciaModel();
		ocorrenciaModel.setObservação(responde.getComent().getText().toString());
		ocorrenciaModel.setNomeCliente(cliente);
		ocorrenciaModel.setTitulo(titulo);
		ocorrenciaModel.setProtocolo(numero);
		ocorrenciaModel.setComboSetor(departamento);
		
		ocorrencia.saveMensagemAdm(ocorrenciaModel);
		try {
			getMensagem();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		clearFields();
	}

	private void clearFields() {
		responde.getComent().setText(null);
	}
	
	public JPanel getMensagem() throws SQLException {
		responde.showMensagem(observacao.showMensagem(titulo,cliente));
		return telaPanel;
	}
	
}
