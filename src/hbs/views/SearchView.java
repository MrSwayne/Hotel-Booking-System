package hbs.views;


import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class SearchView extends View
{
	
	private JTextField searchField;
	private JButton searchBtn;
	private JTable table;
	JPanel searchPanel = new JPanel();

	
	public SearchView()
	{
		this.setTitle("Search");
		searchPanel= new JPanel(new GridLayout(3,3));
		
		JPanel search= new JPanel();
		JLabel searchLabel= new JLabel("Search: ",JLabel.LEFT);
		searchField= new JTextField("",10);
		search.add(searchLabel);
		search.add(searchField);
		
		JPanel control= new JPanel();
		searchBtn= new JButton("Search");
		control.add(searchBtn);
		
		String tempData[][]= {  {"0","DateIn","DateOut","Gid","Rid"};
								{"1","DateIn","DateOut","Gid","Rid"};
								{"2","DateIn","DateOut","Gid","Rid"}};
		
		String column[]= {"ID","Date In","Date Out"};
		final JTable table= new JTable(tempData,column);
		
		//Allows the selection of user
		table.setCellSelectionEnabled(true);
		ListSelectionModel select= table.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener()
				{
					public void valueChanged(ListSelectionEvent e)
					{
						String tempData=null;
						 int[] row = table.getSelectedRows();  
			                int[] columns = table.getSelectedColumns();  
			                for (int i = 0; i < row.length; i++)
			                {  
			                  for (int j = 0; j < columns.length; j++)
			                  {  
			                    tempData = (String) table.getValueAt(row[i], columns[j]);  
			                  } } 
			                //Call for SELECT * FROM bookings WHERE Gid=selected
			                //Adds result set to Arraylist to be used in Payment manager
		              }       
		            });  
		
		
		table.setBounds(30,40,200,300);
		
		JScrollPane sp=new JScrollPane(table);
		
		search.add(sp);
		search.setSize(300,400);
		search.setVisible(true);		
	
	}
	
	public String getSearch()
	{
		return searchField.getText();
	}
	
	public void addSearchListener(ActionListener listen)
	{
		searchBtn.addActionListener(listen);
	}
}

