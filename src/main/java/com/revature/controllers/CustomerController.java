package com.revature.controllers;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.*;
import com.revature.services.*;

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
	
	@PostMapping(value="/checkout", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Order checkOut(@RequestBody Order order) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		order.setSubmitted(timestamp);
		return cartItemService.checkout(order);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findAllCustomers() {
		List<Customer> customers = customerService.findAllCustomers();
		for (Customer customer : customers) {
			customer.getAccount().setPassword("");
		}
		return customers;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer findCustomerById(@PathVariable("id") int id) {
		Customer customer = customerService.findCustomerById(id);
		customer.getAccount().setPassword("");
		return customer;
	}
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer updatedCustomer) {
		Account account = accountService.findAccountById(updatedCustomer.getAccount().getAccountId());
		updatedCustomer.setAccount(account);
		Customer customer = customerService.updateCustomerById(updatedCustomer);
		customer.getAccount().setPassword("");
		return customer;
	}

}
