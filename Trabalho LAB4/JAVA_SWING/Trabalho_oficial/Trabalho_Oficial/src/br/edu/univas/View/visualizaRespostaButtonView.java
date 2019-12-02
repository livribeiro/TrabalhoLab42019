package br.edu.univas.View;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import br.edu.univas.Controller.TelaAdmController;
import br.edu.univas.Controller.respondeController;
import br.edu.univas.Controller.visualizaRespostaController;
import br.edu.univas.Listener.tableButtons;
import br.edu.univas.Model.OcorrenciaModel;

class visualizaRespostaButtonView extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener{
	
	public JTable table;
	public JButton renderButton;
	public JButton editButton;
	public String text; 
	tableButtons botao;
	public visualizaRespostaView responde;
	OcorrenciaModel ocorrencia;
	visualizaRespostaController resposta;
	TelaAdmController telaAdm;
	
	
	public visualizaRespostaButtonView(JTable table, int column)
	{
	    super();
	    this.table = table;
	    renderButton = new JButton();
	    editButton = new JButton();
	    editButton.setFocusPainted( true );
	    editButton.addActionListener( this );
	    TableColumnModel columnModel = table.getColumnModel();
	    columnModel.getColumn(column).setCellRenderer( this );
	    columnModel.getColumn(column).setCellEditor( this );
	    ocorrencia = new OcorrenciaModel();

	}
	
	public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
	    if (hasFocus)
	    {
	        renderButton.setForeground(table.getForeground());
	        renderButton.setBackground(UIManager.getColor("Button.background"));
	    }
	    else if (isSelected)
	    {
	        renderButton.setForeground(table.getSelectionForeground());
	         renderButton.setBackground(table.getSelectionBackground());
	    }
	    else
	    {
	        renderButton.setForeground(table.getForeground());
	        renderButton.setBackground(UIManager.getColor("Button.background"));
	    }
	    renderButton.setText( (value == null) ? "Observações" : value.toString() );
	    return renderButton;
	}
	
	public Component getTableCellEditorComponent( JTable table, Object value, boolean isSelected, int row, int column)
	{
	    text = (value == null) ? "Observações" : value.toString();
	    editButton.setText( text );
	    return editButton;
	}
	
	public Object getCellEditorValue()
	{
	    return text;
	}
	
	public void actionPerformed(ActionEvent e)
	{
	  try {
		new visualizaRespostaController(table.getValueAt(table.getSelectedRow(),0).toString(),
				  table.getValueAt(table.getSelectedRow(), 3).toString(),
				  table.getValueAt(table.getSelectedRow(), 4).toString());
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	  fireEditingStopped();
	}
}
