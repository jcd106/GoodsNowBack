package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Order;
import com.revature.repositories.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Override
	public Order addOrder(Order newOrder) {
		return orderRepo.save(newOrder);
	}

	@Override
	public List<Order> findAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order findOrderById(int orderId) {
		return orderRepo.getOne(orderId);
	}

	@Override
	public List<Order> findOrdersByCustomerId(int customerId) {
		return orderRepo.findOrdersByCustomerCustomerId(customerId);
	}

	@Override
	public Order updateOrderById(Order updatedOrder) {
		return orderRepo.save(updatedOrder);
	}

	@Override
	public void deleteOrder(Order deleteOrder) {
		orderRepo.deleteById(deleteOrder.getOrderId());
		
	}

}
