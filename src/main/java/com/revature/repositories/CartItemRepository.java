package com.revature.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.*;

/**
 * Interface for getting CartItem information from the database
 * @author Josh Dughi
 */
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	
	/**
	 * Find cart item by item id and customer id
	 * @param itemId
	 * @param customerId
	 * @return CartItem with matching item id and customer id
	 */
	public CartItem findCartItemByCartItemIdItemItemIdAndCartItemIdCustomerCustomerId(int itemId, int customerId);
	
	/**
	 * Find cart items by customer id
	 * @param customerId
	 * @return List of CartItems with matching customer id
	 */
	public List<CartItem> findCartItemsByCartItemIdCustomerCustomerId(int customerId);
	
	/**
	 * Find cart items by seller id
	 * @param sellerId
	 * @return List of CartItems with matching seller id
	 */
	public List<CartItem> findCartItemsByCartItemIdItemSellerSellerId(int sellerId);

}
