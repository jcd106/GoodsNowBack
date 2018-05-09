package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Order;
import com.revature.services.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAllOrders() {
		List<Order> orders = orderService.findAllOrders();
		for (Order order : orders) {
			order.getCustomer().setAccount(null);
		}
		return orders;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAllOrdersByCustomerId(@PathVariable("id") int id) {
		List<Order> orders = orderService.findOrdersByCustomerId(id);
		for (Order order : orders) {
			order.getCustomer().setAccount(null);
		}
		return orders;
	}

}
