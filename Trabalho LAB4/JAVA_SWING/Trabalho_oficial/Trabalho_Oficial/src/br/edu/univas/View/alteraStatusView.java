package br.edu.univas.View;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.Controller.statusController;
import br.edu.univas.Listener.tableButtons;
import br.edu.univas.Model.OcorrenciaModel;

public class alteraStatusView extends JFrame{
	
	private JPanel content;
	private tableButtons altStatus;
	private statusController status;
	private OcorrenciaModel ocorrencia;
	String id;
	String valorStatus;
	
	public alteraStatusView(String id) {
		this.id = id;
		ocorrencia = new OcorrenciaModel();
		this.setTitle("Alterar Status ::-::");
		this.setPreferredSize(new Dimension(400, 300));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new Color(180,226,231));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setContent();
		addComponent();
	}
	
	private void setContent() {
		content = new JPanel(new GridBagLayout());
		content.setBackground(new Color(180,226,231));
		this.setContentPane(content);
	}
	
	public void setListener(tableButtons listener) {
		this.altStatus = listener;
	}
	
	private void addComponent() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel altera = new JLabel("Alterar Status");
		altera.setFont(new Font("bold", Font.PLAIN, 25));
		altera.setForeground(Color.RED);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		content.add(altera, gbc);
		
		
		JRadioButton resolvido = new JRadioButton("Resolvido");
		resolvido.setActionCommand("Resolvido");
		resolvido.setBackground(new Color(180,226,231));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		content.add(resolvido,gbc);
		
		JRadioButton atendimento = new JRadioButton("Em Atendimento");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		atendimento.setActionCommand("Em Atendimento");
		atendimento.setBackground(new Color(180,226,231));
		content.add(atendimento,gbc);
		
		JRadioButton naoResolvido = new JRadioButton("Não Resolvido");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		naoResolvido.setActionCommand("Não Resolvido");
		naoResolvido.setBackground(new Color(180,226,231));
		content.add(naoResolvido,gbc);
		
		ButtonGroup group = new ButtonGroup();
		group.add(resolvido);
		group.add(atendimento);
		group.add(naoResolvido);
		
		
		JButton salvar = new JButton("Salvar");
		salvar.setPreferredSize(new Dimension(90,30));
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(50,20,20,20);
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setValorStatus(group.getSelection().getActionCommand());
				ocorrencia.setStatus(getValorStatus());
				altStatus.altStatus();
	
			}
		});
		content.add(salvar,gbc);
	}

	public String getValorStatus() {
		return valorStatus;
	}

	public void setValorStatus(String valorStatus) {
		this.valorStatus = valorStatus;
	}
	
}
