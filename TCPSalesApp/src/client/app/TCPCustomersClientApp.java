/**
 * 
 */
package client.app;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import model.Customer;
import client.view.CustomerViewer;

/**
 * @author yuqin
 *
 * Part 3 Exercise 10
 * 
 */

/*
 * This class will receive a list 
 * of customers from the server 
 * 
 */
public class TCPCustomersClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			// Server information
			int serverPortNo = 8082;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// Connect to remote machine
			Socket socket = new Socket(serverAddress, serverPortNo);
			
			// Create stream to receive response from the server
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			// Read the respond from the server - cast the object
			List<Customer> customers = (List<Customer>) ois.readObject();
			
			// Process response - display the object
			CustomerViewer customerViewer = new CustomerViewer();
			customerViewer.displayCustomers(customers);
			
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			
		}

	}

}
