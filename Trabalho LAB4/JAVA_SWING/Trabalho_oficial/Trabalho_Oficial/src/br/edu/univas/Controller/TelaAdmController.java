package br.edu.univas.Controller;

import java.sql.SQLException;

import javax.swing.JPanel;

import br.edu.univas.DAO.ocorrenciaDAO;
import br.edu.univas.View.TelaAdminPanel;


public class TelaAdmController {
	private TelaAdminPanel telaAdm;
	private ocorrenciaDAO dao;
	String setor;
	
	public TelaAdmController() throws SQLException {
		dao = new ocorrenciaDAO();
		telaAdm = new TelaAdminPanel();
		getComponent();
	}
	
	public void setNome(String numUsuario) {
		setor = numUsuario;
		setSetor(setor);
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public String getSetor() {
		return setor;
	}

	public JPanel getComponent() {
		telaAdm.atualizaTabela(dao.getAllAdm(setor));
		return telaAdm;
	}
}
