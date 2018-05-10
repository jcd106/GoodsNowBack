package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.*;

/**
 * Interface for getting Seller information from the database
 * @author Zach Vaughn
 */
@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
	
	/**
	 * Find seller by email
	 * @param email
	 * @return Seller with matching email
	 */
	public Seller findSellerByEmail(String email);
	
	/**
	 * Find seller by account
	 * @param account
	 * @return Seller with matching Account
	 */
	public Seller findSellerByAccount(Account account);

}
