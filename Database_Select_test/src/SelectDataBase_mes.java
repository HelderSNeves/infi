import java.sql.*;
public class SelectDataBase_mes extends Thread{
	private Piece_mes[] warehouseIn_pieces;
	
	public SelectDataBase_mes(Piece_mes[] warehouseIn_pieces) {
		this.warehouseIn_pieces = warehouseIn_pieces;
	}
	public Piece_mes[] get_warehouseIn_pieces() {
		return this.warehouseIn_pieces;
	}
	public void set_warehouseIn_pieces(Piece_mes[] warehouseIn_pieces) {
		this.warehouseIn_pieces = warehouseIn_pieces;
	}
	
	public void run() {
		try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/infi_database";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      System.out.println("Connected Successfully");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM COMMUNICATION_PIECES";

	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      int[] operations = new int[4];
	      int index = 0;
	      while (rs.next())
	      {
	        int pieceID = rs.getInt("PieceID");
	        int type = rs.getInt("Type");
	        String position = rs.getString("Position");
	        for(int i = 0; i < 4; i++) {
	        	String aux = "Operation";
	        	String concat = Integer.toString(i);
	        	aux = aux.concat(concat);
	        	operations[i] = rs.getInt(aux);
	        }
	        String supplier_s = rs.getString("Supplier");
	        char supplier = supplier_s.charAt(0);
	        int raw = rs.getInt("RawMaterial");
	        int dispatchDate = rs.getInt("DispatchDate");
	        int arrivalDate = rs.getInt("ArrivalDate");
	        
	        String client_name = rs.getString("ClientName");
	        int order_number = rs.getInt("OrderNumber");
	        String workPiece = rs.getString("WorkPiece");
	        int quantity = rs.getInt("Quantity");
	        int dueDate = rs.getInt("DueDate");
	        int latePen = rs.getInt("LatePen");
	        int earlyPen = rs.getInt("EarlyPen");
	        String status = rs.getString("Status");
	        String status_mes = "WI";
	        
	        Client_Order_mes client_order_aux = new Client_Order_mes(client_name, order_number, workPiece, quantity, dueDate, latePen, earlyPen, status, status_mes);
	        Piece_mes piece_aux = new Piece_mes(type, position, operations, supplier, raw, client_order_aux, dispatchDate, arrivalDate);
	        warehouseIn_pieces[index] = piece_aux;
//	        warehouseIn_pieces[index].set_type(type);
//	        warehouseIn_pieces[index].set_position(position);
//	        warehouseIn_pieces[index].set_operations(operations);
//	        warehouseIn_pieces[index].set_supplier(supplier_s.charAt(0));
//	        warehouseIn_pieces[index].set_raw(raw);
//	        warehouseIn_pieces[index].set_client_order(client_order_aux);
//	        warehouseIn_pieces[index].set_dispatchDate(dispatchDate);
//	        warehouseIn_pieces[index].set_arrivalDate(arrivalDate);
	        
	            
	         //print the results
//	        System.out.println("///////////////Piece " + (index+1) + ": ////////////////");
//			System.out.println("Type: " + type);
//			System.out.println("Position: " + position);
//			System.out.println("Operations: " + operations[0] + "-" + operations[1] + "-" + operations[2] + "-" + operations[3]);
//			System.out.println("Supplier: " + supplier);
//			System.out.println("Raw Material: P" + raw);
//			System.out.println("Dispatch Date: " +dispatchDate);
//			System.out.println("Arrival Date: " + arrivalDate);
//			System.out.println("-----------Client_Order-------------: \n"
//					+  "Client Name: " + client_name + "\n"
//					+  "Order Number: " + order_number + "\n"
//					+  "WorkPiece: " + workPiece + "\n"
//					+  "Quantity: " + quantity + "\n"
//					+  "Due Date: " + dueDate + "\n"
//					+  "Late Penalty: " + latePen + "\n"
//					+  "Early Penalty: " + earlyPen + "\n"
//					+  "Status: " + status); 

			index++;
	        //System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	}
}
