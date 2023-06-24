/**
 * 
 */
package server.app;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import model.Customer;
import server.controller.CustomerDataManager;

/**
 * @author yuqin
 *
 * Part 3 Exercise 9
 * 
 */

/*
 * This class will return a list of customers
 * to the client.
 */
public class TCPCustomersServerApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int portNo = 8082;
		
		System.out.println("\n\tExecuting TCPProductsServerApp");
		
		CustomerDataManager manager = new CustomerDataManager();

		try {
			
			System.out.println("\n\tWaiting for next request");
			
			// Bind to a port
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			// Server need to continually run to listen to request
			while(true) {
			
				// Accept request from client
				Socket clientSocket = serverSocket.accept();
				
				// Get customer
				List<Customer> customers = manager.getCustomers();
				
				// Respond to client
				OutputStream os = clientSocket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(customers);
				System.out.println("\tSending : " + customers.size()
					+ " customers");
				
			}
			
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
	}

}
