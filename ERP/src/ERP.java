import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class ERP {
	//private
	//Client_Order[] client_order;
	////ERP(){
	// client_order = new Client_Order[1000];
	//}
 
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
    	CyclicBarrier barrier = new CyclicBarrier(2);
    	CountDownLatch latch = new CountDownLatch(1);
    	CountDownLatch latch1 = new CountDownLatch(1);
    	Client_Order[] client_order = new Client_Order[1000];
    	Order_Managment order_managment = new Order_Managment(latch, barrier);
    	ERP_Algorithm erp_algorithm = new ERP_Algorithm(client_order, latch1);
    	
    	
    	erp_algorithm.start();
    	order_managment.start();
    	
    	//int[] a = {1,1};
    	//int[] b = {1,1};
    	//int[] c = {1,1};
    	//int[] d = {1,1};
    	//String[] e = {"a","a"};
    	
    	//Client_Order client_order_aux1 = new Client_Order("client_name", a, e, b, c, d, a);
    	//client_order[0] = client_order_aux1;
    	//int index = 0;
    	//int i = 0;
    	//int index_seguro = 0;
    	//for(int i = 0; i < 999; i++) {
    		//barrier.await();
    	latch.await();
    	client_order = order_managment.get_Client_Order();
    	System.out.println(client_order[0].get_client_name() + " erp");
    	System.out.println(client_order[0].get_order_number() + " erp");
    	System.out.println(client_order[0].get_workPiece() + " erp");
   		System.out.println(client_order[0].get_quantity() + " erp");
    	System.out.println(client_order[0].get_dueDate() + " erp");
    	System.out.println(client_order[0].get_latePen() + " erp");
    	System.out.println(client_order[0].get_earlyPen() + " erp");
    	erp_algorithm.set_client_order(client_order);
    	latch1.countDown();
    	
    	
        
    	//}
    	
    	/*do { 
    		while(true) {
    			if(order_managment.get_Client_Order()[i+1] != null) break;
    			if(i == 998) i = index_seguro-1;
    			i++;
    		}
    		client_order = order_managment.get_Client_Order();
    	//System.out.println("Length = " + client_order.length);
    		System.out.println(client_order[index].get_client_name() + " ERP");
    	//order_managment.run(args);
    		index++;
    		i++;
    	} while(order_managment.get_Client_Order()[index_seguro++] != null);*/
    	//erp_algorithm.run();
    		//System.out.println("ESTOU AQUI");
    		//System.out.println(order_managment.get_Client_Order());
    	
    	
    }
}