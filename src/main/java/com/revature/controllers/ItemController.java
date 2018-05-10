package com.revature.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.revature.models.*;
import com.revature.services.*;

/**
 * Controller for Item CRUD operations
 * @author Josh Dughi
 */
@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	SellerService sellerService;
	
	/**
	 * Add a new item to the database
	 * @param newItem
	 * @return The item after it has been added to the database
	 */
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Item addItem(@RequestBody Item newItem) {
		Item item = itemService.addItem(newItem);
		if (item != null) {
			item.setSeller(null);
		}
		return item;
	}
	
	/**
	 * Get all items in the database
	 * @return List of all Items
	 */
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> findAllItems() {
		List<Item> items = itemService.findAllItems();
		for (Item item : items) {
			item.setSeller(null);
		}
		return items;
	}
	
	/**
	 * Get the Item with the specified item id from the database
	 * @param id
	 * @return The Item with matching item id
	 */
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Item findItemById(@PathVariable("id") int id) {
		Item item = itemService.findItemById(id);
		item.setSeller(null);
		return item;
	}
	
	/**
	 * Get all items with the specified category from the database
	 * @param category
	 * @return List of all Items with matching category
	 */
	@GetMapping(value="/category={category}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> findItemsByCategory(@PathVariable("category") String category) {
		List<Item> items = itemService.findItemsByCategory(category);
		for (Item item : items) {
			item.setSeller(null);
		}
		return items;
	}
	
	/**
	 * Get all items with the specified seller id from the database
	 * @param id
	 * @return List of all Items with matching seller id
	 */
	@GetMapping(value="/sellerId={id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> findItemsBySeller(@PathVariable("id") int id) {
		List<Item> items = itemService.findItemsBySeller(id);
		for (Item item : items) {
			item.setSeller(null);
		}
		return items;
	}
	
	/**
	 * Get all items with specified seller city from the database
	 * @param city
	 * @return List of all Items with matching seller city
	 */
	@GetMapping(value="/city={city}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> findItemsByCity(@PathVariable("city") String city) {
		List<Item> items = itemService.findItemsByCity(city);
		for (Item item : items) {
			item.setSeller(null);
		}
		return items;
	}
	
	/**
	 * Get all items with specified seller city from the database
	 * @param city
	 * @return List of all Items with matching seller zipcode
	 */
	@GetMapping(value="/zipcode={zipcode}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> findItemsByZipcode(@PathVariable("zipcode") String zipcode) {
		List<Item> items = itemService.findItemsByZipcode(zipcode);
		for (Item item : items) {
			item.setSeller(null);
		}
		return items;
	}
	
	/**
	 * Update an Item in the database
	 * @param updatedItem
	 * @return The Item after it has been updated in the database
	 */
	@PutMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Item updateItem(@RequestBody Item updatedItem) {
		Seller seller = sellerService.findSellerById(updatedItem.getSeller().getSellerId());
		updatedItem.setSeller(seller);
		Item item = itemService.updateItemById(updatedItem);
		item.setSeller(null);
		return item;
	}
	
	/**
	 * Delete an Item from the database
	 * @param deleteItem
	 */
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteItem(@RequestBody Item deleteItem) {
		itemService.deleteItem(deleteItem);
	}

}
