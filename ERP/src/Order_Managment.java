import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Order_Managment extends Thread{
	
	private Client_Order[] client_order;
	
	public Order_Managment() {
		// TODO Auto-generated constructor stub
		client_order = new Client_Order[1000];
	}
	public Client_Order[] get_Client_Order() {
		return client_order;
	}
	public void run() {
		// ################################# Creating array of Client Orders ########################################
		System.out.println("Cheguei");
		int index = 0;
    	//int[] a = {1,1};
    	//int[] b = {1,1};
    	//int[] c = {1,1};
    	//int[] d = {1,1};
    	//String[] e = {"a","a"};
    	
    	//Client_Order client_order_aux1 = new Client_Order("client_name", a, e, b, c, d, a);
    	//client_order[0] = client_order_aux1;
    	
    	
    	//System.out.println(client_order[0].get_client_name() + "managment");
		//Client_Order[] client_order = new Client_Order[1000];
    	
    	
    	// ################################# Reading file XML to a String via UDP #####################################
    	
        /*if (args.length < 2) {
            System.out.println("Syntax: ERP <hostname> <port>");
            return;
        }*/
        
        //String hostname = args[0];
        String hostname = "127.0.0.1";
        int port = 54321;
        //int port = Integer.parseInt(args[1]);
 
        try {
            InetAddress address = InetAddress.getByName(hostname);
            DatagramSocket socket = new DatagramSocket(port);
 
            while (true) {
            	
                //DatagramPacket request = new DatagramPacket(new byte[1], 1, address, port);
                //socket.send(request);
 
                byte[] buffer = new byte[1024];
                
            

            
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);
 
                String quote = new String(buffer, 0, response.getLength());
               
        // ################################# Passing Content of XML File from String to Array of Client Orders #####################################
                String[] parts = quote.split(">");
                
       
                //Client Name
                
                //String client_name = client_name_almost[1];
                
                //System.out.println(client_name);
                //System.out.println(parts.length);
                //System.out.println(parts[7]);
                //System.out.println(parts[8]);
                //System.out.println(parts[9]);
                //System.out.println(parts[10]);
                
                
                //Client Order
                Client_Order client_order_aux;
                String[] client_name = new String[parts.length-9];
                String[] client_name_almost  = parts[6].split("\"");
                int[] order_number = new int[parts.length-9];
                String[] workPiece = new String[parts.length-9];
                int[] quantity= new int[parts.length-9];
                int[] dueDate = new int[parts.length-9];
                int[] latePen = new int[parts.length-9];;
                int[] earlyPen = new int[parts.length-9];
                String[] status = new String[parts.length-9];
                for(int i = 7; i < parts.length-2; i++) {
                	client_name[i-7] = client_name_almost[1];
                	//System.out.println(client_name[i-7]);
                	String[] order_almost  = parts[i].split("\"");
                	order_number[i-7] = Integer.parseInt(order_almost[1]);
                	workPiece[i-7] = order_almost[3];
                	quantity[i-7] = Integer.parseInt(order_almost[5]);
                	dueDate[i-7] = Integer.parseInt(order_almost[7]);
                	latePen[i-7] = Integer.parseInt(order_almost[9]);
                	earlyPen[i-7] = Integer.parseInt(order_almost[11]);
                	status[i-7] = "None-";
                	status[i-7] = status[i-7].concat(Integer.toString(quantity[i-7]));
                	client_order_aux = new Client_Order(client_name[i-7], order_number[i-7], workPiece[i-7], quantity[i-7], dueDate[i-7], latePen[i-7], earlyPen[i-7], status[i-7]);
                	client_order[index] = client_order_aux;
//                	System.out.println(client_order[index].get_client_name() + " managment");
//                	System.out.println(client_order[index].get_order_number() + " managment");
//                	System.out.println(client_order[index].get_workPiece() + " managment");
//                	System.out.println(client_order[index].get_quantity() + " managment");
//                	System.out.println(client_order[index].get_dueDate() + " managment");
//                	System.out.println(client_order[index].get_latePen() + " managment");
//                	System.out.println(client_order[index].get_earlyPen() + " managment");
                	index++;
                	//System.out.println(order_number[i-7]);
                	//System.out.println(workPiece[i-7]);
                	//System.out.println(quantity[i-7]);
                	//System.out.println(dueDate[i-7]);
                	//System.out.println(latePen[i-7]);
                	//System.out.println(earlyPen[i-7]);  	
                }
                //Client_Order client_order_aux = new Client_Order(client_name, order_number, workPiece, quantity, dueDate, latePen, earlyPen);
                //barrier.await();
                //client_order[index] = client_order_aux;
                //latch.countDown();
                //barrier.reset();
                //System.out.println(client_order[index].get_client_name() + " managment");
                
                /*for(int i = 7; i < parts.length-2; i++) {
                	System.out.println(client_order[index].get_client_name());
                	System.out.println(client_order[index].get_order_number());
                	System.out.println(client_order[index].get_workPiece());
                	System.out.println(client_order[index].get_quantity());
                	System.out.println(client_order[index].get_dueDate());
                	System.out.println(client_order[index].get_latePen());
                	System.out.println(client_order[index].get_earlyPen());
                }*/
                //index++;
                
     
 
                Thread.sleep(1000);
            }
            
        // ################################# Catches of Exceptions on the Reading XML file via UDP #####################################
        } catch (SocketTimeoutException ex) {
            System.out.println("Timeout error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
		}
        
        
        
    }
}

