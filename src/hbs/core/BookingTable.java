package hbs.core;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class BookingTable extends AbstractTableModel implements TableModelListener {

	private String[] columnNames;
	private Object[][] data;
	
	public BookingTable(Object[][] data, String[] columnNames) {
		this.data = data;
		this.columnNames = columnNames;
	}
	
	public BookingTable() {
		data = new Object[0][0];
		columnNames = new String[0];
		}

	public void update(Object[][] data, String[] columnNames) {
		this.data = data;
		this.columnNames = columnNames;
		this.fireTableDataChanged();
	}
	
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return data[arg0][arg1];
	}
	
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
	}
}
