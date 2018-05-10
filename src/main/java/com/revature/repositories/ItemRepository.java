package com.revature.repositories;

import org.springframework.stereotype.Repository;
import com.revature.models.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for getting Item information from the database
 * @author Josh Dughi
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	/**
	 * Find items by category
	 * @param category
	 * @return List of Items with matching category
	 */
	public List<Item> findItemsByCategory(String category);
	
	/**
	 * Find items by sellerId
	 * @param sellerId
	 * @return List of Items with matching sellerId
	 */
	public List<Item> findItemsBySellerSellerId(int sellerId);
	
	/**
	 * Find items by seller's city
	 * @param city
	 * @return List of Items with matching seller city
	 */
	public List<Item> findItemsBySellerCity(String city);
	
	/**
	 * Find items by seller's zipcode
	 * @param zipcode
	 * @return List of Items with matching seller zipcode
	 */
	public List<Item> findItemsBySellerZipcode(String zipcode);

}
