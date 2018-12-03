package hbs.views;


/*
 * 
 * I don't know why I pushed this, it doesn't even work but I wasted hours on it so it's going up there anyway
 * 
 * It's *supposed* to create a jtable of bookings in which a user can select bookings, these bookings are
 * then forwarded to the payment screen so that the user can then pay for each booking.
 * 
 * Long story short: It doesn't work
 * Short story long: It executes queries based on what you type in the search box to refine (Lol don't sql inject tho for the
 * 					 love of god I didn't sanitise the inputs) 
 * 					 Then it is supposed to return this query and the jtable is to be updated, it returns the query but the table
 * 					 JUST. WONT. UPDATE.
 * 
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import hbs.core.BookingTable;
import hbs.views.HintTextField;
import hbs.database.Query;
public class SelectBookingView extends View implements ActionListener {

	private JPanel container = new JPanel();
	private JButton searchButton = new JButton("Search");
	private JButton okButton = new JButton("Ok");
	private JPanel searchPanel = new JPanel();
	private JTable table;
	private BookingTable tableModel = new BookingTable();
	private ArrayList<HintTextField> fields = new ArrayList<>();
	private JScrollPane scrollPane = new JScrollPane();
	
	public SelectBookingView() {
		okButton.addActionListener(this);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
		this.setTitle("Select Booking");
		
		String[] columnNames = {"Bid", "DateIn", "DateOut", "Gid", "Rid"};
		
		for(int i = 0;i < columnNames.length;i++) {
			HintTextField field = new HintTextField(columnNames[i]);
			fields.add(field);
			searchPanel.add(field);
		}
		
		Object[][] data = {};
		
		searchPanel.add(searchButton);
		
		tableModel.update(data, columnNames);
		setupTable(tableModel);

		container.add(searchPanel);
		container.add(scrollPane);
		
		this.add(container);
		this.pack();
		this.setVisible(true);
	}
	
	private void setupTable(BookingTable tableModel) {
		scrollPane.removeAll();
		table = new JTable(tableModel);
		table.setFillsViewportHeight(true);	
		scrollPane.add(table);
		scrollPane.repaint();
		container.repaint();
	}

	public void updateTable(Query query) {
		String[] columnNames = new String[query.getColumnSize()];
		Object[][] data = new Object[query.size()][columnNames.length];
		for(int i = 0;i < columnNames.length;i++) {
			columnNames[i] = query.getColumnName(i);
		}
		for(int i = 0;i < query.size();i++) {
			System.out.println();
			for(int j = 0;j < columnNames.length;j++) {
				data[i][j] = query.get(i).get(columnNames[j]);
			}
		}
		tableModel.update(data, columnNames);
		setupTable(tableModel);
		searchPanel.add(searchButton);
	}
	
	public void addSearchListener(ActionListener listen) {
		searchButton.addActionListener(listen);
	}
	
	@Override
	public void setMessage(String message) {
	}
	
	public ArrayList<HintTextField> getFields() {
		return this.fields;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		
	}
}
