 package br.edu.univas.View;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.Listener.saveReg;
import br.edu.univas.Model.OcorrenciaModel;
import br.edu.univas.Model.produtoModel;
import br.edu.univas.Model.setorModel;

public class TelaUsuarioPanel extends JPanel{
	
	private JTextField tituloField;
	private JTextArea comentario;
	private JComboBox<String> setorCombo;
	private JComboBox<String> problemaCombo;
	private JComboBox<String> produtoCombo;
	private saveReg save;
	private JPanel centerPanel;
	private JPanel oestePanel;
	private JTable tabela;
	OcorrenciaModel ocorrencia;
	MainView mainView;
	String numero;
	int idproduto, iddepartamento;

	public int getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}

	public int getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public TelaUsuarioPanel() {
		addComponents();
	}
	
	public void setListener(saveReg listener) {
		this.save = listener;
	}
	
	public void addComponents() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		
		centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setMinimumSize(new Dimension(1000, 600));
		centerPanel.setPreferredSize(new Dimension(900, 900));
		tabela(centerPanel);
		this.add(centerPanel, BorderLayout.CENTER);
		
		oestePanel = new JPanel(new GridBagLayout());
		oestePanel.setPreferredSize(new Dimension(430, 1000));
		oestePanel.setBackground(Color.white);
		regOcorrencia(oestePanel);
		this.add(oestePanel, BorderLayout.WEST);
	}
	
	public void regOcorrencia(JPanel panel) {
		GridBagConstraints gbc = new GridBagConstraints();
		
		String titulos [] = {"Produto: "," ","Título: ","  ", "Setor: ","  ", "Problemas: ","  ", "Observações:"};
		for(int i=0;i < titulos.length;i++) {
			JLabel titulo = new JLabel(titulos[i]);
			titulo.setFont(new Font("bold", Font.PLAIN, 18));
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.weightx = 1.0;
			gbc.gridwidth = 3;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.LINE_START;
			gbc.insets = new Insets(5,25,5,55);
			panel.add(titulo, gbc);
		}
		
		produtoCombo = new JComboBox<String>();
		produtoCombo.setBackground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,25,5,55);
		panel.add(produtoCombo, gbc);
		
		tituloField = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,25,5,55);
		panel.add(tituloField, gbc);
		
		setorCombo = new JComboBox<String>();
		setorCombo.setBackground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,25,5,55);
		panel.add(setorCombo, gbc);
		
		String problemas [] = {"Garantia", "Devolução", "Avaria no Aparelho", "Incidente/Falha"};
		problemaCombo = new JComboBox<String>(problemas);
		problemaCombo.setBackground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,25,5,55);
		panel.add(problemaCombo, gbc);
		
		comentario = new JTextArea();
		comentario.setRows(10);
		comentario.setLineWrap(true);
		comentario.setWrapStyleWord(true);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		comentario.setBorder(border);
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,25,5,55);
		panel.add(comentario, gbc);
		
		JButton saveButton = new JButton();
		saveButton.setText("Salvar");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				save.saveReg();	
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.gridwidth = 2;
		gbc.weightx = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		panel.add(saveButton, gbc);
		
	}

	public JComboBox<String> getProdutoCombo() {
		return produtoCombo;
	}

	public void setProdutoCombo(JComboBox<String> produtoCombo) {
		this.produtoCombo = produtoCombo;
	}

	public void tabela(JPanel panel) {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Historico de Ocorrências");
		headerLabel.setFont(new Font("bold", Font.PLAIN, 25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(headerLabel, gbc);
		
		Vector<String> columns = new Vector<>();
		columns.add("Nº Protocolo");
		columns.add("Data");
		columns.add("Produto");
		columns.add("Titulo");
		columns.add("Setor");
		columns.add("Problema");
		columns.add("Status");
		columns.add("");
		
	
		tabela = new JTable(null, columns);
		JScrollPane tableScrollPane = new JScrollPane(tabela);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(300);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(150);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(10,10,10,40);
		panel.add(tableScrollPane, gbc);
		
		visualizaRespostaButtonView botao2 = new visualizaRespostaButtonView(tabela, 7);

	}
	
	public void atualizaTabela(ArrayList<OcorrenciaModel> ocorrencias) {
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		
		model.setRowCount(0);
		for (OcorrenciaModel ocorrencia : ocorrencias) {
			model.addRow(new Object[] {
				ocorrencia.getProtocolo(),
				ocorrencia.getData(),
				ocorrencia.getProduto(),
				ocorrencia.getTitulo(),
				ocorrencia.getComboSetor(),
				ocorrencia.getProblemas(),
				ocorrencia.getStatus()
			});
		}
	}
	
	public void produtoComboBox(ArrayList<produtoModel> produto) {
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) produtoCombo.getModel();
		
		for (produtoModel produtos : produto) {
			model.addElement(produtos.getNome() + " " + produtos.getCodProduto());
		}
	}
	
	public void setorComboBox(ArrayList<setorModel> setor) {
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) setorCombo.getModel();
		
		for (setorModel setores : setor) {
			model.addElement(setores.getNomeSetor());
		}
	}
	
	public void logOut(JPanel panel){
		
		GridBagConstraints gbc = new GridBagConstraints();
		Button logout = new Button("Sair");
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(20,10,20,10);
		panel.add(logout, gbc);
	}
	
	
	public JTextArea getComentario() {
		return comentario;
	}

	public void setComentario(JTextArea comentario) {
		this.comentario = comentario;
	}

	public JComboBox getSetorCombo() {
		return setorCombo;
	}

	public void setSetorCombo(JComboBox setorCombo) {
		this.setorCombo = setorCombo;
	}

	public JTextField getTituloField() {
		return tituloField;
	}

	public void setTituloField(JTextField tituloField) {
		this.tituloField = tituloField;
	}

	public JComboBox<String> getProblemaCombo() {
		return problemaCombo;
	}

	public void setProblemaCombo(JComboBox<String> problemaCombo) {
		this.problemaCombo = problemaCombo;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
}
