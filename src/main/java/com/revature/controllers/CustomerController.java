package com.revature.controllers;

import java.sql.Timestamp;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.revature.models.*;
import com.revature.services.*;

/**
 * Controller for Customer CRUD operations
 * @author Josh Dughi and Zach Vaughn
 */
@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CartItemService cartItemService;
	
	@Autowired
	AccountService accountService;
	
	/**
	 * Add a new customer to the database
	 * @param newCustomer
	 * @return The customer after it has been added to the database
	 */
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@Valid @RequestBody Customer newCustomer) {
		Customer customer = customerService.addCustomer(newCustomer);
		if (customer != null) {
			if (customer.getAccount() != null) {
				customer.getAccount().setPassword("");
			}
		}
		return customer;
	}
	
	/**
	 * Manage the check out for a customer
	 * @param order
	 * @return The fully populated order after it has been added to the database
	 */
	@PostMapping(value="/checkout", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Order checkOut(@RequestBody Order order) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		order.setSubmitted(timestamp);
		Order newOrder = cartItemService.checkout(order);
		newOrder.getCustomer().getAccount().setPassword("");
		return newOrder;
	}
	
	/**
	 * Get all the customers in the database
	 * @return List of all Customers
	 */
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findAllCustomers() {
		List<Customer> customers = customerService.findAllCustomers();
		for (Customer customer : customers) {
			customer.getAccount().setPassword("");
		}
		return customers;
	}
	
	/**
	 * Get the Customer with the specified customer id from the database
	 * @param id
	 * @return The Customer with matching customer id
	 */
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer findCustomerById(@PathVariable("id") int id) {
		Customer customer = customerService.findCustomerById(id);
		customer.getAccount().setPassword("");
		return customer;
	}
	
	/**
	 * Update a customer in the database
	 * @param updatedCustomer
	 * @return The Customer after it has been updated in the database
	 */
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer updatedCustomer) {
		Account account = accountService.findAccountById(updatedCustomer.getAccount().getAccountId());
		updatedCustomer.setAccount(account);
		Customer customer = customerService.updateCustomerById(updatedCustomer);
		customer.getAccount().setPassword("");
		return customer;
	}

}
