package database_testing;

import java.sql.*;

public class InsertingData {

	public static void main(String args[]) {
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
			
			System.out.println("Inserting data or records into the table called students:");
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO students " +
						"VALUES (800,'John','Smith',22)";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO students " +
					"VALUES (801,'Chris','Portman',25)";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO students " +
					"VALUES (802,'Amanda','Stevens',21)";
			stmt.executeUpdate(sql);
			
			System.out.println("Inserted records into the table. Please verify...");
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
