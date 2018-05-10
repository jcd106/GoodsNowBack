package com.revature.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.revature.models.CartItem;
import com.revature.services.CartItemService;

/**
 * Controller for CartItemController CRUD operations
 * @author jcdug
 *
 */
@RestController
@RequestMapping("/cartitems")
@CrossOrigin
public class CartItemController {
	
	@Autowired
	CartItemService cartItemService;
	
	/**
	 * Add a new cart item to the database
	 * @param newCartItem
	 * @return The CartItem after it has been added to the database
	 */
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public CartItem addCartItem(@RequestBody CartItem newCartItem) {
		CartItem cartItem = cartItemService.addCartItem(newCartItem);
		cartItem.getItem().setSeller(null);
		if (cartItem.getCustomer().getAccount() != null) {
			cartItem.getCustomer().getAccount().setPassword("");
		}
		return cartItem;
	}
	
	/**
	 * Get all cart items in the database
	 * @return List of all CartItems
	 */
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CartItem> findAllCartItems() {
		List<CartItem> cartItems = cartItemService.findAllCartItems();
		for (CartItem cartItem : cartItems) {
			cartItem.getItem().setSeller(null);
			cartItem.getCustomer().getAccount().setPassword("");
		}
		return cartItems;
	}
	
	/**
	 * Get all cart items with specified customer id
	 * @param id
	 * @return List of all CartItems with matching customer id
	 */
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CartItem> findAllCartItemsByCustomerId(@PathVariable("id") int id) {
		List<CartItem> cartItems = cartItemService.findCartItemsByCustomerId(id);
		for (CartItem cartItem : cartItems) {
			cartItem.getItem().setSeller(null);
			cartItem.getCustomer().getAccount().setPassword("");
		}
		return cartItems;
	}
	
	/**
	 * Update a cart item in the database
	 * @param updatedCartItem
	 * @return The CartItem after it has been updated in the database
	 */
	@PutMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public CartItem updateCartItem(@RequestBody CartItem updatedCartItem) {
		CartItem cartItem = cartItemService.updateCartItemById(updatedCartItem);
		cartItem.getItem().setSeller(null);
		cartItem.getCustomer().getAccount().setPassword("");
		return cartItem;
	}
	
	/**
	 * Delete a cart item from the database
	 * @param deleteCartItem
	 */
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteCartItem(@RequestBody CartItem deleteCartItem) {
		cartItemService.deleteCartItem(deleteCartItem);
	}
}
