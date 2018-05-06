package com.revature.services;

import java.util.List;
import com.revature.models.Item;

public interface ItemService {
	
	public Item addItem(Item item);
	public List<Item> findAllItems();
	public Item findItemById(int id);
	public List<Item> findItemsByCategory(String category);
	public List<Item> findItemsBySeller(int sellerId);
	public List<Item> findItemsByCity(String city);
	public List<Item> findItemsByZipcode(String zipcode);
	public Item updateItemById(Item item);
	public void deleteItem(Item item);

}
