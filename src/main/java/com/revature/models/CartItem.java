package com.revature.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model for CartItems in the database
 * @author Josh Dughi
 */
@Component
@Entity
@Table(name="CART_ITEM")
public class CartItem {
	
	@EmbeddedId
	private CartItemId cartItemId;
	
	@Column(name="QUANTITY")
	@NotNull
	private int quantity;

	/**
	 * Default constructor
	 */
	public CartItem() {
		super();
	}
	
	/**
	 * Constructor for CartItem that creates a new CartItemId
	 * @param item
	 * @param customer
	 * @param quantity
	 */
	public CartItem(Item item, Customer customer, int quantity) {
		super();
		CartItemId ciId = new CartItemId(item, customer);
		this.cartItemId = ciId;
		this.quantity = quantity;
	}

	/**
	 * Constructor for CartItem using an instance of a CartItemId
	 * @param cartItemId
	 * @param quantity
	 */
	public CartItem(CartItemId cartItemId, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
	}

	/**
	 * @return this.cartItemId
	 */
	public CartItemId getCartItemId() {
		return cartItemId;
	}

	/**
	 * Set this.cartItemId
	 * @param cartItemId
	 */
	public void setCartItemId(CartItemId cartItemId) {
		this.cartItemId = cartItemId;
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
	 * @return the Item associated with this.cartItemId
	 */
	@JsonIgnore
	public Item getItem() {
		return this.cartItemId.getItem();
	}
	
	/**
	 * Set the Item associated with this.cartItemId
	 * @param item
	 */
	public void setItem(Item item) {
		this.cartItemId.setItem(item);
	}
	
	/**
	 * @return the Customer associated with this.cartItemId
	 */
	@JsonIgnore
	public Customer getCustomer() {
		return this.cartItemId.getCustomer();
	}
	
	/**
	 * Set the Customer associated with this.cartItemId
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.cartItemId.setCustomer(customer);
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartItemId == null) ? 0 : cartItemId.hashCode());
		result = prime * result + quantity;
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
		CartItem other = (CartItem) obj;
		if (cartItemId == null) {
			if (other.cartItemId != null)
				return false;
		} else if (!cartItemId.equals(other.cartItemId))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

}
