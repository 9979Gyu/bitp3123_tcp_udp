/**
 * 
 */
package server.controller;

import java.util.ArrayList;
import java.util.List;

import model.Customer;

/**
 * @author yuqin
 *
 */

// This class is used to manage customer data
public class CustomerDataManager {

	// Declare variable
	private List<Customer> customerList;
	
	public CustomerDataManager() {

		// Load customers
		this.customerList = new ArrayList<Customer>();
		this.loadCustomers();
		
	}
	
	/*
	 *  This method create list of samples
	 *  of customer data. 
	 */
	private void loadCustomers() {

		// Declare the customer name list
		String nameList[] = {
			"Andy Lau", "Micheal David", "Mohammad Ali", 
			"Wang Shi", "Salehah Bendy", "Ali bin Abu",
			"David Beckham", "Rahani Stella", 
			"Chui Jun", "Wendy Lau"
		}; 
		
		// Do looping to set customer id and name
		for(int index = 0; index < 10; index ++) {
			
			Customer customer = new Customer();
			
			customer.setId(index + 1);
			customer.setName(nameList[index]);			
			
			// add into customerList
			customerList.add(customer);
			
		}

	}
	
	/*
	 * This method searches a customer based on 
	 * the customer's name from a list of customers.
	 * @return
	 * 
	 */
	public Customer getCustomer(String name) {
		
		for(Customer customer: customerList) {
			
			// check if the customer exist
			if((customer.getName()).contains(name))
				return customer; 
			
		}
		
		// Return null if customer not found
		return null;
		
	}
	
	
	/*
	 * This method will return a list of customers
	 * 
	 */
	public List<Customer> getCustomers(){
		
		return customerList;
		
	}
	
}
