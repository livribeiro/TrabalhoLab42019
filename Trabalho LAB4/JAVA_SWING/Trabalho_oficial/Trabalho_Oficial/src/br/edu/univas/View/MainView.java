package br.edu.univas.View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.Listener.enterButton;
import br.edu.univas.Listener.sairButton;
import br.edu.univas.Model.UsuarioModel;

public class MainView extends JFrame{
	
	private JPanel centerPanel = new JPanel();
	enterButton enter;
	sairButton logOut;
	private JTextField numCnpj;
	private JTextField numAdm;
	String usuario;
	UsuarioModel usuarioModel;
	String path = "/br/edu/univas/img/";
	sairButton sairListener;
	    
	public MainView() {
		Image img = new ImageIcon(getClass().getResource(path + "LogoLogo.png")).getImage().getScaledInstance(700, 700, java.awt.Image.SCALE_DEFAULT);	
		this.setIconImage(img);
		this.setTitle("Serviço de Atendimento ::-:: ");
		this.setMinimumSize(new Dimension(1200, 700));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		try {
			addComponent();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public JPanel getCenterPanel(){
		return centerPanel;
	}
	
	public JPanel getComponent() {
		return centerPanel;
	}

	public void setListener(enterButton enterButton) {
		this.enter = enterButton;
	}
	
	public void setListenerSair(sairButton sair) {
		this.sairListener = sair;
	}

	public void addComponent() throws IOException {	
		this.setLayout(new BorderLayout());	
		JPanel nortePanel = new JPanel(new GridBagLayout());
		nortePanel.setPreferredSize(new Dimension(0, 100));
		nortePanel.setBackground(Color.WHITE);
		mensagem(nortePanel);
		ImagePanel(nortePanel);
		this.getContentPane().add(nortePanel, BorderLayout.NORTH);
		
		centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(new Color(180,226,231));
		login(centerPanel);
		acessar(centerPanel);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}
	
	
	
	public void mensagem(JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		
		JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Sair");
        menuBar.add(fileMenu);
        JMenuItem sairMenu = new JMenuItem("Sair");
        fileMenu.add(sairMenu);
        sairMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sairListener.sair();
			}
		});
		
		JLabel bemVindo = new JLabel("Bem-Vindo ao Serviço de Atendimento" );
		bemVindo.setFont(new Font("Bold", Font.PLAIN, 24));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(20,10,20,10);
		panel.add(bemVindo, gbc);
		
		JLabel nomeUsuario = new JLabel(usuario);
		nomeUsuario.setFont(new Font("Bold", Font.PLAIN, 12));
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		panel.add(nomeUsuario, gbc);
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void ImagePanel(JPanel panel) throws IOException {
		Image img = new ImageIcon(getClass().getResource(path + "trabalhoLogo.png")).getImage().getScaledInstance(450, 250, java.awt.Image.SCALE_SMOOTH);	
	    JLabel label = new JLabel(new ImageIcon(img));
	    label.setPreferredSize(new Dimension(400,100));
	    panel.add(label); 
	}
	
	public void login(JPanel panel){
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel sessaoUsuario = new JLabel("Sessão Para Usuários");
		sessaoUsuario.setFont(new Font("Bold", Font.PLAIN, 25));
		sessaoUsuario.setForeground(Color.RED);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,25,5,55);
		panel.add(sessaoUsuario, gbc);
		
		
		JLabel cnpj = new JLabel("Informe o CNPJ: ");
		cnpj.setFont(new Font("Bold", Font.PLAIN, 18));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,25,5,55);
		panel.add(cnpj, gbc);	
		
		numCnpj = new JTextField();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		panel.add(numCnpj, gbc);
		
		
		JLabel sessaoAdm = new JLabel("Sessão Para Administradores");
		sessaoAdm.setFont(new Font("Bold", Font.PLAIN, 25));
		sessaoAdm.setForeground(Color.RED);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,25,5,55);
		panel.add(sessaoAdm, gbc);
		
		JLabel adm = new JLabel("Informe o codigo do Setor: ");
		adm.setFont(new Font("Bold", Font.PLAIN, 18));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,25,5,55);
		panel.add(adm, gbc);	
		
		numAdm = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		panel.add(numAdm, gbc);
	}
	
	
	public JTextField getNumCnpj() {
		return numCnpj;
	}

	public void setNumCnpj(JTextField numCnpj) {
		this.numCnpj = numCnpj;
	}

	public JTextField getNumAdm() {
		return numAdm;
	}

	public void setNumAdm(JTextField numAdm) {
		this.numAdm = numAdm;
	}
	
	public void acessar(JPanel panel){
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JButton enterAdm = new JButton("Entrar");
		enterAdm.setPreferredSize(new Dimension(120, 50));
		enterAdm.setFont(new Font("Bold", Font.PLAIN, 15));
		enterAdm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				enter.admButton();
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5,25,5,55);
		panel.add(enterAdm, gbc);
		
		
		
		JButton enterUsuario = new JButton("Entrar");
		enterUsuario.setPreferredSize(new Dimension(120, 50));
		enterUsuario.setFont(new Font("Bold", Font.PLAIN, 15));
		enterUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enter.usuarioButton();
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5,25,5,55);
		panel.add(enterUsuario, gbc);
		
	}
	
	
}