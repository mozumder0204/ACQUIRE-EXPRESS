package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnector {
	
	Connection conn;
    String JDBC_DRIVER;  
    String DB_URL;
    Statement stmt;
    ResultSet rs;
    
	public DBconnector(){
		JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/acquire_express";
        String USER = "root";
        String PASS = "";	
        
        try{
           
        	Class.forName(JDBC_DRIVER);		//
            
            System.out.println("Connecting to database..."  );
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connection established successfully....");
    
        }
        catch(Exception ex){
           ex.printStackTrace();
            //System.out.println("Failed to get DBConn:: "+ex.getMessage());
        }

	}
	
    public ResultSet getData(String query) {
        try{
            stmt = conn.createStatement();
            rs= stmt.executeQuery(query);
        }
        catch(Exception ex){
            System.out.println("DB Read Error !");
        }
        return rs;
   }
	
	
    public int updateDB(String query){
        int numOfRowsUpdated=0;
        try{
            stmt = conn.createStatement(); 
            numOfRowsUpdated=stmt.executeUpdate(query);
            System.out.println(numOfRowsUpdated+" row(s) updated");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return numOfRowsUpdated;
    }
	
}
