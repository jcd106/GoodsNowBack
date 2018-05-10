package com.revature.controllers;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.revature.models.*;
import com.revature.services.*;

/**
 * Controller for OrderItem CRUD operations
 * @author Josh Dughi
 */
@RestController
@RequestMapping(value="/orderitems")
@CrossOrigin
public class OrderItemController {
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ItemService itemService;
	
	/**
	 * Add a new order item to the database
	 * @param newOrderItem
	 * @return The order item after it has been added to the database
	 */
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public OrderItem addOrderItem(@RequestBody OrderItem newOrderItem) {
		OrderItem orderItem = orderItemService.addOrderItem(newOrderItem);
		if (orderItem != null) {
			orderItem.getItem().setSeller(null);
			orderItem.getOrder().getCustomer().getAccount().setPassword("");
		}
		return orderItem;
	}
	
	/**
	 * Get all order items in the database with specified customer id
	 * @param id
	 * @return List of all OrderItems with matching customer id
	 */
	@GetMapping(value="/customerId={id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<OrderItem> getOrderItemsByCustomerId(@PathVariable("id") int id) {
		List<OrderItem> orderItems = orderItemService.findOrderItemsByCustomerId(id);
		for (OrderItem orderItem : orderItems) {
			orderItem.getItem().setSeller(null);
			orderItem.getOrder().getCustomer().getAccount().setPassword("");
		}
		return orderItems;
	}
	
	/**
	 * Get all order items in the database with specified seller id
	 * @param id
	 * @return List of all OrderItems with matching seller id
	 */
	@GetMapping(value="/sellerId={id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<OrderItem> getOrderItemsBySellerId(@PathVariable("id") int id) {
		List<OrderItem> orderItems = orderItemService.findOrderItemsBySellerId(id);
		for (OrderItem orderItem : orderItems) {
			orderItem.getItem().setSeller(null);
			orderItem.getOrder().getCustomer().getAccount().setPassword("");
		}
		return orderItems;
	}
	
	/**
	 * Get all order items in the database with specified order id
	 * @param id
	 * @return List of all OrderItems with matching order id
	 */
	@GetMapping(value="/orderId={id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<OrderItem> getOrderItemsByOrderId(@PathVariable("id") int id) {
		List<OrderItem> orderItems = orderItemService.findOrderItemsByOrderId(id);
		for (OrderItem orderItem : orderItems) {
			orderItem.getItem().setSeller(null);
			orderItem.getOrder().getCustomer().getAccount().setPassword("");
		}
		return orderItems;
	}
	
	/**
	 * Update an order item in the database
	 * @param updatedOrderItem
	 * @return The OrderItem after it has been updated in the database
	 */
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public OrderItem updateOrderItem(@RequestBody OrderItem updatedOrderItem) {
		Order order = orderService.findOrderById(updatedOrderItem.getOrder().getOrderId());
		updatedOrderItem.setOrder(order);
		Item item = itemService.findItemById(updatedOrderItem.getItem().getItemId());
		updatedOrderItem.setItem(item);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		updatedOrderItem.setResolved(timestamp);
		OrderItem orderItem = orderItemService.updateOrderItem(updatedOrderItem);
		orderItem.getItem().setSeller(null);
		orderItem.getOrder().getCustomer().getAccount().setPassword("");
		return orderItem;
	}

}
