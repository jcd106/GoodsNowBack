package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	
	//public CartItem findCartItemByItemAndCustomer(int itemId, int customerId);
	//public List<CartItem> findCartItemsByCustomer(int customerId);
	//public List<CartItem> findCartItemsByItemSeller(int sellerId);

}
