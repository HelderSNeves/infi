import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class Order_Managment extends Thread{
	private
	Client_Order[] client_order;
	public
	Order_Managment(){
	 client_order = new Client_Order[1000];
	}
	Client_Order[] get_Client_Order() {
		return client_order;
	}
	public void run() {
		// ################################# Creating array of Client Orders ########################################
    	System.out.println("Cheguei");
		//Client_Order[] client_order = new Client_Order[1000];
    	int index = 0;
    	
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
                String[] client_name_almost  = parts[6].split("\"");
                String client_name = client_name_almost[1];
                
                //System.out.println(client_name);
                //System.out.println(parts.length);
                //System.out.println(parts[7]);
                //System.out.println(parts[8]);
                //System.out.println(parts[9]);
                //System.out.println(parts[10]);
                
                
                //Client Order
                int[] order_number = new int[parts.length-9];
                String[] workPiece = new String[parts.length-9];
                int[] quantity= new int[parts.length-9];
                int[] dueDate = new int[parts.length-9];;
                int[] latePen = new int[parts.length-9];;
                int[] earlyPen = new int[parts.length-9];;
                for(int i = 7; i < parts.length-2; i++) {
                	String[] order_almost  = parts[i].split("\"");
                	order_number[i-7] = Integer.parseInt(order_almost[1]);
                	workPiece[i-7] = order_almost[3];
                	quantity[i-7] = Integer.parseInt(order_almost[5]);
                	dueDate[i-7] = Integer.parseInt(order_almost[7]);
                	latePen[i-7] = Integer.parseInt(order_almost[9]);
                	earlyPen[i-7] = Integer.parseInt(order_almost[11]);
                	//System.out.println(order_number[i-7]);
                	//System.out.println(workPiece[i-7]);
                	//System.out.println(quantity[i-7]);
                	//System.out.println(dueDate[i-7]);
                	//System.out.println(latePen[i-7]);
                	//System.out.println(earlyPen[i-7]);  	
                }
                Client_Order client_order_aux = new Client_Order(client_name, order_number, workPiece, quantity, dueDate, latePen, earlyPen);
                client_order[index] = client_order_aux;
                System.out.println(client_order[index].get_client_name());
                for(int i = 7; i < parts.length-2; i++) {
                	/*System.out.println(client_order[index].get_order_number()[i-7]);
                	System.out.println(client_order[index].get_workPiece()[i-7]);
                	System.out.println(client_order[index].get_quantity()[i-7]);
                	System.out.println(client_order[index].get_dueDate()[i-7]);
                	System.out.println(client_order[index].get_latePen()[i-7]);
                	System.out.println(client_order[index].get_earlyPen()[i-7]);*/
                }
                index++;
                
     
 
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

