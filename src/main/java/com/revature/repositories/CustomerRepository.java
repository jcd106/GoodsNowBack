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

	/**
	 * Find customer by email
	 * @param email
	 * @return Customer with matching email
	 */
	public Customer findCustomerByEmail(String email);
	
	/**
	 * Find customer by account
	 * @param account
	 * @return Customer with matching Account
	 */
	public Customer findCustomerByAccount(Account account);
	
}
