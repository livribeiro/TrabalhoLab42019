package br.edu.univas.Controller;

import java.sql.SQLException;

import javax.swing.JPanel;

import br.edu.univas.DAO.observacaoDAO;
import br.edu.univas.View.TelaUsuarioPanel;
import br.edu.univas.View.visualizaRespostaView;


public class visualizaRespostaController {
	private TelaUsuarioPanel telaPanel;
	private visualizaRespostaView responde;
	observacaoDAO observacao;
	String numero, titulo, departamento;
	
	public visualizaRespostaController(String n, String titulo, String departamento) throws SQLException {
		observacao = new observacaoDAO();
		responde = new visualizaRespostaView(n, titulo);
		responde.pack();
		this.titulo = titulo;
		this.numero = n;
		this.departamento = departamento;
		getMensagem();
		responde.setVisible(true);
		responde.setLocationRelativeTo(null);
	}
	
	public JPanel getMensagem() throws SQLException {
		responde.showMensagem(observacao.showMensagemUsuario(titulo,departamento));
		return telaPanel;
	}
	
}
