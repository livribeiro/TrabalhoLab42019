package br.edu.univas.Controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import br.edu.univas.DAO.comboBoxDAO;
import br.edu.univas.DAO.ocorrenciaDAO;
import br.edu.univas.Listener.saveReg;
import br.edu.univas.Model.OcorrenciaModel;
import br.edu.univas.View.TelaUsuarioPanel;

public class TelaUsuarioController {
	private TelaUsuarioPanel telaPanel;
	private ocorrenciaDAO ocorrencia;
	private OcorrenciaModel ocorrenciaModel;
	public String numero, nomeCliente;
	public comboBoxDAO comboBox;
	
	
	public TelaUsuarioController() throws SQLException {
		ocorrencia = new ocorrenciaDAO();
		comboBox = new comboBoxDAO();
		telaPanel = new TelaUsuarioPanel();
		getProdutoCombo();
		getSetorCombo();
		telaPanel.setListener(new saveReg() {
			
			@Override
			public void saveReg() {
				if(telaPanel.getComentario().getText().isEmpty() || telaPanel.getTituloField().getText().isEmpty()) {
					JOptionPane.showMessageDialog(telaPanel, "Campos Vazios. Por favor, adicione o título e o comentário.","Registro de Ocorrência",JOptionPane.WARNING_MESSAGE);
				}else {
					saveOcorrencia();
					getComponent();	
					
				}	
			}
		});
		
	}
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public void setNumero(String numUsuario) {
		telaPanel.setNumero(numUsuario);
		numero = numUsuario;
	}
	
	
	
	public void saveOcorrencia() {
		ocorrenciaModel = new OcorrenciaModel();
		ocorrenciaModel.setTitulo(telaPanel.getTituloField().getText());
		ocorrenciaModel.setComboSetor(telaPanel.getSetorCombo().getSelectedItem().toString());
		ocorrenciaModel.setProblemas(telaPanel.getProblemaCombo().getSelectedItem().toString());
		ocorrenciaModel.setObservação(telaPanel.getComentario().getText());
		ocorrenciaModel.setProduto(telaPanel.getProdutoCombo().getSelectedItem().toString());
		ocorrenciaModel.setCnpj(nomeCliente.toString());
		ocorrenciaModel.setComboSetor(telaPanel.getSetorCombo().getSelectedItem().toString());
		ocorrenciaModel.setNomeCliente(getNomeCliente());
		ocorrenciaModel.setIdProduto(telaPanel.getProdutoCombo().getSelectedIndex()+1);
	
		ocorrencia.save(ocorrenciaModel); 
		clearFields();
	}

	private void clearFields() {
		
		List<JTextField> fields = Arrays.asList(
				telaPanel.getTituloField());
		
		for (JTextField jTextField : fields) {
			clearField(jTextField);
		}
		telaPanel.getProblemaCombo().setSelectedIndex(0);
		telaPanel.getComentario().setText(null);
		telaPanel.getSetorCombo().setSelectedIndex(0);
	}
	
	private void clearField(JTextField textField) {
		textField.setText(null);
	}
	
	public String getNumero() {
		return numero;
	}
	
	public JPanel getComponent() {
		telaPanel.atualizaTabela(ocorrencia.getAll(nomeCliente));
		return telaPanel;
	}
	
	public JPanel getProdutoCombo() {
		telaPanel.produtoComboBox(comboBox.produto());
		return telaPanel;
	}
	
	public JPanel getSetorCombo() {
		telaPanel.setorComboBox(comboBox.setor());
		return telaPanel;
	}
}
