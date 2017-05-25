package com.ciber.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Dbconnection
{
	static ResourceBundle bundle = ResourceBundle.getBundle("com/ciber/properties/ApplicationResource") ;	
/*	public static Connection getConnection()
	{
		Connection connection = null;
		
	
		
		try
		{
			Class.forName(bundle.getString("jdbc.driverName"));
			connection = DriverManager.getConnection(bundle.getString("jdbc.url") + bundle.getString("jdbc.db"), bundle.getString("jdbc.userName"),bundle.getString("jdbc.password"));
		
		}catch (Exception e){
			
			e.printStackTrace();
		} 
		return connection;
	}*/
	
   //private static final String connectionUrl = "jdbc:sqlserver://172.18.243.60;instanceName=SEPDB;databaseName=GIDC";
   //private static final String connectionUrl = "jdbc:sqlserver://localhost;databaseName=GIDC_Latest";
    private static Connection con=null;
    public static Connection getSQLConnection(){
           
                  try{
                         Class.forName(bundle.getString("jdbc.driverName"));
                         con = DriverManager.getConnection(bundle.getString("jdbc.url"),bundle.getString("jdbc.userName"),bundle.getString("jdbc.password"));
                  }catch(ClassNotFoundException classNotFoundException){
                        classNotFoundException.printStackTrace();
                  }catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                  }
           return con;
           
    }

	public static void closeConnection(Connection connection)
	{
		try {
			connection.close();
		} catch (Exception e){
			e.printStackTrace();
		} 
	}	
	
	public static void main(String[] args) {
		con=getSQLConnection();
		System.out.println(con);
	}
}
