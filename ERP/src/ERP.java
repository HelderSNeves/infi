import java.sql.*;
public class ERP {
	//private static Client_Order client_order_insert_piece;
     volatile static int seconds = 0;
	//private
	//Client_Order[] client_order;
	////ERP(){
	// client_order = new Client_Order[1000];
	//}
	public static int count_non_null(Client_Order[] client_order) {
		int count = 0;
		for (int i = 0; i < client_order.length; i++){
			if(client_order[i] != null)
				count++;
		}
		return count;
	}
	public static void insert_piece(int i, Statement stmt, Connection conn,  Piece piece_warehouseIn) {
		int type = piece_warehouseIn.get_type();
		String position = piece_warehouseIn.get_position();
		int[] operations = piece_warehouseIn.get_operations();
		char supplier = piece_warehouseIn.get_supplier();
		int raw = piece_warehouseIn.get_raw();
		int dispatchDate = piece_warehouseIn.get_dispatchDate();
		int arrivalDate = piece_warehouseIn.get_arrivalDate();
		try {
			Client_Order client_order_insert_piece = piece_warehouseIn.get_client_order();
			try {
				stmt = conn.createStatement();
				String sql = "Insert INTO COMMUNICATION_PIECES " + 
						"VALUES ("+i+","+type+",'"+position+"',"+operations[0]+","+operations[1]+","+operations[2]+","+operations[3]+",'"+supplier+"',"+raw+","+dispatchDate+","+arrivalDate+",'"+client_order_insert_piece.get_client_name()+"',"+client_order_insert_piece.get_order_number()+",'"+client_order_insert_piece.get_workPiece()+"',"+client_order_insert_piece.get_quantity()+","+client_order_insert_piece.get_dueDate()+","+client_order_insert_piece.get_latePen()+","+client_order_insert_piece.get_earlyPen()+",'"+client_order_insert_piece.get_status()+"')";
				stmt.executeUpdate(sql);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(NullPointerException e){
			Client_Order client_order_insert_piece = new Client_Order(null, 0, null, 0, 0, 0, 0, null);
			try {
				String insert_null = "null";
				int insert_int = 0;
				stmt = conn.createStatement();
				String sql = "Insert INTO COMMUNICATION_PIECES " + 
						"VALUES ("+i+","+type+",'"+position+"',"+operations[0]+","+operations[1]+","+operations[2]+","+operations[3]+",'"+supplier+"',"+raw+","+dispatchDate+","+arrivalDate+",'"+insert_null+"',"+insert_int+",'"+insert_null+"',"+insert_int+","+insert_int+","+insert_int+","+insert_int+",'"+insert_null+"')";
				stmt.executeUpdate(sql);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Client_Order client_order = new Client_Order(null, 0, null, 0, 0, 0, 0, null);
		
	}
	public static Client_Order[] algoritmo(Client_Order[] client_order, WarehouseIn warehouseIn)  {
		System.out.println("Boas dentro do algoritmo");
		// aqui ja fez o set ou seja ja temos aqui o primeiro elemento do vetor
		try {
			int len = count_non_null(client_order);
		////// Colocar a do supplier na primeira posicao
			
			Client_Order client_order_aux;
			int index_aux = 0;
			int supplier_flag = 0;
			for(int i = 0; i < len; i++) {
				String[] parts = client_order[i].get_status().split("-");
				//System.out.println(parts[0] + "-" + parts[1] + " " + i);
				if (parts[0].equals("Supplier")) {
					//System.out.println("Condicao de Supplier " + i);
					supplier_flag = 1;
					client_order_aux = client_order[i];
					index_aux = i;
					for(int j = 0; j < index_aux; j++) {
						client_order[index_aux-j] = client_order[index_aux-j-1];	
					}
					client_order[0] = client_order_aux;
					break;
				}
			}
		////// Colocar a ultima finished na ultima posicao
			int len_finished  = 0;
			for(int i = 0; i < len; i++) {
				String[] parts = client_order[i].get_status().split("-");
				if (parts[0].equals("Finished")) {
					len_finished++;
				}
			}
			if (len_finished != 0) {
				Client_Order client_order_aux1;
				int index_aux1 = 0;
				int len1 = len;
				for(int i = 0; i < len1; i++) {
					String[] parts = client_order[i].get_status().split("-");
					if (parts[0].equals("Finished")) {
						//System.out.println("Condicao de Finished " + i);
						client_order_aux1 = client_order[i];
						index_aux1 = i;
						for(int j = 0; j < (len1-index_aux1-1); j++) {
							client_order[index_aux1+j] = client_order[index_aux1+j+1];	
						}
						client_order[len1-1] = client_order_aux1;
						len1--;
					}
				} 
				// Ordernar os finished por due_date depois de os colocar no fim
				for(int i = (len-len_finished); i < len; i++) {
					Client_Order min = client_order[i];
					int idx = i;
					for (int j = i+1; j < len; j++){
						if (client_order[j].get_dueDate() < min.get_dueDate()){
							min = client_order[j];
							idx = j;
						}
					}
					if (idx != i){
						min = client_order[i];
						client_order[i] = client_order[idx];
						client_order[idx] = min;
					}
				}
//				// Ordenar os finished que tem a mesma due_date por ordem de chegada
//				for(int i = (len-len_finished); i < len; i++) {
//					Client_Order min = client_order[i];
//					int idx = i;
//					for (int j = i+1; j < len; j++){
//						if(client_order[j].get_dueDate() == min.get_dueDate()) {
//							if (Integer.parseInt(client_order[j].get_status().split("-")[2]) < Integer.parseInt(min.get_status().split("-")[2])){
//								min = client_order[j];
//								idx = j;
//							}
//						
//							if (idx != i){
//								min = client_order[i];
//								client_order[i] = client_order[idx];
//								client_order[idx] = min;
//							}
//						}
//					}	
//				}
				
			}else {
				//System.out.println("Nao ha finisheds");
			}
			if(supplier_flag == 1) {
				for (int i = 1; i < (len-len_finished); i++){
					Client_Order min = client_order[i];
					int idx = i;
					for (int j = i+1; j < (len-len_finished); j++){
						if (client_order[j].get_dueDate() < min.get_dueDate()){
							min = client_order[j];
							idx = j;
						}
					}
					if (idx != i){
						min = client_order[i];
						client_order[i] = client_order[idx];
						client_order[idx] = min;
					}
				}
//				// Ordenar por ordem de chegada
//				for(int i = 1; i < (len-len_finished); i++) {
//					Client_Order min = client_order[i];
//					int idx = i;
//					for (int j = i+1; j < (len-len_finished); j++){
//						if(client_order[j].get_dueDate() == min.get_dueDate()) {
//							if (Integer.parseInt(client_order[j].get_status().split("-")[2]) < Integer.parseInt(min.get_status().split("-")[2])){
//								min = client_order[j];
//								idx = j;
//							}
//						
//							if (idx != i){
//								min = client_order[i];
//								client_order[i] = client_order[idx];
//								client_order[idx] = min;
//							}
//						}
//					}	
//				}
				
			} else {
				for (int i = 0; i < (len-len_finished); i++){
					Client_Order min = client_order[i];
					int idx = i;
					for (int j = i+1; j < (len-len_finished); j++){
						if (client_order[j].get_dueDate() < min.get_dueDate()){
							min = client_order[j];
							idx = j;
						}
					}
					if (idx != i){
						min = client_order[i];
						client_order[i] = client_order[idx];
						client_order[idx] = min;
					}
				}
//				for(int i = 0; i < (len-len_finished); i++) {
//					Client_Order min = client_order[i];
//					int idx = i;
//					for (int j = i+1; j < (len-len_finished); j++){
//						if(client_order[j].get_dueDate() == min.get_dueDate()) {
//							if (Integer.parseInt(client_order[j].get_status().split("-")[2]) < Integer.parseInt(min.get_status().split("-")[2])){
//								min = client_order[j];
//								idx = j;
//							}
//							if (idx != i){
//								min = client_order[i];
//								client_order[i] = client_order[idx];
//								client_order[idx] = min;
//							}
//						}
//					}	
//				}
			}
			
			
//			for(int i = 0; i < len; i++) {
//				System.out.println(i);
//				System.out.println(client_order[i].get_client_name() + " algorithm");
//	    		System.out.println(client_order[i].get_order_number() + " algorithm");
//	        	System.out.println(client_order[i].get_workPiece() + " algorithm");
//	       		System.out.println(client_order[i].get_quantity() + " algorithm");
//	        	System.out.println(client_order[i].get_dueDate() + " DUE DATE - algorithm");
//	        	System.out.println(client_order[i].get_latePen() + " algorithm");
//	        	System.out.println(client_order[i].get_earlyPen() + " algorithm");
//	        	System.out.println(client_order[i].get_status() + " algorithm");
//			}
			//warehouseIn.set_flag_supply("Null");
			//System.out.println("ASDasdsadsadasdsadsadsadasdasdasdasdasda");
			String[] parts = client_order[0].get_status().split("-");
			//System.out.println(parts[0] + "asdasdsadsadsadasdasdasdsadasdasdasdasdasdas" + parts[1]);
			/*if(parts[0].equals("Supplier")) {
				// Pecas P3, P4 ou P5 - unica possibilidade e mandar vir P2
				// Pecas P7 - vem de P4 e P4 so vem de P2
				// Pecas P9 - vem a partir de P7 que vem de P4 que so vem de P2
				if(client_order[0].get_workPiece().equals("P3") || client_order[0].get_workPiece().equals("P4") || client_order[0].get_workPiece().equals("P5") || client_order[0].get_workPiece().equals("P7") || client_order[0].get_workPiece().equals("P9")) {
	    			
	    			if(Integer.parseInt(parts[1]) > 4) {
	    				warehouseIn.set_client_order(client_order[0]);
	    				warehouseIn.set_pieces_to_be_done(Integer.parseInt(parts[1]));
	    				warehouseIn.set_flag_supply("2C");
	    				String aux = "Supplier-";
	    				int aux1 = Integer.parseInt(parts[1]) - 4;
	    				aux = aux.concat(Integer.toString(aux1));
	    				aux = aux.concat("-");
	    				aux = aux.concat(parts[2]);
	    				client_order[0].set_status(aux);
	    			}
	    			if(Integer.parseInt(parts[1]) <= 4) {
	    				warehouseIn.set_client_order(client_order[0]);
	    				warehouseIn.set_pieces_to_be_done(Integer.parseInt(parts[1]));
	    				warehouseIn.set_flag_supply("2C");
	    				System.out.println("Viu que a peca tem 4 ou menos");
	    				String status_aux = "Finished-0-";
	    				status_aux = status_aux.concat(parts[2]);
	    				client_order[0].set_status(status_aux);
	    				
	    			}
	    		}
				
				// Pecas P6 - vamos fazer a partir de P1
				// Pecas P8 - vem de P6 e P6 vamos fazer a partir de P1
				if(client_order[0].get_workPiece().equals("P6") || client_order[0].get_workPiece().equals("P8")) {
	    			
	    			if(Integer.parseInt(parts[1]) > 4) {
	    				warehouseIn.set_client_order(client_order[0]);
	    				warehouseIn.set_pieces_to_be_done(Integer.parseInt(parts[1]));
	    				warehouseIn.set_flag_supply("1C");
	    				String aux = "Supplier-";
	    				int aux1 = Integer.parseInt(parts[1]) - 4;
	    				aux = aux.concat(Integer.toString(aux1));
	    				aux = aux.concat("-");
	    				aux = aux.concat(parts[2]);
	    				client_order[0].set_status(aux);
	    			}
	    			if(Integer.parseInt(parts[1]) <= 4) {
	    				warehouseIn.set_client_order(client_order[0]);
	    				warehouseIn.set_pieces_to_be_done(Integer.parseInt(parts[1]));
	    				warehouseIn.set_flag_supply("1C");
	    				String status_aux = "Finished-0-";
	    				status_aux = status_aux.concat(parts[2]);
	    				client_order[0].set_status(status_aux);
	    			}
	    		}	
				
			}else */if (parts[0].equals("None")) {
				//System.out.println("Boas do none");
				// Pecas P3, P4 ou P5 - enica possibilidade e mandar vir P2
				// Pecas P7 - vem de P4 e P4 so vem de P2
				// Pecas P9 - vem a partir de P7 que vem de P4 que so vem de P2
				if(client_order[0].get_workPiece().equals("P3") || client_order[0].get_workPiece().equals("P4") || client_order[0].get_workPiece().equals("P5") || client_order[0].get_workPiece().equals("P7") || client_order[0].get_workPiece().equals("P9")) {
	    			
	    				warehouseIn.set_client_order(client_order[0]);
	    				warehouseIn.set_pieces_to_be_done(Integer.parseInt(parts[1]));
	    				warehouseIn.set_flag_supply("2C");
	    				String aux = "Finished-0-";
	    				aux = aux.concat(parts[2]);
	    				//System.out.println(aux);
	    				client_order[0].set_status(aux);
	    		}
				
				// Pecas P6 - vamos fazer a partir de P1
				// Pecas P8 - vem de P6 e P6 vamos fazer a partir de P1
				if(client_order[0].get_workPiece().equals("P6") || client_order[0].get_workPiece().equals("P8")) {
	    			//System.out.println("Boas do P6");
	    			warehouseIn.set_client_order(client_order[0]);
	    			warehouseIn.set_pieces_to_be_done(Integer.parseInt(parts[1]));
	    			warehouseIn.set_flag_supply("1C");
	    			String aux = "Finished-0-";
	    			aux = aux.concat(parts[2]);
	    			//System.out.println(aux);
	    			client_order[0].set_status(aux);
	    		}
					
			} else {
				// Ta finished ou seja, todos estao finished, nao faz nenhuma encomenda
			}
    	}catch(NullPointerException e) {
    		// Do nothing here
    	}
		return client_order;			
	}
 
    public static void main(String[] args) throws InterruptedException {
    	Communication_Table create_table = new Communication_Table();
    	Client_Order[] client_order = new Client_Order[1000];
    	Piece[] warehouseIn_pieces = new Piece[1000];
    	Order_Managment order_managment = new Order_Managment();
    	//ERP_Algorithm erp_algorithm = new ERP_Algorithm();
    	Counting_Time counting_time = new Counting_Time(0, 0, 0);
    	WarehouseIn warehouseIn = new WarehouseIn(warehouseIn_pieces, "None");
    	
    	
    	counting_time.start();
    	order_managment.start();
    	warehouseIn.start();
    	
    	int index = 1;
    	//volatile int seconds = 0;
    	//System.out.print("ERP");
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
	    	while (true) {
	    		seconds = counting_time.get_current_time_seconds();
	    		//System.out.print(seconds);
	    		if (seconds == (20*index)) {
	    			//System.out.println("ERP");
	    			client_order = order_managment.get_Client_Order();
	    			//System.out.println(client_order[0].get_status());
	    			System.out.println("Boas antes do algoritmo");
	    			client_order = algoritmo(client_order, warehouseIn);
	    			//System.out.println(client_order[0].get_status());
	    			if(client_order.length == order_managment.get_Client_Order().length)
	    				order_managment.set_Client_Order(client_order);
	    			else {
	    				for(int i = 0; i < order_managment.get_Client_Order().length - client_order.length; i++) {
	    					client_order[client_order.length+i] = order_managment.get_Client_Order()[client_order.length+i];
	    				}
	    				order_managment.set_Client_Order(client_order);
	    			}
	    			//order_managment.set_Client_Order(client_order);
	    			System.out.println("Boas depois do algoritmo");
	    			//erp_algorithm.set_client_order(client_order);
	    			//erp_algorithm.set_warehouseIn(warehouseIn);
	    			//erp_algorithm.algoritmo();
	    			index++;
	    			
	    			//warehouseIn = erp_algorithm.get_warehouseIn();
	    			warehouseIn_pieces = warehouseIn.get_warehouseIn_pieces();
	    			int count_warehouseIn = 0;
	    			for (int i = 0; i < warehouseIn_pieces.length; i++){
	    				if(warehouseIn_pieces[i] != null)
	    					count_warehouseIn++;
	    			}
	    			create_table = new Communication_Table();
	    			for(int i = 0; i < count_warehouseIn; i++) {
	    				insert_piece(i+1, stmt, conn,  warehouseIn_pieces[i]);
	    			}
	    			try {
	    				System.out.println("Pieces in the Warehouse IN");
	    				for(int i = 0; i < count_warehouseIn; i++) {
	    					System.out.println("///////////////Piece " + (i+1) + ": ////////////////");
	    					System.out.println("Type: " + warehouseIn_pieces[i].get_type());
	    					System.out.println("Position: " + warehouseIn_pieces[i].get_position());
	    					System.out.println("Operations: " + warehouseIn_pieces[i].get_operations()[0] + "-" + warehouseIn_pieces[i].get_operations()[1] + "-" + warehouseIn_pieces[i].get_operations()[2] + "-" + warehouseIn_pieces[i].get_operations()[3]);
	    					System.out.println("Supplier: " + warehouseIn_pieces[i].get_supplier());
	    					System.out.println("Raw Material: P" + warehouseIn_pieces[i].get_raw());
	    					System.out.println("Dispatch Date: " + warehouseIn_pieces[i].get_dispatchDate());
	        				System.out.println("Arrival Date: " + warehouseIn_pieces[i].get_arrivalDate());
	        				if(warehouseIn_pieces[i].get_client_order() != null) {
	        					System.out.println("-----------Client_Order-------------: \n"
	    								+  "Client Name: " + warehouseIn_pieces[i].get_client_order().get_client_name() + "\n"
	    								+  "Order Number: " + warehouseIn_pieces[i].get_client_order().get_order_number() + "\n"
	    								+  "WorkPiece: " + warehouseIn_pieces[i].get_client_order().get_workPiece() + "\n"
	    								+  "Quantity: " + warehouseIn_pieces[i].get_client_order().get_quantity() + "\n"
	    								+  "Due Date: " + warehouseIn_pieces[i].get_client_order().get_dueDate() + "\n"
	    								+  "Late Penalty: " + warehouseIn_pieces[i].get_client_order().get_latePen() + "\n"
	    								+  "Early Penalty: " + warehouseIn_pieces[i].get_client_order().get_earlyPen() + "\n"
	    								+  "Status: " + warehouseIn_pieces[i].get_client_order().get_status()); 
	        				} else {
	        					System.out.println("-----------Client_Order-------------: \n");
	        					System.out.println("NUUUUUUUUUUUUULAAAAAAAAAAAAAAAAA");
	        				}
	        				
	    				}
	    					
	    			}catch(NullPointerException e) {
	    	    		// Do nothing here
	    	    	}
	    			//System.out.println(warehouseIn.get_flag_supply());
	    		}
	    		//client_order = order_managment.get_Client_Order();
	//        	try {
	//        		System.out.println(client_order[0].get_client_name() + " erp");
	//        	}catch(NullPointerException e) {
	//        		System.out.println("Null Exception");
	//        	}
	    	}
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
//    	client_order = order_managment.get_Client_Order();
//    	System.out.println(client_order[0].get_client_name() + " erp");
//    	System.out.println(client_order[0].get_order_number() + " erp");
//    	System.out.println(client_order[0].get_workPiece() + " erp");
//   		System.out.println(client_order[0].get_quantity() + " erp");
//    	System.out.println(client_order[0].get_dueDate() + " erp");
//    	System.out.println(client_order[0].get_latePen() + " erp");
//    	System.out.println(client_order[0].get_earlyPen() + " erp");
//    	erp_algorithm.set_client_order(client_order);
    	
    	
        
    	//}
    	
    	/*do { 
    		while(true) {
    			if(order_managment.get_Client_Order()[i+1] != null) break;
    			if(i == 998) i = index_seguro-1;
    			i++;
    		}
    		client_order = order_managment.get_Client_Order();
    	//System.out.println("Length = " + client_order.length);
    		System.out.println(client_order[index].get_client_name() + " ERP");
    	//order_managment.run(args);
    		index++;
    		i++;
    	} while(order_managment.get_Client_Order()[index_seguro++] != null);*/
    	//erp_algorithm.run();
    		//System.out.println("ESTOU AQUI");
    		//System.out.println(order_managment.get_Client_Order());
    	
    	
    }
}