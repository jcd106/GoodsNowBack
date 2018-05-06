package com.revature.services;

import java.util.List;

import com.revature.models.*;

public interface CustomerService {
	
	public Customer addCustomer(Account newAccount, Customer newCustomer);
	public Customer addCustomer(Customer newCustomer);
	public List<Customer> findAllCustomers();
	public Customer findCustomerById(int id);
	public Customer findCustomerByAccount(Account account);
	public Customer findCustomerByEmail(String email);
	public Customer updateCustomerById(Customer updatedCustomer);

}
