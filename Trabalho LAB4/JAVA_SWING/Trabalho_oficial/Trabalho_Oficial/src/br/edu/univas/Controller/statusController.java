package br.edu.univas.Controller;

import java.sql.SQLException;

import br.edu.univas.DAO.ocorrenciaDAO;
import br.edu.univas.Listener.tableButtons;
import br.edu.univas.Model.OcorrenciaModel;
import br.edu.univas.View.alteraStatusView;


public class statusController {
	
	private alteraStatusView status;
	private ocorrenciaDAO ocorrencia;
	private OcorrenciaModel ocorrenciaModel;
	
	public statusController(String id) throws SQLException {
		ocorrencia = new ocorrenciaDAO();
		status = new alteraStatusView(id);
		status.pack();
		status.setVisible(true);
		status.setLocationRelativeTo(null);
		status.setListener(new tableButtons() {
			
			@Override
			public void responde() {
				
			}
			
			@Override
			public void altStatus() {
				statusAlterado(status.getValorStatus(), id);
				fechar();
			}
		});
	}
	
	public void statusAlterado(String Status, String id) {
			ocorrencia.updateStatus(ocorrenciaModel, Status, id);
	}

	public void fechar() {
		status.setVisible(false);
		status.dispose();
	}
	
}
