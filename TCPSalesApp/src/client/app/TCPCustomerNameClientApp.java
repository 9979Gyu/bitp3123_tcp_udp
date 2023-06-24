/**
 * 
 */
package client.app;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import model.Customer;

/**
 * @author yuqin
 * 
 * Part 3 Exercise 5
 */

/*
 * This class used to send customer name 
 * to the server and receive customer 
 * object from the server
 */
public class TCPCustomerNameClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String name = "";
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.println("\tExecuting TCPCustomerNameClientApp");
			
			// Server information
			int serverPortNo = 8081;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// Connect to remote machine
			Socket socket = new Socket(serverAddress, serverPortNo);
			
			// Create stream to send request
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			// Send request to the server
			System.out.print("\tEnter name: ");
			name = scanner.nextLine();
			dos.writeUTF(name);
			
			// Create stream to receive response from the server
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			// Read respond from the server - cast object
			Customer customer = (Customer) ois.readObject();
			
			// Process response - display the object
			System.out.println("\n\tCustomer Information (From the server)");
			
			if(customer != null) {
				System.out.println("\tCustomer Id: " + customer.getId());
				System.out.println("\tName: " + customer.getName());
			}
			else {
				System.out.println("\tCustomer Id: - ");
				System.out.println("\tName: Customer not found");
			}
			
			
			os.close();
			dos.close();
			is.close();
			ois.close();
			scanner.close();
			
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			
		}

	}

}
