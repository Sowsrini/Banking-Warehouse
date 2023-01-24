package com.etl.loader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	
	public Connection sourcedb1() throws ClassNotFoundException, SQLException {
		
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/branch1","root","1234");  
//			Statement stmt=con.createStatement();  
//			ResultSet rs=stmt.executeQuery("select * from authors");  
//			while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		//	con.close();  
			return con;
	
	}

	
	public Connection sourcedb2() throws ClassNotFoundException, SQLException {
		
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/branch2","root","1234");  
		/*
		 * Statement stmt=con.createStatement(); ResultSet
		 * rs=stmt.executeQuery("select * from newauthors"); while(rs.next())
		 * System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		 * con.close();
		 */
		return con;

}
	
	public Connection sourcedb3() throws ClassNotFoundException, SQLException {
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fact","root","1234");  
//		Statement stmt=con.createStatement();  
//		ResultSet rs=stmt.executeQuery("select * from authors");  
//		while(rs.next())  
//		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	//	con.close();  
		return con;

}
	
	public Connection factTableConnection() throws SQLException
	{
		  String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=facttable;integratedsecurity=true";

	        try {
	            // Load SQL Server JDBC driver and establish connection.
	            System.out.print("Connecting to SQL Server ... ");
	            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
	                System.out.println("Done.");
	            }
	        } catch (Exception e) {
	            System.out.println();
	            e.printStackTrace();
	        }
			return null;
	    }
	
	
	
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		

		/*
		 * String connectionUrl =
		 * "jdbc:sqlserver://localhost:1433;databasename=new;integratedsecurity=true" ;
		 * java.sql.DatabaseMetaData metaData = connection.getMetaData();
		 * System.out.println("Driver version:" + metaData.getDriverVersion());
		 * Connection connection = DriverManager.getConnection(connectionUrl);
		 * System.out.println(connection);
		 */
		       
		    }
	}

