package com.revature.services;

import java.util.List;

import com.revature.models.CartItem;

public interface CartItemService {
	
	public CartItem addCartItem(CartItem newCartItem);
	public List<CartItem> findAllCartItems();
	public CartItem findCartItemByItemIdAndCustomerId(int itemId, int customerId);
	public List<CartItem> findCartItemsByCustomerId(int customerId);
	public CartItem updateCartItemById(CartItem updatedCartItem);
	public void deleteCartItem(CartItem deleteCartItem);

}
