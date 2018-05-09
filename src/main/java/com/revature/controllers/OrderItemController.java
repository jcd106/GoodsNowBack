package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.OrderItem;
import com.revature.services.OrderItemService;

@RestController
@RequestMapping(value="/orderitems")
@CrossOrigin
public class OrderItemController {
	
	@Autowired
	OrderItemService orderItemService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public OrderItem addOrderItem(@RequestBody OrderItem newOrderItem) {
		OrderItem orderItem = orderItemService.addOrderItem(newOrderItem);
		if (orderItem != null) {
			orderItem.getItem().setSeller(null);
			orderItem.getOrder().getCustomer().getAccount().setPassword("");
		}
		return orderItem;
	}
	
	@GetMapping(value="/customerId={id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<OrderItem> getOrderItemsByCustomerId(@PathVariable("id") int id) {
		List<OrderItem> orderItems = orderItemService.findOrderItemsByCustomerId(id);
		for (OrderItem orderItem : orderItems) {
			orderItem.getItem().setSeller(null);
			orderItem.getOrder().getCustomer().getAccount().setPassword("");
		}
		return orderItems;
	}
	
	@GetMapping(value="/sellerId={id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<OrderItem> getOrderItemsBySellerId(@PathVariable("id") int id) {
		List<OrderItem> orderItems = orderItemService.findOrderItemsBySellerId(id);
		for (OrderItem orderItem : orderItems) {
			orderItem.getItem().setSeller(null);
			orderItem.getOrder().getCustomer().getAccount().setPassword("");
		}
		return orderItems;
	}
	
	@GetMapping(value="/orderId={id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<OrderItem> getOrderItemsByOrderId(@PathVariable("id") int id) {
		List<OrderItem> orderItems = orderItemService.findOrderItemsByOrderId(id);
		for (OrderItem orderItem : orderItems) {
			orderItem.getItem().setSeller(null);
			orderItem.getOrder().getCustomer().getAccount().setPassword("");
		}
		return orderItems;
	}
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public OrderItem updateOrderItem(@RequestBody OrderItem updatedOrderItem) {
		OrderItem orderItem = orderItemService.updateOrderItem(updatedOrderItem);
		orderItem.getItem().setSeller(null);
		orderItem.getOrder().getCustomer().getAccount().setPassword("");
		return orderItem;
	}

}
