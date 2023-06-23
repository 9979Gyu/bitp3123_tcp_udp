/**
 * 
 */
package client.app;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import model.Customer;

/**
 * @author yuqin
 *
 */

/*
 * This class used to send several customer 
 * names to the server and receive customer 
 * object from the server
 */
public class TCPCustomerClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String name = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.println("\tExecuting TCPCustomerClientApp");
			
			// Server information
			int serverPortNo = 8080;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// 1. Connect to remote machine
			Socket socket = new Socket(serverAddress, serverPortNo);
			
			// Create stream to send request
			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dos =
					new DataOutputStream(outputStream);
			
			// 2. Send request to the server
			System.out.println("\tEnter name: ");
			name = scanner.nextLine();
			dos.writeUTF(name);
			
			// Create stream to receive response from the server
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			// 3. Read respond from the server - cast objects
			Customer customer = (Customer) ois.readObject();
			
			// 4. Process response - display the object
			System.out.println("\tCustomer Information (From the server)");
			System.out.println("\tCustomer Id: " + customer.getId());
			System.out.println("\tName: " + customer.getName());
			
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			
		}

	}

}
