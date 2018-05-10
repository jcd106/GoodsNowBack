package com.revature.services;

import java.util.List;
import com.revature.models.*;

/**
 * Interface for Seller CRUD operations
 * @author Zach Vaughn
 */
public interface SellerService {
	
	/**
	 * Add a new Account and Seller to the database
	 * @param newAccount
	 * @param newSeller
	 * @return the added Seller
	 */
	public Seller addSeller(Account newAccount, Seller newSeller);
	
	/**
	 * Add a new Seller to the database
	 * @param newSeller
	 * @return the added Seller
	 */
	public Seller addSeller(Seller newSeller);
	
	/**
	 * Find all sellers in the database
	 * @return List of all sellers
	 */
	public List<Seller> findAllSellers();
	
	/**
	 * Find seller by seller id
	 * @param sellerId
	 * @return Seller with matching seller id
	 */
	public Seller findSellerById(int sellerId);
	
	/**
	 * Find seller by account
	 * @param account
	 * @return Seller with matching account
	 */
	public Seller findSellerByAccount(Account account);
	
	/**
	 * Find seller by email
	 * @param email
	 * @return Seller with matching email
	 */
	public Seller findSellerByEmail(String email);
	
	/**
	 * Update seller by seller id
	 * @param updatedSeller
	 * @return The seller after it has been updated in the database
	 */
	public Seller updateSellerById(Seller updatedSeller);

}
