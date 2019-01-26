import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DBconnection.DBconnector;

public class Client_Page  extends JPanel implements ActionListener{
	
	private JLabel L1  ,  L2  ,  L3  ,  L4  ,  L5  ,  L6  ;
	
	private JTextField T1  ,  T2 ;
	
	private JTextArea A1  ,  A2  ;
	
	private JButton B1  ,  B2  ,  B3;

	private static Client_Page refer;
	
	public Client_Page(){

		addComponent();
		
		}
		
		public static Client_Page  getRefer(){
			if(refer==null){
				refer = new Client_Page();
			}
			
			return refer;
		}
	
		public  void addComponent(){
	
		this.setLayout(null);
		
		ImageIcon Main_Logo = new ImageIcon("LOGO2.png");	//Set Icon in Option Button
		Image img2 = Main_Logo.getImage();
		Image newimg2 = img2.getScaledInstance( 500 , 100 , java.awt.Image.SCALE_FAST);		//Insert & Resize Image
		Main_Logo = new ImageIcon(newimg2);
	
		this.L1 = new JLabel(Main_Logo);
		this.L1.setBounds(0,0,500,95);				// JLabel L1 for Main_Logo...	
		this.add(this.L1);
		

		ImageIcon Admin_Back_Log = new ImageIcon("LOG_Back_HP.jpg");	//Set Icon in Option Button
		Image img = Admin_Back_Log.getImage();
		Image newimg = img.getScaledInstance( 50 , 50 , java.awt.Image.SCALE_FAST);		//Insert & Resize Image
		Admin_Back_Log = new ImageIcon(newimg);
		
		
		this.B1 = new JButton(Admin_Back_Log);		// Create JButton B1 for back to Log In Page
		this.B1.setBounds(0,95,50,50);
		this.add(this.B1);
		
		this.B1.addActionListener (new Log_In_EventHandler());
		
		  this.L6 = new JLabel ("Product Information");
		  Font font1 = new Font("Lucida Sans Unicode" , Font.BOLD , 20);
		  this.L6.setBounds(140 , 110 , 500 ,30);
		  this.L6.setFont(font1);
		   this.add(this.L6);

	    this.L2 = new JLabel ("Product name :");
		this.L2.setBounds(20 , 150 , 100 ,10);
		this.add(this.L2);
		
		this.L3 = new JLabel ("Product details :");
		this.L3.setBounds(20 , 180 ,  100 , 10);
		this.add(this.L3);
		
		this.L4 = new JLabel ("Price :");
		this.L4.setBounds(20 , 280 , 100 , 10);
		this.add(this.L4);
		
		this.L5 = new JLabel ("Offer details :");
		this.L5.setBounds(20 , 300 , 100 , 10);
		this.add(this.L5);
	
		this.T1 = new JTextField();
		this.T1.setBounds(120 , 148 , 300 , 20);
		this.add(this.T1);
		
		this.T2 = new JTextField();
		this.T2.setBounds(120 , 275 , 300 , 20);
		this.add(this.T2);
		
		this.A1 = new JTextArea();
		this.A1.setLineWrap(true);					//  to go next line
		this.A1.setWrapStyleWord(true);		//
		this.A1.setBounds(120 , 180 , 300 , 80);
		this.add(this.A1);
		
		this.A2 = new JTextArea();
		this.A2.setLineWrap(true);					//  to go next line
		this.A2.setWrapStyleWord(true);		//
		this.A2.setBounds(120 , 303 , 300 , 80);
		this.add(this.A2);
		
		this.B2 = new JButton("Submit");		// Create JButton B2 for back to SUBMIT
		this.B2.setBounds(380,390,100,20);
		this.add(this.B2);
		
		this.B2.addActionListener (this);
		
		this.B3 = new JButton("Update Old Product");
		this.B3.setBounds(330,420,150,20);
		this.add(this.B3);
		
		this.B3.addActionListener (new Client_Page_2_EventHandler());

}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String s1 = this.T1.getText();	//Product name
			String s2 = this.A1.getText();	//Product details
			String s3 = this.T2.getText();	//Price
			String s4 = this.A2.getText();	//Offer details
			
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(s4);
			
			
			String s = "INSERT INTO product_info VALUES( 0  , '"+s1+"' , '"+s2+"' , '"+s3+"' , '"+s4+"'  )";
			new DBconnector().updateDB(s);
		}



}




