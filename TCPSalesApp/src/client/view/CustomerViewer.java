/**
 * 
 */
package client.view;

import java.util.List;

import model.Customer;
import model.Product;

/**
 * @author yuqin
 *
 */

/*
 * This class will display list of customers
 */
public class CustomerViewer {

	public void displayCustomers(List<Customer> customers) {
		
		// General information
		System.out.println("\n\tNumber of record: " + customers.size());
		System.out.println("\tCustomer Information");
		
		// Print all customers on console
		for (Customer customer : customers) {
			
			System.out.println("\tCustomer Id: " + customer.getId());
			System.out.println("\tCustomer Name: " + customer.getName() + "\n");
			
		}
		
	}
}
