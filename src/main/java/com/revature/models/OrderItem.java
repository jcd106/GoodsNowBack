package com.revature.models;

import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model for OrderItems in the database
 * @author Josh Dughi
 *
 */
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

	/**
	 * Default constructor
	 */
	public OrderItem() {
		super();
	}
	
	/**
	 * Constructor for OrderItem that creates a new OrderItemId
	 * @param item
	 * @param order
	 * @param quantity
	 * @param resolved
	 */
	public OrderItem(Item item, Order order, int quantity, Timestamp resolved) {
		super();
		OrderItemId oiId = new OrderItemId(item, order);
		this.orderItemId = oiId;
		this.quantity = quantity;
		this.resolved = resolved;
	}

	/**
	 * Constructor for OrderItem using an instance of an OrderItemId
	 * @param orderItemId
	 * @param quantity
	 * @param resolved
	 */
	public OrderItem(OrderItemId orderItemId, int quantity, Timestamp resolved) {
		super();
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.resolved = resolved;
	}

	/**
	 * @return this.orderItemId
	 */
	public OrderItemId getOrderItemId() {
		return orderItemId;
	}

	/**
	 * Set this.orderItemId
	 * @param orderItemId
	 */
	public void setOrderItemId(OrderItemId orderItemId) {
		this.orderItemId = orderItemId;
	}

	/**
	 * @return this.quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set this.quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return this.resolved
	 */
	public Timestamp getResolved() {
		return resolved;
	}

	/**
	 * Set this.resolved
	 * @param resolved
	 */
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	
	/**
	 * @return the Item associated with this.orderItemId
	 */
	@JsonIgnore
	public Item getItem() {
		return this.orderItemId.getItem();
	}
	
	/**
	 * Set the Item associated with this.orderItemId
	 * @param item
	 */
	public void setItem(Item item) {
		if(this.orderItemId == null) {
			this.orderItemId = new OrderItemId();
		}
		this.orderItemId.setItem(item);
	}
	
	/**
	 * @return the Order associated with this.orderItemId
	 */
	@JsonIgnore
	public Order getOrder() {
		return this.orderItemId.getOrder();
	}
	
	/**
	 * Set the Order associated with this.orderItemId
	 * @param order
	 */
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
