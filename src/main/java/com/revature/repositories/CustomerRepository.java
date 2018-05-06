package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.*;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findCustomerByEmail(String email);
	public Customer findCustomerByAccount(Account account);
	
}
