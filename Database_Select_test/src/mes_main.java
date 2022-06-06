
public class mes_main {
	volatile static int seconds = 0;
	
	public static int count_non_null(Piece_mes[] warehouseIn_pieces) {
		int count = 0;
		for (int i = 0; i < warehouseIn_pieces.length; i++){
			if(warehouseIn_pieces[i] != null)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counting_Time_mes counting_time_mes = new Counting_Time_mes(0, 0, 0);
		Piece_mes[] warehouseIn_pieces = new Piece_mes[1000];
		Piece_mes[] pecas_helder = new Piece_mes[1000];
		SelectDataBase_mes selectDataBase_mes = new SelectDataBase_mes(warehouseIn_pieces);
		counting_time_mes.start();
		selectDataBase_mes.start();
		int index = 1;
		while (true) {
    		seconds = counting_time_mes.get_current_time_seconds();
    		//System.out.print(seconds);
    		if (seconds == (1*index)) {
    			index++;
    			warehouseIn_pieces = selectDataBase_mes.get_warehouseIn_pieces();
    			int count_warehouseIn = count_non_null(warehouseIn_pieces);
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
        				//if(warehouseIn_pieces[i].get_client_order() != null) {
        					System.out.println("-----------Client_Order-------------: \n"
    								+  "Client Name: " + warehouseIn_pieces[i].get_client_order().get_client_name() + "\n"
    								+  "Order Number: " + warehouseIn_pieces[i].get_client_order().get_order_number() + "\n"
    								+  "WorkPiece: " + warehouseIn_pieces[i].get_client_order().get_workPiece() + "\n"
    								+  "Quantity: " + warehouseIn_pieces[i].get_client_order().get_quantity() + "\n"
    								+  "Due Date: " + warehouseIn_pieces[i].get_client_order().get_dueDate() + "\n"
    								+  "Late Penalty: " + warehouseIn_pieces[i].get_client_order().get_latePen() + "\n"
    								+  "Early Penalty: " + warehouseIn_pieces[i].get_client_order().get_earlyPen() + "\n"
    								+  "Status: " + warehouseIn_pieces[i].get_client_order().get_status() + "\n"
    								+  "Status_MES" + warehouseIn_pieces[i].get_client_order().get_status_mes()); 
        				//} else {
        				//	System.out.println("-----------Client_Order-------------: \n");
        				//	System.out.println("NUUUUUUUUUUUUULAAAAAAAAAAAAAAAAA");
        				//}
        				
    				}
    			for(int i = 0; i < count_warehouseIn; i++) {
    				if(warehouseIn_pieces[i].get_client_order().get_client_name().equals("null")) {
    					
    				}else {
    					if(warehouseIn_pieces[i].get_type() == 1) {
    						System.out.println("Coloque uma peça P1 no Tapete do Canto Superior Esquerdo");
    						while(true) {
    							//if(TP1.presenca){
    							//pecas_helder = warehousein
    							//break
    							//}	
    						}
    					}else if(warehouseIn_pieces[i].get_type() == 2) {
    						System.out.println("Coloque uma peça P2 no Tapete do Canto Inferior Esquerdo");
    						while(true) {
    							//if(TP2.presenca){
    							//pecas_helder = warehousein
    							//break
    							//}	
    						}
    					}
    				}
    			}
    			
    			}catch(NullPointerException e) {
    	    		// Do nothing here
    	    	}
    			
    		}
		
		}
	}

}
