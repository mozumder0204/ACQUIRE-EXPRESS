import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;

import DBconnection.DBconnector;


public class HomePage  extends JPanel implements ActionListener{
   
	private static HomePage refer;
	
	private JLabel L1 , L3   , L4 , L5  ,  pic ;
	
	private JTextArea A1 ; 
	
	private JButton B1   ,   B2  ,   B3   ,   B4   ,   B5   ,   B6   ,   B7  ;
	
	String S1 , S2 , S3 , S4 , S5 ;

    Timer tm;
    int x = 0;

    String[] list = {
    		"111.jpg",
			"222.png",
			"333.jpg",
			"444.jpg",
                    };
    
    public HomePage(){

    	
    		pic = new JLabel();
    		pic.setBounds(0, 150, 480, 100);
    		SetImageSize(3);
    		tm = new Timer(1000,new ActionListener() {
    			
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if(x >= list.length )
                    x = 0; 
            }
        });
        add(pic);
        tm.start();

        readData () ;
        
        addComponent();
    
        MovingText();   
        
    }
    
    public void addComponent() {
    	this.setLayout(null);

    	ImageIcon Main_Logo = new ImageIcon("LOGO2.png");	//Set Icon in Option Button
    	Image img2 = Main_Logo.getImage();
    	Image newimg2 = img2.getScaledInstance( 500 , 100 , java.awt.Image.SCALE_FAST);		//Insert & Resize Image
    	Main_Logo = new ImageIcon(newimg2);

    	this.L1 = new JLabel(Main_Logo);
    	this.L1.setBounds(0,0,500,95);				
    	this.add(this.L1);
    	

    	ImageIcon Buttonicon = new ImageIcon("Login.png");	//Set Icon in Option Button
    	Image img = Buttonicon.getImage();
    	Image newimg = img.getScaledInstance( 60 , 50 , java.awt.Image.SCALE_FAST);		//Insert & Resize Image
    	Buttonicon = new ImageIcon(newimg);
	
    	this.B1 = new JButton(Buttonicon);		
    	this.B1.setBounds(420,100,60,50);
    	this.B1.setToolTipText("Log in");
    	this.add(this.B1);	
    	this.B1.addActionListener (new Log_In_EventHandler());

    	ImageIcon showcase = new ImageIcon("showcase.jpg");	
    	Image img4 = showcase.getImage();
    	Image newimg4 = img4.getScaledInstance( 200 , 100 , java.awt.Image.SCALE_FAST);		//Insert & Resize Image
    	showcase = new ImageIcon(newimg4);

    	this.L4 = new JLabel(showcase);
    	this.L4.setBounds(30,270,200,100);			
    	this.add(this.L4);
    	
    	
    	this.A1 = new  JTextArea("Product Name :  "+ S2+ "\n\n" +"Product Price :   "+ S4 + "\n\n"  +"Product Details :   "+ S3  +"\n\n" +"Product offer :   "+  S5);
    	this.A1.setBounds(240 , 270 , 220 , 170);
    	this.A1.setLineWrap(true);	
    	this.A1.setEditable(false);
    	this.A1.setBackground(Color.LIGHT_GRAY);
    	this.add(this.A1);
    	
    	
	
    }
    
public void readData () {
		
		DBconnector DC = new DBconnector();
		ResultSet rs;		
		String query="select * from product_info";
		rs=DC.getData(query);					
		try{	
			while(rs.next())
			{
					S1 = rs.getString("Product_id");
					S2 = rs.getString("Product_name");
					S3 = rs.getString("Product_details");
					S4 = rs.getString("Product_price");
					S5= rs.getString("Product_offers");
			}
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		}
		
    
    public void SetImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }
    
    

    public void MovingText()  {
        this.L3 = new JLabel( "Welcome to Acquire Online      ");
        this.L3.setBounds(70,70,400,120);
        Font ff = new Font("Lucida Sans Unicode" , Font.BOLD , 20);
        this.L3.setFont(ff);
        this.L3.setForeground(Color.BLUE);
        
         javax.swing.Timer timer = new javax.swing.Timer(100, (ActionListener) this);
        timer.start();
        this.add(this.L3);
      }
   
    public void actionPerformed(ActionEvent e)  {
    	
        String oldText = this.L3.getText();
        String newText = oldText.substring(1) + oldText.substring(0, 1);
         this.L3.setText( newText );
      }
    
    
    
	public static HomePage  getRefer(){
		if(refer==null){
			refer = new HomePage();
		}

		return refer;
	}
}
