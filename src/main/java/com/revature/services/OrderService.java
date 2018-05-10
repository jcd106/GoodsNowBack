package com.revature.services;

import java.util.List;
import com.revature.models.Order;

/**
 * Interface for Order CRUD operations
 * @author Josh Dughi
 */
public interface OrderService {
	
	/**
	 * Add a new Order to the database
	 * @param newOrder
	 * @return the added Order
	 */
	public Order addOrder(Order newOrder);
	
	/**
	 * Find all orders in the database
	 * @return List of all orders
	 */
	public List<Order> findAllOrders();
	
	/**
	 * Find order by order id
	 * @param orderId
	 * @return Order with matching order id
	 */
	public Order findOrderById(int orderId);
	
	/**
	 * Find order by customer id
	 * @param customerId
	 * @return Order with matching customer id
	 */
	public List<Order> findOrdersByCustomerId(int customerId);
	
	/**
	 * Update order by order id
	 * @param updatedOrder
	 * @return The order after it has been updated in the database
	 */
	public Order updateOrderById(Order updatedOrder);
	
	/**
	 * Delete an order from the database
	 * @param deleteOrder
	 */
	public void deleteOrder(Order deleteOrder);

}
