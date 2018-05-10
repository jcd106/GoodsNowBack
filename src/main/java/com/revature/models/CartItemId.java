package com.revature.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Model for the EmbeddedId in CartItems
 * @author Josh Dughi
 */
@Embeddable
public class CartItemId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ITEM_ID")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

	/**
	 * Default constructor
	 */
	public CartItemId() {
		super();
	}

	/**
	 * Constructor setting the fields
	 * @param item
	 * @param customer
	 */
	public CartItemId(Item item, Customer customer) {
		super();
		this.item = item;
		this.customer = customer;
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
	 * @return this.customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Set this.customer
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CartItemId [item=" + item + ", customer=" + customer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		CartItemId other = (CartItemId) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

}
