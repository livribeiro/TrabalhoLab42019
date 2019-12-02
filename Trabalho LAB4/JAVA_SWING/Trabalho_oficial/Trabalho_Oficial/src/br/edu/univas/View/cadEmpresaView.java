package br.edu.univas.View;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.Listener.saveReg;
import br.edu.univas.Listener.tableButtons;

public class cadEmpresaView extends JFrame {
	private JPanel content;
	saveReg save;
	public JTextField nomeField;
	public JTextField CNPJField;
	public JTextField enderecoField;
	public JTextField telefoneField;
	public JTextField emailField;
	public JTextField responsavelField;
	
	

	public cadEmpresaView() {
		this.setTitle("Cadastrar Empresas/Clientes ::-::");
		this.setPreferredSize(new Dimension(600, 600));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setContent();
		addComponent();
	}
	
	private void setContent() {
		content = new JPanel(new GridBagLayout());
		this.setContentPane(content);
	}
	
	public void setListener(saveReg listener) {
		this.save = listener;
	}
	
	private void addComponent() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel altera = new JLabel("Cadastrar Empresa/Cliente:");
		altera.setFont(new Font("bold", Font.PLAIN, 25));
		altera.setForeground(Color.RED);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,10,10,10);
		content.add(altera, gbc);
		
		String titulos [] = {" ", "Nome: "," ","CNPJ: "," ","Endereço: "," ","Telefone: "," ","Email: "," ", "Responsáveis: "};
		for(int i=1;i<titulos.length;i++) {
			JLabel titulo = new JLabel(titulos[i]);
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.fill = GridBagConstraints.NONE;
			gbc.anchor = GridBagConstraints.LINE_START;
			content.add(titulo,gbc);
		}
		
		nomeField = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		content.add(nomeField,gbc);
		
		CNPJField = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		content.add(CNPJField,gbc);
		
		enderecoField = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		content.add(enderecoField,gbc);
		
		telefoneField = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		content.add(telefoneField,gbc);
		
		emailField = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		content.add(emailField,gbc);
		
		responsavelField = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		content.add(responsavelField,gbc);
		
		
		JButton salvar = new JButton("Salvar");
		gbc.gridx = 1;
		gbc.gridy = 15;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(10,20,30,10);
		gbc.anchor = GridBagConstraints.LINE_END;
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save.saveReg();
			}
		});
		content.add(salvar,gbc);
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getCNPJField() {
		return CNPJField;
	}

	public void setCNPJField(JTextField cNPJField) {
		CNPJField = cNPJField;
	}

	public JTextField getEnderecoField() {
		return enderecoField;
	}

	public void setEnderecoField(JTextField enderecoField) {
		this.enderecoField = enderecoField;
	}

	public JTextField getTelefoneField() {
		return telefoneField;
	}

	public void setTelefoneField(JTextField telefoneField) {
		this.telefoneField = telefoneField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	public JTextField getResponsavelField() {
		return responsavelField;
	}

	public void setResponsavelField(JTextField responsavelField) {
		this.responsavelField = responsavelField;
	}
}
