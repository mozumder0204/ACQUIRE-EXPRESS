import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

import DBconnection.DBconnector;


public class Log_In extends JPanel implements ActionListener {
		private JLabel L1  ,  L2 , L3 , L4  ;
	
		private JTextField T1;
		private JPasswordField T2;
		
		private JButton B1  ,  B2  ,  B3 ;

		private static Log_In refer;

	    static String US;
	    static String PS;
		 
	     Statement stmt;
		 Connection conn;

		public Log_In(){
	
			addComponent();
		}
	

		public static Log_In  getRefer(){
			if(refer==null){
				refer = new Log_In();
			}
			
			return refer;
		}
		
		public void addComponent(){
		
		this.setBackground(Color.WHITE);
		this.setLayout(null);

		ImageIcon Main_Logo = new ImageIcon("LOGO2.png");	
		Image img2 = Main_Logo.getImage();
		Image newimg2 = img2.getScaledInstance( 500 , 100 , java.awt.Image.SCALE_FAST);		//Insert & Resize Image
		Main_Logo = new ImageIcon(newimg2);
		
		
		this.L2 = new JLabel(Main_Logo);
		this.L2.setBounds(0,0,500,95);				// JLabel L2 for Main_Logo...	
		this.add(this.L2);
		
		this.L1 = new JLabel("Log in to your Account");
		this.L1.setFont(new Font ("Consolas" , Font.BOLD , 20));		// JLabel L1 for message...
		this.L1.setBounds(100,100,400,100);
		this.add(this.L1);

		
		this.L3 = new JLabel("Username");
		this.L3.setFont(new Font ("Consolas" , Font.BOLD , 14));		// JLabel L1 for message...
		this.L3.setBounds(85,130,100,100);
		this.add(this.L3);
		
		this.T1 = new JTextField();
		this.T1.setBounds(80 , 190 , 300 , 20);
		this.T1.setBackground(Color.CYAN);												//Create JTextField T1 for username...
		Font font2 = new Font("Consolas" , Font.BOLD , 14);
		this.T1.setFont(font2);
		this.T1.setToolTipText("Enter your username here");
		this.add(this.T1);
		

	
		this.L4 = new JLabel("Password ");
		this.L4.setFont(new Font ("Consolas" , Font.BOLD , 14));		// JLabel L1 for message...
		this.L4.setBounds(85,175,100,100);
		this.add(this.L4);
		
		this.T2 = new JPasswordField();						//Create  JPasswordField T2 for password
		this.T2.setBounds(80 , 235 , 300 , 20);
		this.T2.setBackground(Color.CYAN);	
		this.T2.setToolTipText("Enter your password here");
		this.add(this.T2);
	
		this.B1 = new JButton("Log In");
		this.B1.setBounds(80 , 270 , 90 , 30);
		Color co3 = new Color(255 , 100 , 100);									//Create JButton B1 for Log In
		this.B1.setBackground(co3);
		this.B1.setForeground(Color.WHITE);
		this.add(this.B1);
		
		Cursor cur = new Cursor(Cursor.HAND_CURSOR);
		this.B1.setCursor(cur);																//Hand Cursor used in Log In Button
		
		B1.addActionListener(this);
		
		ImageIcon LOG_Back_HP = new ImageIcon("LOG_Back_HP.jpg");	//Set Icon in Option Button
		Image img = LOG_Back_HP.getImage();
		Image newimg = img.getScaledInstance( 50 , 50 , java.awt.Image.SCALE_FAST);		//Insert & Resize Image
		LOG_Back_HP = new ImageIcon(newimg);
		
		
		this.B3 = new JButton(LOG_Back_HP);		
		this.B3.setBounds(0,100,50,50);
		this.add(this.B3);
		
		this.B3.addActionListener (new HP_EventHandler());
		
}

		
		public void actionPerformed(ActionEvent e)
		{
			readData();
			}

				
public void readData () {
					
			DBconnector DC = new DBconnector();
			
			ResultSet rs;
			ResultSet rs2;
			
			String username = T1.getText();
			String password = T2.getText();
					
			String query="SELECT * FROM `client` WHERE username = '"+username+"' and password = '"+password+"' ";
			String query2="SELECT * FROM `admin` WHERE username = '"+username+"' and password = '"+password+"' ";		
					
			
			rs=DC.getData(query);		
			rs2=DC.getData(query2);		
					
			try{
				if(rs.next()){
					System.out.println("Authorized");
					this.B1.addActionListener (new Client_Page_EventHandler());
				}
				else if (rs2.next()) {
					System.out.println("Authorized");
					this.B1.addActionListener (new Admin_Page_EventHandler());
				}			
				else {
					JOptionPane.showMessageDialog(getRefer(),"Username or Password is invalid.");
					
					System.out.println("Not Authorized");
				}
				
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
}
