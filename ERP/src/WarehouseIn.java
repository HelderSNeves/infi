import java.sql.*;
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
	public void insert_piece(int i, Statement stmt, Connection conn, Piece piece_warehouseIn) {
		int type = piece_warehouseIn.get_type();
		String position = piece_warehouseIn.get_position();
		int[] operations = piece_warehouseIn.get_operations();
		char supplier = piece_warehouseIn.get_supplier();
		int raw = piece_warehouseIn.get_raw();
		int dispatchDate = piece_warehouseIn.get_dispatchDate();
		int arrivalDate = piece_warehouseIn.get_arrivalDate();
		try {
			Client_Order client_order = piece_warehouseIn.get_client_order();
		}catch(NullPointerException e){
			Client_Order client_order = new Client_Order(null, 0, null, 0, 0, 0, 0, null);
		}

		try {
			stmt = conn.createStatement();
			String sql = "Insert INTO COMMUNICATION_PIECES " + 
					"VALUES ("+i+","+type+",'"+position+"',"+operations[0]+","+operations[1]+","+operations[2]+","+operations[3]+",'"+supplier+"',"+raw+","+dispatchDate+","+arrivalDate+",'"+client_order.get_client_name()+"',"+client_order.get_order_number()+",'"+client_order.get_workPiece()+"',"+client_order.get_quantity()+","+client_order.get_dueDate()+","+client_order.get_latePen()+","+client_order.get_earlyPen()+",'"+client_order.get_status()+"')";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
					int[] operations_null = new int[]{0, 0, 0, 0};
					int[] operations = new int[4];
					System.out.println("Cheguei depois do sleep - 1C");
					if(client_order.get_workPiece().equals("P6")) {
						for(int i = 0; i < 4; i++) {
							operations[i] = 6;
						}
					}
					if(client_order.get_workPiece().equals("P8")) {
						for(int i = 0; i < 4; i++) {
							operations[i] = 8;
						}
					}
					Piece peca_p1 = new Piece(1, "WI", operations, 'C', 1, client_order, 0, 0);
					Piece peca_p1_sem_order = new Piece(1, "WI", operations_null, 'W', 1, null, 0, 0);
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
					int len = count_non_null(warehouseIn_pieces);
					int len_pecas_nao_usadas  = 0;
					for(int i = 0; i < len; i++) {
						if (Character.compare(warehouseIn_pieces[i].get_supplier(), 'W') == 0) {
							len_pecas_nao_usadas++;
						}
					}
					System.out.println("Numero de pecas nao usadas: " + len_pecas_nao_usadas);
					if (len_pecas_nao_usadas != 0) {
						Piece piece_aux1;
						int index_aux1 = 0;
						int len1 = len;
						for(int i = 0; i < len1; i++) {
							if (Character.compare(warehouseIn_pieces[i].get_supplier(), 'W') == 0) {
								System.out.println("Peca" + i + "por usar, a ser utilizada");
								piece_aux1 = warehouseIn_pieces[i];
								index_aux1 = i;
								for(int j = 0; j < (len1-index_aux1-1); j++) {
									warehouseIn_pieces[index_aux1+j] = warehouseIn_pieces[index_aux1+j+1];	
								}
								warehouseIn_pieces[len1-1] = piece_aux1;
								len1--;
								i--;
							}
						} 
					}else {
						System.out.println("Nao ha pecas por usar");
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
					int[] operations_null = new int[]{0, 0, 0, 0};
					int[] operations = new int[4];
					if(client_order.get_workPiece().equals("P3")) {
						for(int i = 0; i < 4; i++) {
							operations[i] = 3;
						}
					}
					if(client_order.get_workPiece().equals("P4")) {
						for(int i = 0; i < 4; i++) {
							operations[i] = 4;
						}
					}
					if(client_order.get_workPiece().equals("P5")) {
						for(int i = 0; i < 4; i++) {
							operations[i] = 5;
						}
					}
					if(client_order.get_workPiece().equals("P7")) {
						for(int i = 0; i < 4; i++) {
							operations[i] = 7;
						}
					}
					if(client_order.get_workPiece().equals("P9")) {
						for(int i = 0; i < 4; i++) {
							operations[i] = 9;
						}
					}
					Piece peca_p2 = new Piece(2, "WI", operations, 'C', 2, client_order, 0, 0);
					Piece peca_p2_sem_order = new Piece(2, "WI", operations_null, 'W', 2, null, 0, 0);
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
					int len = count_non_null(warehouseIn_pieces);
					int len_pecas_nao_usadas  = 0;
					for(int i = 0; i < len; i++) {
						if (Character.compare(warehouseIn_pieces[i].get_supplier(), 'W') == 0) {
							len_pecas_nao_usadas++;
						}
					}
					System.out.println("Numero de pecas nao usadas: " + len_pecas_nao_usadas);
					if (len_pecas_nao_usadas != 0) {
						Piece piece_aux1;
						int index_aux1 = 0;
						int len1 = len;
						for(int i = 0; i < len1; i++) {
							if (Character.compare(warehouseIn_pieces[i].get_supplier(), 'W') == 0) {
								System.out.println("Peca" + i + "por usar, a ser utilizada");
								piece_aux1 = warehouseIn_pieces[i];
								index_aux1 = i;
								for(int j = 0; j < (len1-index_aux1-1); j++) {
									warehouseIn_pieces[index_aux1+j] = warehouseIn_pieces[index_aux1+j+1];	
								}
								warehouseIn_pieces[len1-1] = piece_aux1;
								len1--;
								i--;
							}
						} 
					}else {
						System.out.println("Nao ha pecas por usar");
					}				
				}
			}		
	}
	
	
}
