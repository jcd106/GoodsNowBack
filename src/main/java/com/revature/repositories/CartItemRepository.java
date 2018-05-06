package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.*;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	
	public CartItem findCartItemByCartItemIdItemItemIdAndCartItemIdCustomerCustomerId(int itemId, int customerId);
	public List<CartItem> findCartItemsByCartItemIdCustomerCustomerId(int customerId);
	public List<CartItem> findCartItemsByCartItemIdItemSellerSellerId(int sellerId);

}
