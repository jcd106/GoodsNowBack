package com.revature.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.revature.models.Order;
import com.revature.services.OrderService;

/**
 * Controller for Order CRUD operations
 * @author Josh Dughi
 */
@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	/**
	 * Get all orders from the database
	 * @return List of all Orders
	 */
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAllOrders() {
		List<Order> orders = orderService.findAllOrders();
		for (Order order : orders) {
			order.getCustomer().setAccount(null);
		}
		return orders;
	}
	
	/**
	 * Get all orders with specified customer id in the database
	 * @param id
	 * @return List of all Orders with matching customer id
	 */
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAllOrdersByCustomerId(@PathVariable("id") int id) {
		List<Order> orders = orderService.findOrdersByCustomerId(id);
		for (Order order : orders) {
			order.getCustomer().setAccount(null);
		}
		return orders;
	}

}
