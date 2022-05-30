
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
	
	public static int count_non_null(Piece[] warehouseIn_pieces) {
		int count = 0;
		for (int i = 0; i < warehouseIn_pieces.length; i++){
			if(warehouseIn_pieces[i] != null)
				count++;
		}
		return count;
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
				Piece peca_p1_sem_order = new Piece(1, "WI", operations, 'W', 1, null, 0, 0);
				System.out.println("AAAAAAAAAAAAAAAAAAAAA    " + pieces_to_be_done + "    AAAAAAAAAAAAAAAAAAAA");
				int contador_pecas_p1_nao_usadas = 0;
				int[] pecas_p1_nao_usadas = new int[4];
				int index_aux_p1 = 0;
				for(int i = 0; i < count_non_null(warehouseIn_pieces); i++) {
					System.out.println(warehouseIn_pieces[i].get_supplier());
					System.out.println(warehouseIn_pieces[i].get_raw());
						if (Character.compare(warehouseIn_pieces[i].get_supplier(), 'W') == 0 && warehouseIn_pieces[i].get_raw() == 1) {
							contador_pecas_p1_nao_usadas++;
							pecas_p1_nao_usadas[index_aux_p1] = i;
							index_aux_p1++;
						}
				}
				System.out.println(pecas_p1_nao_usadas[0] + "-" +  pecas_p1_nao_usadas[1] + "-" + pecas_p1_nao_usadas[2] + "-" + pecas_p1_nao_usadas[3]);
				index_aux_p1 = 0;
				if(contador_pecas_p1_nao_usadas == 0) {
					if(pieces_to_be_done >= 4) {
						for(int i = 0; i < pieces_to_be_done; i++) {
							warehouseIn_pieces[index] = peca_p1;
							index++;
						}
					}else {
						for(int i = 0; i < pieces_to_be_done; i++) {
							warehouseIn_pieces[index] = peca_p1;
							index++;
						}
						for(int i = 0; i < (4-pieces_to_be_done); i++) {
							warehouseIn_pieces[index] = peca_p1_sem_order;
							index++;
						}
					}
					flag_supply = "None";
				}else {
					if(pieces_to_be_done > 4) {
						for(int i = 0; i < contador_pecas_p1_nao_usadas; i++) {
							warehouseIn_pieces[pecas_p1_nao_usadas[index_aux_p1]] = peca_p1;
							index_aux_p1++;
						}
						for(int i = 0; i < (pieces_to_be_done-contador_pecas_p1_nao_usadas); i++) {
							warehouseIn_pieces[index] = peca_p1;
							index++;
						}
					}else {
						if(contador_pecas_p1_nao_usadas >= pieces_to_be_done) {
							for(int i = 0; i < pieces_to_be_done; i++) {
								warehouseIn_pieces[pecas_p1_nao_usadas[index_aux_p1]] = peca_p1;
								index_aux_p1++;
							}

						}else {
							for(int i = 0; i < contador_pecas_p1_nao_usadas; i++) {
								warehouseIn_pieces[pecas_p1_nao_usadas[index_aux_p1]] = peca_p1;
								index_aux_p1++;
							}
							for(int i = 0; i < (pieces_to_be_done-contador_pecas_p1_nao_usadas); i++) {
								warehouseIn_pieces[index] = peca_p1;
								index++;
							}
							for(int i = 0; i < (4-(pieces_to_be_done-contador_pecas_p1_nao_usadas)); i++) {
								warehouseIn_pieces[index] = peca_p1_sem_order;
								index++;
							}
						}
						
					}
					flag_supply = "None";
				}
				
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
				Piece peca_p2_sem_order = new Piece(2, "WI", operations, 'W', 2, null, 0, 0);
				System.out.println("AAAAAAAAAAAAAAAAAAAAA    " + pieces_to_be_done + "    AAAAAAAAAAAAAAAAAAAA");
				int contador_pecas_p2_nao_usadas = 0;
				int[] pecas_p2_nao_usadas = new int[4];
				int index_aux_p2 = 0;
				int lenght_warehouseIn_pieces = count_non_null(warehouseIn_pieces);
				System.out.println("OLAAAAAAAAAAAAAA" + lenght_warehouseIn_pieces + "ADEUUUUUUUUUUUUUUUS");
				for(int i = 0; i < lenght_warehouseIn_pieces; i++) {
					System.out.println(warehouseIn_pieces[i].get_supplier());
					System.out.println(warehouseIn_pieces[i].get_raw());
						if (Character.compare(warehouseIn_pieces[i].get_supplier(), 'W') == 0 && warehouseIn_pieces[i].get_raw() == 2) {
							System.out.println("OLA OLA OLA OLA OLA OLA OLA OLA OLA OLA OLA");
							contador_pecas_p2_nao_usadas++;
							pecas_p2_nao_usadas[index_aux_p2] = i;
							index_aux_p2++;
						}
				}
				System.out.println(pecas_p2_nao_usadas[0] + "-" + pecas_p2_nao_usadas[1] + "-" + pecas_p2_nao_usadas[2] + "-" + pecas_p2_nao_usadas[3]);
				index_aux_p2 = 0;
				if(contador_pecas_p2_nao_usadas == 0) {
					if(pieces_to_be_done >= 4) {
						for(int i = 0; i < pieces_to_be_done; i++) {
							warehouseIn_pieces[index] = peca_p2;
							index++;
						}
					}else {
						for(int i = 0; i < pieces_to_be_done; i++) {
							warehouseIn_pieces[index] = peca_p2;
							index++;
						}
						for(int i = 0; i < (4-pieces_to_be_done); i++) {
							warehouseIn_pieces[index] = peca_p2_sem_order;
							index++;
						}
					}
					flag_supply = "None";
				}else {
					if(pieces_to_be_done > 4) {
						for(int i = 0; i < contador_pecas_p2_nao_usadas; i++) {
							warehouseIn_pieces[pecas_p2_nao_usadas[index_aux_p2]] = peca_p2;
							index_aux_p2++;
						}
						for(int i = 0; i < (pieces_to_be_done-contador_pecas_p2_nao_usadas); i++) {
							warehouseIn_pieces[index] = peca_p2;
							index++;
						}
					}else {
						if(contador_pecas_p2_nao_usadas >= pieces_to_be_done) {
							for(int i = 0; i < pieces_to_be_done; i++) {
								warehouseIn_pieces[pecas_p2_nao_usadas[index_aux_p2]] = peca_p2;
								index_aux_p2++;
							}
						}else {
							for(int i = 0; i < contador_pecas_p2_nao_usadas; i++) {
								warehouseIn_pieces[pecas_p2_nao_usadas[index_aux_p2]] = peca_p2;
								index_aux_p2++;
							}
							for(int i = 0; i < (pieces_to_be_done-contador_pecas_p2_nao_usadas); i++) {
								warehouseIn_pieces[index] = peca_p2;
								index++;
							}
							for(int i = 0; i < (4-(pieces_to_be_done-contador_pecas_p2_nao_usadas)); i++) {
								warehouseIn_pieces[index] = peca_p2_sem_order;
								index++;
							}
						}
						
					}
					flag_supply = "None";
				}
								
			}
		}
				
	}
	
	
}
