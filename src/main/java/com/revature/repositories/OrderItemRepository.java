package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	public List<OrderItem> findOrderItemsByOrderItemIdOrderOrderId(int orderId);
	public List<OrderItem> findOrderItemsByOrderItemIdOrderCustomerCustomerId(int customerId);
	public List<OrderItem> findOrderItemsByOrderItemIdItemSellerSellerId(int sellerId);

}
