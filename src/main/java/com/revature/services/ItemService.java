package com.revature.services;

import java.util.List;
import com.revature.models.Item;

/**
 * Interface for Item CRUD operations
 * @author Josh Dughi
 *
 */
public interface ItemService {
	
	/**
	 * Add a new Item to the database
	 * @param item
	 * @return the added Item
	 */
	public Item addItem(Item item);
	
	/**
	 * Find all items in the database
	 * @return List of all items
	 */
	public List<Item> findAllItems();
	
	/**
	 * Find item by item id
	 * @param id
	 * @return Item with matching item id
	 */
	public Item findItemById(int id);
	
	/**
	 * Find all items with given category
	 * @param category
	 * @return List of all items with matching category
	 */
	public List<Item> findItemsByCategory(String category);
	
	/**
	 * Find all items with given seller id
	 * @param sellerId
	 * @return List of all items with matching seller id
	 */
	public List<Item> findItemsBySeller(int sellerId);
	
	/**
	 * Find all items with given seller city
	 * @param city
	 * @return List of items with matching seller city
	 */
	public List<Item> findItemsByCity(String city);
	
	/**
	 * Find all items with given seller zipcode
	 * @param zipcode
	 * @return List of items with matching zipcode
	 */
	public List<Item> findItemsByZipcode(String zipcode);
	
	/**
	 * Update item by item id
	 * @param item
	 * @return The item after it has been updated in the database
	 */
	public Item updateItemById(Item item);
	
	/**
	 * Delete an item from the database
	 * @param item
	 */
	public void deleteItem(Item item);

}
