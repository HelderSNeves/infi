import java.sql.*;
import java.sql.DriverManager;

public class Communication_Table {
	Communication_Table()
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
					.getConnection("jdbc:mysql://localhost:3306/infi_database","root","");
			System.out.println("Connected Successfully!");
			//Step 4: Executing the Query
			System.out.println("Creating the tables...");
			
			//STEP 1: DROPPING TABLES IF THEY EXIST (FIRST DROP THE CHILD TABLES BECAUSE OF THE FOREIGN KEY)
			stmt = conn.createStatement();
			String sql = "DROP TABLE IF EXISTS COMMUNICATION_PIECES";
			stmt.executeUpdate(sql);
			
			//stmt = conn.createStatement();
			//sql = "DROP TABLE IF EXISTS ERP_CLIENT";
			//stmt.executeUpdate(sql);
			//STEP 2: CREATE THE PARENT TABLE FIRST
			sql = "CREATE TABLE COMMUNICATION_PIECES" +
					"(PieceID INTEGER not NULL," +
					"Type INTEGER not NULL," +
					"Position VARCHAR (255)," +
					"Operation0 INTEGER," +
					"Operation1 INTEGER," +
					"Operation2 INTEGER," +
					"Operation3 INTEGER," +
					"Supplier CHAR (1)," +
					"RawMaterial VARCHAR (255)," +
					"DispatchDate INTEGER," +
					"ArrivalDate INTEGER," +
					"ClientName VARCHAR (255)," +
					"OrderNumber INTEGER," +
					"WorkPiece VARCHAR (255)," +
					"Quantity INTEGER," + 
					"DueDate INTEGER," +
					"LatePen INTEGER," +
					"EarlyPen INTEGER," +
					"Status VARCHAR (255)," +
					"PRIMARY KEY (PieceID))";
			stmt.executeUpdate(sql);
			System.out.println("Created the COMMUNICATION_PIECES table in the database!");
			
			//STEP 2: CREATE THE CHILD TABLE
			/*sql = "CREATE TABLE ERP_CLIENT_ORDERS" +
					"(OrderID INTEGER not NULL," +
					"OrderNumber INTEGER," +
					"WorkPiece VARCHAR (255)," +
					"Quantity INTEGER," + 
					"DueDate INTEGER," +
					"LatePen INTEGER," +
					"EarlyPen INTEGER," +
					"ClientID INTEGER," +
					"PRIMARY KEY (OrderID)," +
					"FOREIGN KEY (ClientID) REFERENCES ERP_CLIENT(ClientID))";
			stmt.executeUpdate(sql);
			System.out.println("Created the ERP_CLIENT_ORDERS table in the database!");
			*/
		}
		catch(SQLException se)
		{
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e)
		{
			//Handle errors for Class for Name
			e.printStackTrace();
		}
		finally
		{
			//finally block basically is used to close the resources
			try
			{
				if(stmt != null)
					conn.close();
			}
			catch(SQLException se)
			{
				//do nothing
			}
			try
			{
				if(conn != null)
					conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}//end of the finally try
		}//end try
		System.out.println("Have a wonderful day. Goodbye!");
		
	}
}
