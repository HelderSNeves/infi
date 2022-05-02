
public class Client_Order {
	private
	
	String client_name;
	int order_number[];
	String workPiece[];
	int quantity[];
	int dueDate[];
	int latePen[];
	int earlyPen[];
	
	public
	
	Client_Order(String client_name, int[] order_number, String[] workPiece, int[] quantity, int[] dueDate, int[] latePen, int[] earlyPen){
		this.client_name = client_name;
		this.order_number = order_number;
		this.workPiece = workPiece;
		this.quantity = quantity;
		this.dueDate = dueDate;
		this.latePen = latePen;
		this.earlyPen = earlyPen;
	}
	String get_client_name() {
		return client_name;
	}
	int[] get_order_number() {
		return order_number;
	}
	String[] get_workPiece() {
		return workPiece;
	}
	int[] get_quantity() {
		return quantity;
	}
	int[] get_dueDate() {
		return dueDate;
	}
	int[] get_latePen() {
		return latePen;
	}
	int[] get_earlyPen() {
		return earlyPen;
	}
	
	
	
	
}
