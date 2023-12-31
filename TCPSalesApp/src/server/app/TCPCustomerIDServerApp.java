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
 * Part 3 Exercise 6
 */

/*
 * This class will process requests from client 
 */
public class TCPCustomerIDServerApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int portNo = 8080;
		
		CustomerDataManager manager = new CustomerDataManager();
		
		System.out.println("\n\tExecuting TCPCustomerIDServerApp");
		
		try {
			
			System.out.println("\tWaiting for next request");
			
			// 1. Bind to a port
			ServerSocket serverSocket = new ServerSocket(portNo); 
			
			// 2. Server need to continually run to listen to request
			while (true) {
				
				// 3. Accept request from client
				Socket clientSocket = serverSocket.accept();
				
				// 4. Process request - create input stream to read request
				InputStream is = clientSocket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				// Request - customer id:int
				// Read customer id from client
				int customerId = dis.readInt();
				System.out.println("\n\tRequest for customer id : " 
						+ customerId);
				
				// Get customer
				Customer customer = manager.getCustomerById(customerId);
				
				// 5. Respond to client
				OutputStream os  = clientSocket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(customer);
				
				System.out.print("\tSending customer data : " + 
						customer.getId() + " " + customer.getName() + "\n");
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

	}

}
