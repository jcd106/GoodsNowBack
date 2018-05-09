package com.revature.services;

import java.util.List;

import com.revature.models.OrderItem;

public interface OrderItemService {
	
	public OrderItem addOrderItem(OrderItem newOrderItem);
	public List<OrderItem> findOrderItemsByOrderId(int id);
	public List<OrderItem> findOrderItemsByCustomerId(int id);
	public List<OrderItem> findOrderItemsBySellerId(int id);
	public OrderItem updateOrderItem(OrderItem updatedOrderItem);
	public void deleteOrderItem(OrderItem deleteOrderItem);

}
