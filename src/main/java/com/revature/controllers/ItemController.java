package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Item;
import com.revature.services.ItemService;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Item addItem(@RequestBody Item newItem) {
		Item item = itemService.addItem(newItem);
		item.setSeller(null);
		return item;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> findAllItems() {
		List<Item> items = itemService.findAllItems();
		for (Item item : items) {
			item.setSeller(null);
		}
		return items;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Item findItemById(@PathVariable("id") int id) {
		Item item = itemService.findItemById(id);
		item.setSeller(null);
		return item;
	}
	
	@GetMapping(value="/category={category}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> findItemsByCategory(@PathVariable("category") String category) {
		List<Item> items = itemService.findItemsByCategory(category);
		for (Item item : items) {
			item.setSeller(null);
		}
		return items;
	}
	
	@GetMapping(value="/sellerId={id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> findItemsBySeller(@PathVariable("id") int id) {
		List<Item> items = itemService.findItemsBySeller(id);
		for (Item item : items) {
			item.setSeller(null);
		}
		return items;
	}
	
	@GetMapping(value="/city={city}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> findItemsByCity(@PathVariable("city") String city) {
		List<Item> items = itemService.findItemsByCity(city);
		for (Item item : items) {
			item.setSeller(null);
		}
		return items;
	}
	
	@GetMapping(value="/zipcode={zipcode}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> findItemsByZipcode(@PathVariable("zipcode") String zipcode) {
		List<Item> items = itemService.findItemsByZipcode(zipcode);
		for (Item item : items) {
			item.setSeller(null);
		}
		return items;
	}
	
	@PutMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Item updateItem(@RequestBody Item updatedItem) {
		Item item = itemService.updateItemById(updatedItem);
		item.setSeller(null);
		return item;
	}
	
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteItem(@RequestBody Item deleteItem) {
		itemService.deleteItem(deleteItem);
	}

}
