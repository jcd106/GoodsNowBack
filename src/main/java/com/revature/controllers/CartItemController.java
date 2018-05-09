package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.CartItem;
import com.revature.services.CartItemService;

@RestController
@RequestMapping("/cartitems")
@CrossOrigin
public class CartItemController {
	
	@Autowired
	CartItemService cartItemService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public CartItem addCartItem(@RequestBody CartItem newCartItem) {
		CartItem cartItem = cartItemService.addCartItem(newCartItem);
		cartItem.getItem().setSeller(null);
		if (cartItem.getCustomer().getAccount() != null) {
			cartItem.getCustomer().getAccount().setPassword("");
		}
		return cartItem;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CartItem> findAllCartItems() {
		List<CartItem> cartItems = cartItemService.findAllCartItems();
		for (CartItem cartItem : cartItems) {
			cartItem.getItem().setSeller(null);
			cartItem.getCustomer().getAccount().setPassword("");
		}
		return cartItems;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CartItem> findAllCartItemsByCustomerId(@PathVariable("id") int id) {
		List<CartItem> cartItems = cartItemService.findCartItemsByCustomerId(id);
		for (CartItem cartItem : cartItems) {
			cartItem.getItem().setSeller(null);
			cartItem.getCustomer().getAccount().setPassword("");
		}
		return cartItems;
	}
	
	@PutMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public CartItem updateCartItem(@RequestBody CartItem updatedCartItem) {
		CartItem cartItem = cartItemService.updateCartItemById(updatedCartItem);
		cartItem.getItem().setSeller(null);
		cartItem.getCustomer().getAccount().setPassword("");
		return cartItem;
	}
	
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteCartItem(@RequestBody CartItem deleteCartItem) {
		cartItemService.deleteCartItem(deleteCartItem);
	}
}
