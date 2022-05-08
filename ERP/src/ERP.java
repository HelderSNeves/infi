
public class ERP {
 
    public static void main(String[] args) {
    	
    	Order_Managment order_managment = new Order_Managment();
    	ERP_Algorithm erp_algorithm = new ERP_Algorithm();
    	
    	erp_algorithm.start();
    	order_managment.start();
    	//order_managment.run(args);
    	
    	//erp_algorithm.run();
    		//System.out.println("ESTOU AQUI");
    		//System.out.println(order_managment.get_Client_Order());
    	
    	
}
}