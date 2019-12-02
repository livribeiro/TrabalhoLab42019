package br.edu.univas.Controller;

import java.awt.Component;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.univas.DAO.autenticacaoDAO;
import br.edu.univas.Listener.enterButton;
import br.edu.univas.Listener.sairButton;
import br.edu.univas.View.MainView;


public class MainController {
	
	private MainView mainView;
	private TelaAdmController telaAdm;
	private TelaUsuarioController telaController;
	String auth = "", nomeCliente;
	autenticacaoDAO autentica;
	
	public MainController() throws SQLException {
		autentica = new autenticacaoDAO();
		mainView = new MainView();
		telaController = new TelaUsuarioController();
		telaAdm = new TelaAdmController();
	}
	
	public void initApp() {	
		mainView.setListener(new enterButton() {
			
			@Override
			public void usuarioButton() {
				auth = mainView.getNumCnpj().getText();
				if(autentica(mainView.getNumCnpj().getText())){
					telaController.setNumero(auth);
					showUsuarioPanel();
				}else {
					JOptionPane.showMessageDialog(mainView, "Por favor informe um número válido!","Acesso Negado",JOptionPane.WARNING_MESSAGE);
				}
										
			}
			
			@Override
			public void admButton() {

				auth = mainView.getNumAdm().getText();
				if(autenticaAdm(mainView.getNumAdm().getText())){
					showAdminPanel();
				}else {
					JOptionPane.showMessageDialog(mainView, "Por favor informe um número válido!","Acesso Negado",JOptionPane.WARNING_MESSAGE);
				} 				
			}

			@Override
			public void sairButton() {
				
			}   

		});
		mainView.setListenerSair(new sairButton() {
			
			@Override
			public void sair() {
				mainView.dispose();
				mainView.setVisible(true);
			}
		});
		mainView.setVisible(true);
	}

	
	private void showAdminPanel() {
		showPanel(telaAdm.getComponent());
	}
	
	private void showUsuarioPanel() {
		showPanel(telaController.getComponent());
	}
	
	private void showPanel(Component component) {
		mainView.getCenterPanel().removeAll();
		mainView.getCenterPanel().add(component);
		mainView.getCenterPanel().revalidate();
		mainView.getCenterPanel().repaint();

	}
	
	
	private boolean autentica(String valor) {
		
		for(int i=0;i < autentica.autenticaUsuario().size();i++){			
			if(autentica.autenticaUsuario().get(i).getCnpj().equals(valor)) {
				telaController.setNomeCliente(autentica.autenticaUsuario().get(i).getNomeSetor());
				mainView.setUsuario(autentica.autenticaUsuario().get(i).getNomeSetor());
				return true;
			}
		}
		return false;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	private boolean autenticaAdm(String valor) {		
		int valores = Integer.parseInt(valor);
		for(int i=0;i < autentica.autenticaAdm().size();i++){			
			if(autentica.autenticaAdm().get(i).getSetor() == valores) {			
				telaAdm.setNome(autentica.autenticaAdm().get(i).getNomeSetor().toString());
				mainView.setUsuario(autentica.autenticaAdm().get(i).getNomeSetor().toString());
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	private void clearFields() {
		
		List<JTextField> fields = Arrays.asList(
				mainView.getNumAdm());
		
		for (JTextField jTextField : fields) {
			clearField(jTextField);
		}
	}
	
	private void clearField(JTextField textField) {
		textField.setText(null);
	}
	
}
	
