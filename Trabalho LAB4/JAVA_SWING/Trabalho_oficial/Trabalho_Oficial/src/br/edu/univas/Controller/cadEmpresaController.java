package br.edu.univas.Controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.univas.DAO.ocorrenciaDAO;
import br.edu.univas.Listener.saveReg;
import br.edu.univas.Model.empresaModel;
import br.edu.univas.View.cadEmpresaView;

public class cadEmpresaController {
	
	public cadEmpresaView empresaView;
	private ocorrenciaDAO dao;
	empresaModel empresa;
	
	public cadEmpresaController() throws SQLException {
		dao = new ocorrenciaDAO();
		empresa = new empresaModel();
		empresaView = new cadEmpresaView();
		empresaView.pack();
		empresaView.setVisible(true);
		empresaView.setLocationRelativeTo(null);
		empresaView.setListener(new saveReg() {
			
			@Override
			public void saveReg() {
				saveEmpresa();
			}
		});
		
	}

	
	public void saveEmpresa() {
		try {
			empresa = new empresaModel();
			empresa.setNome(empresaView.getNomeField().getText());
			empresa.setCnpj(empresaView.getCNPJField().getText());
			empresa.setEndereco(empresaView.getEnderecoField().getText());
			empresa.setTelefone(empresaView.getTelefoneField().getText());
			empresa.setEmail(empresaView.getEmailField().getText());
			empresa.setResponsavel(empresaView.getResponsavelField().getText());
			
			dao.cadEmpresa(empresa);
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso", "Cadastro ::-::", JOptionPane.INFORMATION_MESSAGE);
			clearField();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar!! Tente novamente...", "Cadastro ::-::", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void clearField() {
		
		List<JTextField> fields = Arrays.asList(
				empresaView.getNomeField(),
				empresaView.getCNPJField(),
				empresaView.getEnderecoField(),
				empresaView.getTelefoneField(),
				empresaView.getEmailField(),
				empresaView.getResponsavelField()
				);
		
		for (JTextField jTextField : fields) {
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField) {
		textField.setText(null);
	}
}
