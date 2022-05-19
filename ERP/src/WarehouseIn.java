
public class WarehouseIn extends Thread {
	private Piece[] warehouseIn_pieces;
	private String flag_supply;
	private int index;
	private Client_Order client_order;
	
	public WarehouseIn(Piece[] warehouseIn_pieces, String flag_supply) {
		this.warehouseIn_pieces = warehouseIn_pieces;
		this.flag_supply = flag_supply;
		this.index = 0;
		this.client_order = null;
	}
	public String get_flag_supply() {
		return this.flag_supply;
	}
	public void set_flag_supply(String flag_supply) {
		this.flag_supply = flag_supply;
	}
	public Client_Order get_client_order() {
		return this.client_order;
	}
	public void set_client_order(Client_Order client_order) {
		this.client_order = client_order;
	}
	public Piece[] get_warehouseIn_pieces() {
		return this.warehouseIn_pieces;
	}
	public void set_warehouseIn_pieces(Piece[] warehouseIn_pieces) {
		this.warehouseIn_pieces = warehouseIn_pieces;
	}
	public void run() {
		while(true) {
			//System.out.println("Boas do warehouseIn");
			if(flag_supply.equals("1C")) {
					System.out.println("Cheguei antes do sleep - 1C");
					try {
						Thread.sleep(19000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Cheguei depois do sleep - 1C");
					int[] operations = new int[]{0, 0, 0, 0};
					Piece peca_p1 = new Piece(1, "WI", operations, 'C', 1, 0, 0);
					for(int i = 0; i < 4; i++) {
						warehouseIn_pieces[index] = peca_p1;
						index++;
					}
					flag_supply = "None";				
			}
			else if(flag_supply.equals("2C")) {
				System.out.println("Cheguei antes do sleep - 2C");
				try {
					Thread.sleep(19000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Cheguei depois do sleep - 2C");
				int[] operations = new int[]{0, 0, 0, 0};
				Piece peca_p2 = new Piece(2, "WB", operations, 'C', 2, 0, 0);
				for(int i = 0; i < 4; i++) {
					warehouseIn_pieces[index] = peca_p2;
					index++;
				}
				flag_supply = "None";				
			}
		}
				
	}
	
	
}
