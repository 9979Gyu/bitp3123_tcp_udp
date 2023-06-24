/**
 * 
 */
package server.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

/**
 * @author yuqin
 *
 */

// This class is used to manage customer data
public class CustomerDataManager{

	// Declare variable
	private List<Customer> customerList;
	
	/*
	 * Constructor
	 */
	public CustomerDataManager() {

		// Load customers
		this.customerList = new ArrayList<Customer>();
		this.loadCustomers();
		
	}
	
	
	/*
	 * This method will return a list of customers
	 * 
	 */
	public List<Customer> getCustomers(){
		
		return customerList;
		
	}
	

	/*
	 * This method searches a customer based on 
	 * the customer's name from a list of customers.
	 * The method will return a Customer's object 
	 * if the name exist
	 * otherwise, it will return null
	 * @return
	 * 
	 */
	public Customer getCustomerByName(String name) {
		
		for(Customer customer: customerList) {
			
			// check if the customer exist
			if((customer.getName().toLowerCase()).
					contains(name.toLowerCase()))
				return customer; 
			
		}
		
		// Return null if customer not found
		return null;
		
	}
	
	/*
	 * This method searches a customer based on 
	 * the customer's id from a list of customers.
	 * @return
	 * 
	 */
	public Customer getCustomerById(int id) {
		
		for(Customer customer: customerList) {
			
			// Check if the customer exist
			if(customer.getId() == id)
				return customer; 
			
		}
		
		// If customer not found
		Customer customer = new Customer();
		customer.setName("Customer not found");
		
		return customer;
		
	}
	
	/*
	 *  This method create list of samples
	 *  of customer data. 
	 */
	private void loadCustomers() {

		// Declare the sample data
		String nameList[] = {
			"Andy Lau", "Micheal David", "Mohammad Ali", 
			"Wang Shi", "Salehah Bendy", "Ali bin Abu",
			"David Beckham", "Rahani Stella", 
			"Chui Jun", "Wendy Lau"
		}; 
		
		// Do looping to set customer id and name
		for(int index = 0; index < nameList.length; index ++) {
			
			// Create customer
			Customer customer = new Customer();
			customer.setId(index + 1);
			customer.setName(nameList[index]);			
			
			//	Add into customerList
			customerList.add(customer);
			
		}

	}
	
}
