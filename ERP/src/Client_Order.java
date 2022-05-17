
public class Client_Order {
	
	
	private String client_name;
	private int order_number;
	private String workPiece;
	private int quantity;
	private int dueDate;
	private int latePen;
	private int earlyPen;
	
	
	
	public Client_Order(String client_name, int order_number, String workPiece, int quantity, int dueDate, int latePen, int earlyPen){
		this.client_name = client_name;
		this.order_number = order_number;
		this.workPiece = workPiece;
		this.quantity = quantity;
		this.dueDate = dueDate;
		this.latePen = latePen;
		this.earlyPen = earlyPen;
	}
	public String get_client_name() {
		return client_name;
	}
	public void set_client_name(String client_name) {
		this.client_name = client_name;
	}
	public int get_order_number() {
		return order_number;
	}
	public String get_workPiece() {
		return workPiece;
	}
	public int get_quantity() {
		return quantity;
	}
	public int get_dueDate() {
		return dueDate;
	}
	public int get_latePen() {
		return latePen;
	}
	public int get_earlyPen() {
		return earlyPen;
	}
	
	
	
	
}
