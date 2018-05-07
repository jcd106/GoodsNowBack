package com.revature.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name="CART_ITEM")
public class CartItem {
	
	@EmbeddedId
	private CartItemId cartItemId;
	
	@Column(name="QUANTITY")
	@NotNull
	private int quantity;

	public CartItem() {
		super();
	}
	
	public CartItem(Item item, Customer customer, int quantity) {
		super();
		CartItemId ciId = new CartItemId(item, customer);
		this.cartItemId = ciId;
		this.quantity = quantity;
	}

	public CartItem(CartItemId cartItemId, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
	}

	public CartItemId getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(CartItemId cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@JsonIgnore
	public Item getItem() {
		return this.cartItemId.getItem();
	}
	
	public void setItem(Item item) {
		this.cartItemId.setItem(item);
	}
	
	@JsonIgnore
	public Customer getCustomer() {
		return this.cartItemId.getCustomer();
	}
	
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
