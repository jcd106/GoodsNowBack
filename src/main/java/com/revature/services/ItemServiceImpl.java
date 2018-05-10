package com.revature.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.Item;
import com.revature.repositories.ItemRepository;

/**
 * Implementation for ItemService
 * @author Josh Dughi
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepo;
	
	@Override
	public Item addItem(Item newItem) {
		for (Item item : findAllItems()) {
			if (item.getItemName().equals(newItem.getItemName())) {
				if (item.getSeller().getSellerId() == newItem.getSeller().getSellerId()) {
					return null;
				}
			}
		}
		return itemRepo.save(newItem);
	}

	@Override
	public List<Item> findAllItems() {
		return itemRepo.findAll();
	}

	@Override
	public Item findItemById(int id) {
		return itemRepo.getOne(id);
	}

	@Override
	public List<Item> findItemsByCategory(String category) {
		return itemRepo.findItemsByCategory(category);
	}

	@Override
	public List<Item> findItemsBySeller(int sellerId) {
		return itemRepo.findItemsBySellerSellerId(sellerId);
	}
	
	@Override
	public List<Item> findItemsByCity(String city) {
		return itemRepo.findItemsBySellerCity(city);
	}

	@Override
	public List<Item> findItemsByZipcode(String zipcode) {
		return itemRepo.findItemsBySellerZipcode(zipcode);
	}

	@Override
	public Item updateItemById(Item item) {
		return itemRepo.save(item);
	}

	@Override
	public void deleteItem(Item item) {
		itemRepo.deleteById(item.getItemId());
	}
	
}
