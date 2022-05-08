
public class ERP_Algorithm extends Thread{
	private
	Client_Order[] client_order;
	public void run() {
		client_order = new Client_Order[1000];
		int i = 0;
		Order_Managment order_managment = new Order_Managment();
		//client_order = order_managment.get_Client_Order();
		while(true) {
			//if(order_managment.get_Client_Order() != null) { }
			//long start = System.currentTimeMillis();
			client_order = order_managment.get_Client_Order();
			System.out.println(client_order[i].get_client_name());
			//long end = System.currentTimeMillis();
			//long elapsedTime = end - start;
			//System.out.println(elapsedTime);
			i++;
		}
	}
}
