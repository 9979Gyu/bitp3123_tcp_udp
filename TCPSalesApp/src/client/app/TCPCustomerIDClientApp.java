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
 * Part 3 Exercise 7
 */

/*
 * This class used to send customer id
 * to the server and receive customer 
 * object from the server
 */
public class TCPCustomerIDClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int id = 0;
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			System.out.println("\tExecuting TCPCustomerIDClientApp");
			
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
			System.out.print("\tEnter id: ");
			id = scanner.nextInt();
			dos.writeInt(id);
			
			// Create stream to receive response from the server
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			// 3. Read respond from the server - cast object
			Customer customer = (Customer) ois.readObject();
			
			// 4. Process response - display the object
			System.out.println("\n\tCustomer Information (From the server)");
			
			System.out.println("\tCustomer Id: " + customer.getId());
			System.out.println("\tName: " + customer.getName());
			
			outputStream.close();
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
