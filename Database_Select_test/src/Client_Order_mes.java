
public class Client_Order_mes {
	
	
	private String client_name;
	private int order_number;
	private String workPiece;
	private int quantity;
	private int dueDate;
	private int latePen;
	private int earlyPen;
	private String status;
	private String status_mes;
	
	
	
	public Client_Order_mes(String client_name, int order_number, String workPiece, int quantity, int dueDate, int latePen, int earlyPen, String status, String status_mes){
		this.client_name = client_name;
		this.order_number = order_number;
		this.workPiece = workPiece;
		this.quantity = quantity;
		this.dueDate = dueDate;
		this.latePen = latePen;
		this.earlyPen = earlyPen;
		this.status = status;
		this.status_mes = status_mes;
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
	public String get_status() {
		return status;
	}
	public void set_status(String status) {
		this.status = status;
	}
	public String get_status_mes() {
		return status_mes;
	}
	public void set_status_mes(String status_mes) {
		this.status_mes = status_mes;
	}
	
	
	
	
}