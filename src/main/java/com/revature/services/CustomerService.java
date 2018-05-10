package com.revature.services;

import java.util.List;
import com.revature.models.*;

/**
 * Interface for Customer CRUD operations
 * @author Zach Vaughn
 */
public interface CustomerService {
	
	/**
	 * Add a new Account and Customer to the database
	 * @param newAccount
	 * @param newCustomer
	 * @return the added Customer
	 */
	public Customer addCustomer(Account newAccount, Customer newCustomer);
	
	/**
	 * Add a new Customer to the database
	 * @param newCustomer
	 * @return the added Customer
	 */
	public Customer addCustomer(Customer newCustomer);
	
	/**
	 * Find all customers in the database
	 * @return List of all customers
	 */
	public List<Customer> findAllCustomers();
	
	/**
	 * Find customer by customer id
	 * @param id
	 * @return Customer with matching customer id
	 */
	public Customer findCustomerById(int id);
	
	/**
	 * Find customer by account
	 * @param account
	 * @return Customer with matching account
	 */
	public Customer findCustomerByAccount(Account account);
	
	/**
	 * Find customer by email
	 * @param email
	 * @return Customer with matching email
	 */
	public Customer findCustomerByEmail(String email);
	
	/**
	 * Update customer by customer id
	 * @param updatedCustomer
	 * @return The customer after it has been updated in the database
	 */
	public Customer updateCustomerById(Customer updatedCustomer);

}
