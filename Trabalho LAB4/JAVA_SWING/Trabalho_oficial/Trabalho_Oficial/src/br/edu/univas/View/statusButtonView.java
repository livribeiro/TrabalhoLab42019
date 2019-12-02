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

import br.edu.univas.Controller.statusController;


class statusButtonView extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener{
	
	public JTable table;
	public JButton renderButton;
	public JButton editButton;
	public String text; 
	alteraStatusView statusView;
	statusController controller;
	
	
	public statusButtonView(JTable table, int column)
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
	    renderButton.setText( (value == null) ? "Status" : value.toString() );
	    return renderButton;
	}
	
	public Component getTableCellEditorComponent( JTable table, Object value, boolean isSelected, int row, int column)
	{
	    text = (value == null) ? "Status" : value.toString();
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
			new statusController(table.getValueAt(table.getSelectedRow(),0).toString());		
			fireEditingStopped();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
