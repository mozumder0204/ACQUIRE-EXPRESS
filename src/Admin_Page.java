import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

import DBconnection.DBconnector;

public class Admin_Page extends JPanel {
	
	private static Admin_Page refer;
	
	private JTable table;

	String S1  , S2  , S3  , S4  , S5   ;

	DefaultTableModel model = new DefaultTableModel(new String[]{"ID" , "Name" , "Details" , "Price" , "Offer"}, 0);

	
	public Admin_Page(){
		readData ();
		addComponent();
	
		}

	public static Admin_Page  getRefer(){
		if(refer==null){
			refer = new Admin_Page();
		}
		return refer;
	}

	public void addComponent(){
		
		this.table=new JTable();    	
		this.table.setBounds(10, 200, 400, 200);
		table.setModel(model);
		
		this.table.setBounds(10,200,450,150);
		this.table.setPreferredScrollableViewportSize(new Dimension(400,300));
		 this.table.setFillsViewportHeight(true);
		 this.table.setCellSelectionEnabled(true);
		 table.setEnabled(true);
		this.table.getTableHeader().setReorderingAllowed(false);
		
		 JScrollPane sp = new JScrollPane(this.table);
	   sp.setViewportView(this.table);
	    add(sp, BorderLayout.CENTER);
		//this.add(this.table);       
		this.add(sp);   
	
	}

	public void readData () {
		
		DBconnector DC = new DBconnector();
		ResultSet rs;
		String query="select * from product_info";
		rs=DC.getData(query);				
		try{
			while(rs.next())
			{
				String S1 = rs.getString("Product_id");
				String S2 = rs.getString("Product_name");
				String S3 = rs.getString("Product_details");
				String S4 = rs.getString("Product_price");
				String S5= rs.getString("Product_offers");

				  //System.out.println(S1 + "	" + S2 +"	"  +S3 + "		" + S4 + "		"  + S5 );
				  model.addRow(new Object[]{S1, S2, S3, S4, S5 });						
			}

		}catch(Exception ee){
			ee.printStackTrace();
		}
	
	}
}
