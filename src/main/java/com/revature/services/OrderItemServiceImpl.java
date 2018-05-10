package com.revature.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.OrderItem;
import com.revature.repositories.OrderItemRepository;

/**
 * Implementation for OrderItemService
 * @author Josh Dughi
 */
@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Override
	public OrderItem addOrderItem(OrderItem newOrderItem) {
		return orderItemRepo.save(newOrderItem);
	}
	
	@Override
	public List<OrderItem> findOrderItemsByOrderId(int id) {
		return orderItemRepo.findOrderItemsByOrderItemIdOrderOrderId(id);
	}

	@Override
	public List<OrderItem> findOrderItemsByCustomerId(int id) {
		return orderItemRepo.findOrderItemsByOrderItemIdOrderCustomerCustomerId(id);
	}

	@Override
	public List<OrderItem> findOrderItemsBySellerId(int id) {
		return orderItemRepo.findOrderItemsByOrderItemIdItemSellerSellerId(id);
	}

	@Override
	public OrderItem updateOrderItem(OrderItem updatedOrderItem) {
		return orderItemRepo.save(updatedOrderItem);
	}

	@Override
	public void deleteOrderItem(OrderItem deleteOrderItem) {
		orderItemRepo.delete(deleteOrderItem);		
	}
	
}
