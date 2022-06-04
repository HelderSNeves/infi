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
					.getConnection("jdbc:mysql://localhost:3306/infi_database","root","");
			System.out.println("Connected Successfully!");
			
			
			//Step 4: Executing the Query		
			
			System.out.println("Inserting data into the table called COMMUNICATION_PIECES:");
			stmt = conn.createStatement();
			String sql = "INSERT INTO COMMUNICATION_PIECES " +
					"VALUES (1,2,'WI',9,9,9,9,'C','P2',0,0,'Client_AA',18,'P9',8,7,10,10,'Finished-0-0')";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO COMMUNICATION_PIECES " +
					"VALUES (2,1,'WI',9,9,9,9,'C','P2',0,0,'Client_AA',18,'P9',8,7,10,10,'Finished-0-0')";
			stmt.executeUpdate(sql);
			
			
			System.out.println("Inserted data into the table COMMUNICATION_PIECES. Please verify...");
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
	}
}
