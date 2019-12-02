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
import java.util.Vector;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.Controller.cadEmpresaController;
import br.edu.univas.Model.OcorrenciaModel;

public class TelaAdminPanel extends JPanel{
	
	private JPanel centerPanel;
	private JPanel nortePanel;
	private JTable tabela;
	
	public TelaAdminPanel() throws SQLException {
		addComponents();
	}
	
	public void addComponents() {
		
		this.setLayout(new BorderLayout());
		
		Border whiteLine = BorderFactory.createLineBorder(Color.lightGray);	
		nortePanel = new JPanel(new GridBagLayout());
		nortePanel.setBorder(whiteLine);
		nortePanel.setPreferredSize(new Dimension(0, 60));
		nortePanel.setBackground(new Color(180,226,231));
		topButton(nortePanel);	
		this.add(nortePanel, BorderLayout.NORTH);
		
		
		centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(Color.white);
		centerPanel.setMinimumSize(new Dimension(1400, 600));
		centerPanel.setPreferredSize(new Dimension(1600, 900));
		regOcorrencia(centerPanel);
		this.add(centerPanel, BorderLayout.CENTER);
		
	}
	
	private void regOcorrencia(JPanel panel){
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Registro de Ocorr�ncias");
		headerLabel.setFont(new Font("bold", Font.PLAIN, 25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(headerLabel, gbc);
		
		Vector<String> columns = new Vector<>();
		columns.add("N� Protocolo");
		columns.add("Revendedor/Cliente");
		columns.add("Produto");
		columns.add("Titulo");
		columns.add("Data");
		columns.add("Problema");
		columns.add("Status");
		columns.add("Setor");
		columns.add("");
		columns.add("");
	
		tabela = new JTable(null, columns);
		tabela.setBackground(Color.white);
		JScrollPane tableScrollPane = new JScrollPane(tabela);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(20);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(60);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(60);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(60);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(20);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(60);
		tabela.getColumnModel().getColumn(9).setPreferredWidth(60);
		
		
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tabela.setColumnSelectionAllowed(false);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		panel.add(tableScrollPane, gbc);
		
		statusButtonView botao = new statusButtonView(tabela, 8);
		respondeButtonView botao2 = new respondeButtonView(tabela, 9);
	}
	
	public void topButton(JPanel panel) {
		
			GridBagConstraints gbc = new GridBagConstraints();
			
			JButton regEmpresa = new JButton("Cadastrar Empresas");
			regEmpresa.setSize(new Dimension(100,70));
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.NONE;
			gbc.anchor = GridBagConstraints.LINE_START;
			gbc.weightx = 1.0;
			gbc.insets = new Insets(20,20,20,20);
			regEmpresa.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new cadEmpresaController();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			panel.add(regEmpresa, gbc);
	}
	
	public void atualizaTabela(ArrayList<OcorrenciaModel> ocorrencias) {
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.isCellEditable(1, 9);
		
		model.setRowCount(0);
		
		for (OcorrenciaModel ocorrencia : ocorrencias) {
			model.addRow(new Object[] {
				ocorrencia.getProtocolo(),
				ocorrencia.getNomeCliente(),
				ocorrencia.getProduto(),
				ocorrencia.getTitulo(),
				ocorrencia.getData(),
				ocorrencia.getProblemas(),
				ocorrencia.getStatus(),
				ocorrencia.getComboSetor()
			});
		}

	}
	
}
