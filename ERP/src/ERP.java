
public class ERP {
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
	public static void algoritmo(Client_Order[] client_order, WarehouseIn warehouseIn)  {
		System.out.println("Boas dentro do algoritmo");
		// aqui ja fez o set ou seja ja temos aqui o primeiro elemento do vetor
		try {
			int len = count_non_null(client_order);
			for (int i = 0; i < len; i++){
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
			////// Colocar a do supplier na primeira posicao
			
			Client_Order client_order_aux;
			int index_aux = 0;
			for(int i = 0; i < len; i++) {
				String[] parts = client_order[i].get_status().split("-");
				if (parts[0] == "Supplier") {
					client_order_aux = client_order[i];
					index_aux = i;
					for(int j = 0; j < index_aux; j++) {
						client_order[index_aux-j] = client_order[index_aux-j-1];	
					}
					client_order[0] = client_order_aux;
				}
			}

			for(int i = 0; i < 3; i++) {
				System.out.println(client_order[i].get_client_name() + " algorithm");
	    		System.out.println(client_order[i].get_order_number() + " algorithm");
	        	System.out.println(client_order[i].get_workPiece() + " algorithm");
	       		System.out.println(client_order[i].get_quantity() + " algorithm");
	        	System.out.println(client_order[i].get_dueDate() + " due date - algorithm");
	        	System.out.println(client_order[i].get_latePen() + " algorithm");
	        	System.out.println(client_order[i].get_earlyPen() + " algorithm");
	        	System.out.println(client_order[i].get_status() + " algorithm");
			}
			//warehouseIn.set_flag_supply("Null");
			//System.out.println("ASDasdsadsadasdsadsadsadasdasdasdasdasda");
			String[] parts = client_order[0].get_status().split("-");
			System.out.println(parts[0] + "asdasdsadsadsadasdasdasdsadasdasdasdasdasdas" + parts[1]);
			if(parts[0].equals("Supplier")) {
				// Pecas P3, P4 ou P5 - enica possibilidade e mandar vir P2
				// Pecas P7 - vem de P4 e P4 so vem de P2
				// Pecas P9 - vem a partir de P7 que vem de P4 que so vem de P2
				if(client_order[0].get_workPiece() == "P3" || client_order[0].get_workPiece() == "P4" || client_order[0].get_workPiece() == "P5" || client_order[0].get_workPiece() == "P7" || client_order[0].get_workPiece() == "P9") {
	    			
	    			if(Integer.parseInt(parts[1]) > 4) {
	    				warehouseIn.set_flag_supply("2C");
	    				String aux = "Supplier-";
	    				int aux1 = Integer.parseInt(parts[1]) - 4;
	    				aux = aux.concat(Integer.toString(aux1));
	    				client_order[0].set_status(aux);
	    			}
	    			if(Integer.parseInt(parts[1]) <= 4) {
	    				warehouseIn.set_flag_supply("2C");
	    				client_order[0].set_status("Finished-0");
	    			}
	    		}
				
				// Pecas P6 - vamos fazer a partir de P1
				// Pecas P8 - vem de P6 e P6 vamos fazer a partir de P1
				if(client_order[0].get_workPiece() == "P6" || client_order[0].get_workPiece() == "P8") {
	    			
	    			if(Integer.parseInt(parts[1]) > 4) {
	    				warehouseIn.set_flag_supply("1C");
	    				String aux = "Supplier-";
	    				int aux1 = Integer.parseInt(parts[1]) - 4;
	    				aux = aux.concat(Integer.toString(aux1));
	    				client_order[0].set_status(aux);
	    			}
	    			if(Integer.parseInt(parts[1]) <= 4) {
	    				warehouseIn.set_flag_supply("1C");
	    				client_order[0].set_status("Finished-0");
	    			}
	    		}	
				
			}else if (parts[0].equals("None")) {
				System.out.println("Boas do none");
				// Pecas P3, P4 ou P5 - enica possibilidade e mandar vir P2
				// Pecas P7 - vem de P4 e P4 so vem de P2
				// Pecas P9 - vem a partir de P7 que vem de P4 que so vem de P2
				if(client_order[0].get_workPiece().equals("P3") || client_order[0].get_workPiece().equals("P4") || client_order[0].get_workPiece().equals("P5") || client_order[0].get_workPiece().equals("P7") || client_order[0].get_workPiece().equals("P9")) {
	    			
	    			if(Integer.parseInt(parts[1]) > 4) {
	    				warehouseIn.set_flag_supply("2C");
	    				String aux = "Supplier-";
	    				int aux1 = Integer.parseInt(parts[1]) - 4;
	    				aux = aux.concat(Integer.toString(aux1));
	    				client_order[0].set_status(aux);
	    			}
	    			if(Integer.parseInt(parts[1]) <= 4) {
	    				warehouseIn.set_flag_supply("2C");
	    				client_order[0].set_status("Finished-0");
	    			}
	    		}
				
				// Pecas P6 - vamos fazer a partir de P1
				// Pecas P8 - vem de P6 e P6 vamos fazer a partir de P1
				if(client_order[0].get_workPiece().equals("P6") || client_order[0].get_workPiece().equals("P8")) {
	    			System.out.println("Boas do P6");
	    			if(Integer.parseInt(parts[1]) > 4) {
	    				warehouseIn.set_flag_supply("1C");
	    				String aux = "Supplier-";
	    				int aux1 = Integer.parseInt(parts[1]) - 4;
	    				aux = aux.concat(Integer.toString(aux1));
	    				client_order[0].set_status(aux);
	    			}
	    			if(Integer.parseInt(parts[1]) <= 4) {
	    				warehouseIn.set_flag_supply("1C");
	    				client_order[0].set_status("Finished-0");
	    			}
	    		}
					
			}
        	
        	
    	}catch(NullPointerException e) {
    		// Do nothing here
    	}
						
	}
 
    public static void main(String[] args) throws InterruptedException {
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
    	while (true) {
    		seconds = counting_time.get_current_time_seconds();
    		//System.out.print(seconds);
    		if (seconds == (20*index)) {
    			//System.out.println("ERP");
    			client_order = order_managment.get_Client_Order();
    			System.out.println("Boas antes do algoritmo");
    			algoritmo(client_order, warehouseIn);
    			System.out.println("Boas depois do algoritmo");
    			//erp_algorithm.set_client_order(client_order);
    			//erp_algorithm.set_warehouseIn(warehouseIn);
    			//erp_algorithm.algoritmo();
    			index++;
    			//warehouseIn = erp_algorithm.get_warehouseIn();
    			warehouseIn_pieces = warehouseIn.get_warehouseIn_pieces();
    			try {
    				System.out.println(warehouseIn_pieces[0].get_type());
    				System.out.println(warehouseIn_pieces[0].get_position());
    				for(int i = 0; i < 4; i++) {System.out.println(warehouseIn_pieces[0].get_operations()[i]);}
    				System.out.println(warehouseIn_pieces[0].get_supplier());
    				System.out.println(warehouseIn_pieces[0].get_raw());
    				System.out.println(warehouseIn_pieces[0].get_dispatchDate());
    				System.out.println(warehouseIn_pieces[0].get_arrivalDate());	
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