import java.util.concurrent.CountDownLatch;

public class ERP_Algorithm extends Thread{
	
	private Client_Order[] client_order;
	private CountDownLatch latch1;
	
	public ERP_Algorithm(Client_Order[] client_order, CountDownLatch latch1) {
		this.client_order = client_order;
		this.latch1 = latch1;
	}
	public void set_client_order(Client_Order[] client_order) {
		this.client_order = client_order;
	}
	public void run()  {
		//client_order = new Client_Order[1000];
		//int i = 0;
		//Order_Managment order_managment = new Order_Managment();
		//client_order = order_managment.get_Client_Order();
		//while(true) {
			//try {
				//if(order_managment.get_Client_Order() == null) { }
				//else{//long start = System.currentTimeMillis();
					//client_order = order_managment.get_Client_Order();
		System.out.println("Boas");
		try {
			latch1.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// aqui ja fez o set ou seja ja temos aqui o primeiro elemento do vetor
		
		//System.out.println(client_order[0].get_client_name() + " algorithm");
		System.out.println(client_order[0].get_client_name() + " algorithm");
    	System.out.println(client_order[0].get_order_number() + " algorithm");
    	System.out.println(client_order[0].get_workPiece() + " algorithm");
   		System.out.println(client_order[0].get_quantity() + " algorithm");
    	System.out.println(client_order[0].get_dueDate() + " algorithm");
    	System.out.println(client_order[0].get_latePen() + " algorithm");
    	System.out.println(client_order[0].get_earlyPen() + " algorithm");
		
					
					//System.out.println(client_order[i].get_client_name() + "asd");
					//long end = System.currentTimeMillis();
					//long elapsedTime = end - start;
					//System.out.println(elapsedTime);
					//i++;
				//}
			//}catch (NullPointerException ex) {
			//	System.out.println("Nulooo");
			//}
		//} 
	}
}	
