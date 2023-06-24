/**
 * 
 */
package server.app;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Customer;
import server.controller.CustomerDataManager;

/**
 * @author yuqin
 * 
 * Part 3 Exercise 4
 */

/*
 * This class will process requests from client.
 * It will only find and return the first customer data
 * that matches the name requested by client
 */
public class TCPCustomerNameServerApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Define a port number
		int portNo = 8081;
		
		CustomerDataManager manager = new CustomerDataManager();
		
		System.out.println("\n\tExecuting TCPCustomerNameServerApp");
		
		try {
			
			System.out.println("\tWaiting for next request");
			
			// Bind to a port
			ServerSocket serverSocket =	new ServerSocket(portNo);
			
			// Server need to continually run to listen to request
			while(true) {
				
				// Accept request from the client
				Socket clientSocket = serverSocket.accept();
				
				// Process request - create input stream to read request
				InputStream is = clientSocket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				// Request - customer name: String
				// Read customer name from client
				String name = dis.readUTF();
				System.out.println("\n\tRequest for customer name : " 
						+ name);
				
				// Get customer
				Customer customer = manager.getCustomerByName(name);
				
				// Respond to client
				OutputStream os = clientSocket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(customer);
				
				if(customer != null) {
					System.out.print("\tSending customer data : " + 
							customer.getId() + " " + customer.getName() + "\n");
				}
				else {
					System.out.print("\tSending customer data : " + customer);
				}
				
				
			}
			
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			
		}

	}

}
