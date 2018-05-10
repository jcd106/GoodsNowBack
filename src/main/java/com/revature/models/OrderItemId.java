package com.revature.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Model for EmbeddedId in OrderItems
 * @author Josh Dughi
 *
 */
@Embeddable
public class OrderItemId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ITEM_ID")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private Order order;

	/**
	 * Default constructor
	 */
	public OrderItemId() {
		super();
	}

	/**
	 * Constructor setting the fields
	 * @param item
	 * @param order
	 */
	public OrderItemId(Item item, Order order) {
		super();
		this.item = item;
		this.order = order;
	}

	/**
	 * @return this.item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Set this.item
	 * @param item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return this.order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Set this.order
	 * @param order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItemId [item=" + item + ", order=" + order + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		OrderItemId other = (OrderItemId) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}

}
