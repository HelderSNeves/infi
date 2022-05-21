
public class WarehouseIn extends Thread {
	private Piece[] warehouseIn_pieces;
	private volatile static String flag_supply;
	private int index;
	private Client_Order client_order;
	private volatile static int pieces_to_be_done;
	
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
		System.out.println("Boas do set_flag_supply");
	}
	public int get_pieces_to_be_done() {
		return this.pieces_to_be_done;
	}
	public void set_pieces_to_be_done(int pieces_to_be_done) {
		this.pieces_to_be_done = pieces_to_be_done;
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
			//System.out.print("a");
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
					Piece peca_p1 = new Piece(1, "WI", operations, 'C', 1, client_order, 0, 0);
					System.out.println("AAAAAAAAAAAAAAAAAAAAA    " + pieces_to_be_done + "    AAAAAAAAAAAAAAAAAAAA");
					if(pieces_to_be_done >= 4) {
						for(int i = 0; i < 4; i++) {
							warehouseIn_pieces[index] = peca_p1;
							index++;
						}
					}else {
						for(int i = 0; i < pieces_to_be_done; i++) {
							warehouseIn_pieces[index] = peca_p1;
							index++;
						}
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
				Piece peca_p2 = new Piece(2, "WI", operations, 'C', 2, client_order, 0, 0);
				System.out.println("AAAAAAAAAAAAAAAAAAAAA    " + pieces_to_be_done + "    AAAAAAAAAAAAAAAAAAAA");
				if(pieces_to_be_done >= 4) {
					for(int i = 0; i < 4; i++) {
						warehouseIn_pieces[index] = peca_p2;
						index++;
					}
				}else {
					for(int i = 0; i < pieces_to_be_done; i++) {
						warehouseIn_pieces[index] = peca_p2;
						index++;
					}
				}
				flag_supply = "None";				
			}
		}
				
	}
	
	
}
