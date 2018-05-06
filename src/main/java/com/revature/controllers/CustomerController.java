package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Customer;
import com.revature.services.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@Valid @RequestBody Customer newCustomer) {
		Customer customer = customerService.addCustomer(newCustomer);
		customer.getAccount().setPassword("");
		return customer;
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
		Customer customer = customerService.updateCustomerById(updatedCustomer);
		customer.getAccount().setPassword("");
		return customer;
	}

}
