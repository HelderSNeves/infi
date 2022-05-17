
public class Warehouse_B extends Thread {
	private Piece[] warehouseB_pieces;
	private String flag_supply;
	//private Client_Order[] client_order;
	
	public Warehouse_B(Piece[] warehouseB_pieces, String flag_supply) {
		this.warehouseB_pieces = warehouseB_pieces;
		this.flag_supply = flag_supply;
	}
	public String get_flag_supply() {
		return this.flag_supply;
	}
	public void set_flag_supply(String flag_supply) {
		this.flag_supply = flag_supply;
	}
//	public void order_supplier(int type, char supplier) {
//		if(type == 1) {
//			if(supplier == 'A') {
//				
//			}
//			if(supplier == 'B') {
//				
//			}
//			if(supplier == 'C') {
//				
//			}
//		}
//		if(type == 2) {
//			if(supplier == 'A') {
//				
//			}
//			if(supplier == 'B') {
//				
//			}
//			if(supplier == 'C') {
//				
//			}
//		}
//		
//	}
//	public void run() {
//		Thread order_supplier_1A = new Thread() {
//			@Override
//			public void run() {
//				while(true) {
//					
//				}
//				
//			}
//		}
//		while (true) {
//			
//		}
//	}
	
}
