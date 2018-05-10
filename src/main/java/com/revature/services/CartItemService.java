package com.revature.services;

import java.util.List;
import com.revature.models.*;

public interface CartItemService {
	
	/**
	 * Add a new CartItem to the database
	 * @param newCartItem
	 * @return the added CartItem
	 */
	public CartItem addCartItem(CartItem newCartItem);
	
	/**
	 * Find all cart items in the database
	 * @return List of all cart items
	 */
	public List<CartItem> findAllCartItems();
	
	/**
	 * Find cart item by item id and customer id
	 * @param itemId
	 * @param customerId
	 * @return CartItem with matching item id and customer id
	 */
	public CartItem findCartItemByItemIdAndCustomerId(int itemId, int customerId);
	
	/**
	 * Find cart items by customer id
	 * @param customerId
	 * @return List of CartItems with matching customer id
	 */
	public List<CartItem> findCartItemsByCustomerId(int customerId);
	
	/**
	 * Update cart item by cart item id
	 * @param updatedCartItem
	 * @return The cart item after it has been updated in the database
	 */
	public CartItem updateCartItemById(CartItem updatedCartItem);
	
	/**
	 * Delete a cart item from the database
	 * @param deleteCartItem
	 */
	public void deleteCartItem(CartItem deleteCartItem);
	
	/**
	 * Creates a new order and transfers all of the cart items associated
	 * with the order's customer into order items
	 * @param newOrder
	 * @return The Order added to the database
	 */
	public Order checkout(Order newOrder);

}
