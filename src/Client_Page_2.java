import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DBconnection.DBconnector;

public class Client_Page_2 extends JPanel implements ActionListener {
	
	private JLabel PL1  ,  PL2  ,  PL3  ,  PL4  ,  PL5  ,  PL6 ;

	private JTextField PT1 ,  PT2 ;

	private JTextArea PA1  ,  PA2  ;

	private JButton PB1  ,  PB2  ;

	private static Client_Page_2 refer;

	public Client_Page_2() {
		
		addComponent2();
	}
	
	public static Client_Page_2  getRefer(){
		if(refer==null){
			refer = new Client_Page_2();
		}
		
		return refer;
	}
	public  void addComponent2() {
		
		this.setLayout(null);
		
		ImageIcon Main_Logo = new ImageIcon("LOGO2.png");	//Set Icon in Option Button
		Image img2 = Main_Logo.getImage();
		Image newimg2 = img2.getScaledInstance( 500 , 100 , java.awt.Image.SCALE_FAST);		//Insert & Resize Image
		Main_Logo = new ImageIcon(newimg2);
		
		
		this.PL1 = new JLabel(Main_Logo);
		this.PL1.setBounds(0,0,500,95);				// JLabel L1 for Main_Logo...	
		this.add(this.PL1);
		
		ImageIcon Admin_Back_Log = new ImageIcon("LOG_Back_HP.jpg");	//Set Icon in Option Button
		Image img = Admin_Back_Log.getImage();
		Image newimg = img.getScaledInstance( 50 , 50 , java.awt.Image.SCALE_FAST);		//Insert & Resize Image
		Admin_Back_Log = new ImageIcon(newimg);
		
		
		this.PB1 = new JButton(Admin_Back_Log);		// Create JButton B1 for back to Log In Page
		this.PB1.setBounds(0,95,50,50);
		this.add(this.PB1);
		
		this.PB1.addActionListener (new Client_Page_EventHandler());
		
		
		   this.PL6 = new JLabel ("Update Product Information");
		  Font font1 = new Font("Lucida Sans Unicode" , Font.BOLD , 20);
		  this.PL6.setBounds(130 , 110 , 500 ,30);
		  this.PL6.setFont(font1);
		   this.add(this.PL6);
		
		
		this.PL2 = new JLabel ("New product name :");
		this.PL2.setBounds(20 , 150 , 120 ,15);
		this.add(this.PL2);
		
		this.PL3 = new JLabel ("New product details :");
		this.PL3.setBounds(20 , 180 ,  120 , 15);
		this.add(this.PL3);
		
		this.PL4 = new JLabel ("New price :");
		this.PL4.setBounds(20 , 280 , 120 , 15);
		this.add(this.PL4);
		
		this.PL5 = new JLabel ("New offer details :");
		this.PL5.setBounds(20 , 300 , 120 , 15);
		this.add(this.PL5);
		
		this.PT1 = new JTextField();
		this.PT1.setBounds(140 , 148 , 300 , 20);		//New product details
		this.add(this.PT1);
		
		this.PT2 = new JTextField();
		this.PT2.setBounds(140 , 275 , 300 , 20);		//New price 
		this.add(this.PT2);
		
		this.PA1 = new JTextArea();
		this.PA1.setLineWrap(true);					//  to go next line
		this.PA1.setWrapStyleWord(true);		//
		this.PA1.setBounds(140 , 180 , 300 , 80);		//New product details
		this.add(this.PA1);
		
		this.PA2 = new JTextArea();
		this.PA2.setLineWrap(true);					//  to go next line
		this.PA2.setWrapStyleWord(true);		//
		this.PA2.setBounds(140 , 303 , 300 , 80);		//New offer details
		this.add(this.PA2);
		
		this.PB2 = new JButton("Submit");		// Create JButton B2 for back to SUBMIT
		this.PB2.setBounds(380,390,100,20);
		this.add(this.PB2);
		
		this.PB2.addActionListener (this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s1 = this.PT1.getText();	//Product name
		String s2 = this.PA1.getText();	//Product details
		String s3 = this.PT2.getText();	//Price
		String s4 = this.PA2.getText();	//Offer details
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		
		String s = "INSERT INTO product_update_info VALUES( null  , '"+s1+"' , '"+s2+"' , '"+s3+"' , '"+s4+"'  )";
		new DBconnector().updateDB(s);
	}
	

}
