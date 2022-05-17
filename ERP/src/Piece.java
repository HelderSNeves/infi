
public class Piece {
	
	private int type;
	private String position;
	private int[] operations;
	private char supplier;
	private int raw;
	private Client_Order client_order;
	private int dispatchDate;
	private int arrivalDate;
		
		
	public Piece(int type, String position, int[] operations, char supplier, int raw, Client_Order client_order, int dispatchDate, int arrivalDate) {
		this.type = type;
		this.position = position;
		this.operations = operations;
		this.supplier = supplier;
		this.raw = raw;
		this.client_order = client_order;
		this.dispatchDate = dispatchDate;
		this.arrivalDate = arrivalDate;
	}
	public int get_type() {
		return this.type;
	}
	public void set_type(int type) {
		this.type = type;
	}
	public String get_position() {
		return this.position;
	}
	public void set_position(String position) {
		this.position = position;
	}
	public int[] get_operations() {
		return this.operations;
	}
	public void set_operations(int[] operations) {
		this.operations = operations;
	}
	public char get_supplier() {
		return this.supplier;
	}
	public void set_supplier(char supplier) {
		this.supplier = supplier;
	}
	public int get_raw() {
		return this.raw;
	}
	public void set_raw(int raw) {
		this.raw = raw;
	}
	public Client_Order get_client_order() {
		return this.client_order;
	}
	public void set_client_order(Client_Order client_order) {
		this.client_order = client_order;
	}
	public int get_dispatchDate() {
		return this.dispatchDate;
	}
	public void set_dispatchDate(int dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public int get_arrivalDate() {
		return this.arrivalDate;
	}
	public void set_arrivalDate(int arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public double total_cost(int dispatchDate, int arrivalDate, char supplier, int raw, Client_Order client_order) {
		// Ainda por fazer
		
		return 0.0;
	}
	
}
