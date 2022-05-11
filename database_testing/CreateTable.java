package database_testing;
//creating a new table

import java.sql.*;
import java.sql.DriverManager;


public class CreateTable {

	public static void main(String args[])
	{
		Connection conn = null;
		Statement stmt = null;
		
		try
		{
			//Step 2: Register JBDC Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Step 3: Open a connection to our database
			System.out.println("Connecting to the selected database...");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/javarocks","root","");
			System.out.println("Connected Successfully!");
			//Step 4: Executing the Query
			System.out.println("Creating the required table...");
			stmt = conn.createStatement();
			
			String sql = "CREATE TABLE STUDENTS" +
					"(id INTEGER not NULL," +
					"first VARCHAR (255)," +
					"last VARCHAR(255)," + 
					"age INTEGER," +
					"PRIMARY KEY (id))";
			stmt.executeUpdate(sql);
			System.out.println("Created the required table in the database!");
			
		}catch(SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
			
			
		}catch(Exception e) {
			//Handle errors for Class for Name
			e.printStackTrace();
		}finally {
			//finally block basically is used to close the resources
			try {
				if(stmt != null)
					conn.close();
			}catch(SQLException se) {
				//do nothing
			}
			try {
				if(conn != null)
					conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}//end of the finally try
		}//end try
		System.out.println("Have a wonderful day. Goodbye!");
		
	}
}