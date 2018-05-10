package com.revature.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.*;
import com.revature.repositories.*;

/**
 * Implementation for CustomerService
 * @author Zach Vaughn
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	AccountRepository accountRepo;
	
	@Override
	public Customer addCustomer(Account newAccount, Customer newCustomer) {
		for (Account account : accountRepo.findAll()) {
			if (account.getUsername().equals(newAccount.getUsername())) {
				return null;
			}
		}
		for (Customer customer : findAllCustomers()) {
			if (customer.getEmail().equals(newCustomer.getEmail())) {
				return null;
			}
		}
		Account account = accountRepo.save(newAccount);
		newCustomer.setAccount(account);
		return customerRepo.save(newCustomer);
	}
	
	@Override
	public Customer addCustomer(Customer newCustomer) {
		for (Customer customer : findAllCustomers()) {
			if (customer.getEmail().equals(newCustomer.getEmail())) {
				return null;
			}
		}
		return customerRepo.save(newCustomer);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer findCustomerById(int id) {
		return customerRepo.getOne(id);
	}
	
	@Override
	public Customer findCustomerByAccount(Account account) {
		return customerRepo.findCustomerByAccount(account);
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		return customerRepo.findCustomerByEmail(email);
	}

	@Override
	public Customer updateCustomerById(Customer updatedCustomer) {
		return customerRepo.save(updatedCustomer);
	}

}
