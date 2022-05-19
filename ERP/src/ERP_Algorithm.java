
public class ERP_Algorithm{	
	private Client_Order[] client_order;
	private WarehouseIn warehouseIn;
	
	public void set_client_order(Client_Order[] client_order) {
		this.client_order = client_order;
	}
	public void set_warehouseIn(WarehouseIn warehouseIn) {
		this.warehouseIn = warehouseIn;
	}
	public WarehouseIn get_warehouseIn() {
		return this.warehouseIn;
	}
	public int count_non_null(Client_Order[] client_order) {
		int count = 0;
		for (int i = 0; i < client_order.length; i++){
			if(client_order[i] != null)
				count++;
		}
		return count;
	}
	public void algoritmo()  {
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
			
//			Client_Order client_order_aux;
//			int index_aux = 0;
//			for(int i = 0; i < len; i++) {
//				String[] parts = client_order[i].get_status().split("-");
//				if (parts[0] == "Supplier") {
//					client_order_aux = client_order[i];
//					index_aux = i;
//					for(int j = 0; j < index_aux; j++) {
//						client_order[index_aux-j] = client_order[index_aux-j-1];	
//					}
//					client_order[0] = client_order_aux;
//				}
//			}

			for(int i = 0; i < 10; i++) {
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
			String[] parts = client_order[0].get_status().split("-");
			if(parts[0] == "Supplier") {
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
				
			}else if (parts[0] == "None") {
				
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
					
			}
        	
        	
    	}catch(NullPointerException e) {
    		// Do nothing here
    	}
		
		
		
		
		

		
	
		
					
	}
}	
