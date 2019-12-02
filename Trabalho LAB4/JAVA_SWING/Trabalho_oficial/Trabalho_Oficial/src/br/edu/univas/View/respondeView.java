package br.edu.univas.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import br.edu.univas.Controller.respondeController;
import br.edu.univas.Listener.saveReg;
import br.edu.univas.Model.OcorrenciaModel;
import br.edu.univas.Model.mensagemModel;

public class respondeView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel centerPanel;
	private JPanel nortePanel;
	private JPanel sulPanel;
	OcorrenciaModel ocorrencia;
	respondeController controller;
	String numero, titulo, saveComentario;
	public JTextArea coment, observacao;
	private saveReg save;
	public JList<String> listTeste;
	
	public respondeView(String n, String titulo) {
		ocorrencia = new OcorrenciaModel();
		numero = n;
		this.titulo = titulo;
		this.setTitle("Reponder ao Usuário ::-::");
		this.setPreferredSize(new Dimension(500,500));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addComponent();
	}

	private void addComponent() {
		this.setLayout(new BorderLayout());
		
		nortePanel = new JPanel(new GridBagLayout());
		nortePanel.setPreferredSize(new Dimension(0,70));
		header(nortePanel);
		this.add(nortePanel, BorderLayout.NORTH);
		
		centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setPreferredSize(new Dimension(0,300));
		comentario(centerPanel);
		this.add(centerPanel, BorderLayout.CENTER);
		
		sulPanel = new JPanel(new GridBagLayout());
		sulPanel.setPreferredSize(new Dimension(0,200));
		sulPanel(sulPanel);
		this.add(sulPanel, BorderLayout.SOUTH);		
	}

	public void header(JPanel panel) {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel header = new JLabel("Ocorrência de Nº " + numero);
		header.setFont(new Font("bold", Font.PLAIN, 25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(header, gbc);
		
		JLabel titulo = new JLabel(this.titulo);
		titulo.setFont(new Font("bold", Font.PLAIN, 20));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10,10,10,10);
		panel.add(titulo, gbc);
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setListener(saveReg listener) {
		this.save = listener;
	}
	
	public void comentario(JPanel panel) {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		listTeste = new JList<String>();
		listTeste.setFont(new Font("bold", Font.PLAIN, 15));
		listTeste.setAutoscrolls(true);
		
		JTextArea area = new JTextArea();
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		
		JScrollPane list = new JScrollPane();
		list.getViewport().add(listTeste);
		list.setPreferredSize(new Dimension(0,170));
		list.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		list.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		panel.add(list, gbc);
		
	}
	
	public void sulPanel(JPanel panel) {
		GridBagConstraints gbc = new GridBagConstraints();
		
		coment = new JTextArea();
		coment.setColumns(10);
		coment.setRows(10);
		coment.setLineWrap(true);
		coment.setWrapStyleWord(true);
		coment.setMargin(new Insets(10,10,10,10));
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		coment.setBorder(border);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(coment, gbc);
		
		JButton saveButton = new JButton("Salvar");
		saveButton.setSize(new Dimension(200,70));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5,5,5,5);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				save.saveReg();
			}
		});
		panel.add(saveButton, gbc);
		
	}

	public JTextArea getComent() {
		return coment;
	}

	public void setComent(JTextArea coment) {
		this.coment = coment;
	}

	public void showMensagem(ArrayList<mensagemModel> mensagem) throws SQLException {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (mensagemModel mensagemModel : mensagem) {
			model.addElement(mensagemModel.getMensagem() + "           em:" + mensagemModel.getData());
			listTeste.setModel(model);
		}
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}
}
