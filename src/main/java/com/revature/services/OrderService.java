package com.revature.services;

import java.util.List;

import com.revature.models.Order;

public interface OrderService {
	
	public Order addOrder(Order newOrder);
	public List<Order> findAllOrders();
	public Order findOrderById(int orderId);
	public List<Order> findOrdersByCustomerId(int customerId);
	public Order updateOrderById(Order updatedOrder);
	public void deleteOrder(Order deleteOrder);

}
