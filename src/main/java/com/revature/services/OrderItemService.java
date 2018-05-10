package com.revature.services;

import java.util.List;
import com.revature.models.OrderItem;

/**
 * Interface for OrderItem CRUD operations
 * @author Josh Dughi
 */
public interface OrderItemService {
	
	/**
	 * Add a new OrerItem to the database
	 * @param newOrderItem
	 * @return the added OrderItem
	 */
	public OrderItem addOrderItem(OrderItem newOrderItem);
	
	/**
	 * Find all order items in the database
	 * @param id
	 * @return List of all OrderItems
	 */
	public List<OrderItem> findOrderItemsByOrderId(int id);
	
	/**
	 * Find all order items by customer id
	 * @param id
	 * @return List of all OrderItems with matching customer id
	 */
	public List<OrderItem> findOrderItemsByCustomerId(int id);
	
	/**
	 * Find all order items by seller id
	 * @param id
	 * @return List of all OrderItems with matching seller id
	 */
	public List<OrderItem> findOrderItemsBySellerId(int id);
	
	/**
	 * Update order item in the database
	 * @param updatedOrderItem
	 * @return The order item after it has been updated in the database
	 */
	public OrderItem updateOrderItem(OrderItem updatedOrderItem);
	
	/**
	 * Delete an order item from the database
	 * @param deleteOrderItem
	 */
	public void deleteOrderItem(OrderItem deleteOrderItem);

}
