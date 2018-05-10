package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.*;

/**
 * Interface for getting Customer information from the database
 * @author Zach Vaughn
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findCustomerByEmail(String email);
	public Customer findCustomerByAccount(Account account);
	
}
