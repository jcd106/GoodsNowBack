package com.revature.models;

import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name="ORDER_ITEM")
public class OrderItem {
	
	@EmbeddedId
	private OrderItemId orderItemId;
	
	@Column(name="QUANTITY")
	@NotNull
	private int quantity;
	
	@Column(name="RESOLVED")
	private Timestamp resolved;

	public OrderItem() {
		super();
	}
	
	public OrderItem(Item item, Order order, int quantity, Timestamp resolved) {
		super();
		OrderItemId oiId = new OrderItemId(item, order);
		this.orderItemId = oiId;
		this.quantity = quantity;
		this.resolved = resolved;
	}

	public OrderItem(OrderItemId orderItemId, int quantity, Timestamp resolved) {
		super();
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.resolved = resolved;
	}

	public OrderItemId getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(OrderItemId orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	
	@JsonIgnore
	public Item getItem() {
		return this.orderItemId.getItem();
	}
	
	public void setItem(Item item) {
		if(this.orderItemId == null) {
			this.orderItemId = new OrderItemId();
		}
		this.orderItemId.setItem(item);
	}
	
	@JsonIgnore
	public Order getOrder() {
		return this.orderItemId.getOrder();
	}
	
	public void setOrder(Order order) {
		if(this.orderItemId == null) {
			this.orderItemId = new OrderItemId();
		}
		this.orderItemId.setOrder(order);
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", quantity=" + quantity + ", resolved=" + resolved + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderItemId == null) ? 0 : orderItemId.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (orderItemId == null) {
			if (other.orderItemId != null)
				return false;
		} else if (!orderItemId.equals(other.orderItemId))
			return false;
		if (quantity != other.quantity)
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		return true;
	}

}
