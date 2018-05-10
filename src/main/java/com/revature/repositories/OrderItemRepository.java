package com.revature.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.OrderItem;

/**
 * Interface for getting OrderItem information from the database
 * @author Josh Dughi
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	/**
	 * Find order items by order id
	 * @param orderId
	 * @return List of OrderItems with matching order id
	 */
	public List<OrderItem> findOrderItemsByOrderItemIdOrderOrderId(int orderId);
	
	/**
	 * Find order items by customer id
	 * @param customerId
	 * @return List of OrderItems with matching customer id
	 */
	public List<OrderItem> findOrderItemsByOrderItemIdOrderCustomerCustomerId(int customerId);
	
	/**
	 * Find order items by seller id
	 * @param sellerId
	 * @return List of OrderItems with matching seller id
	 */
	public List<OrderItem> findOrderItemsByOrderItemIdItemSellerSellerId(int sellerId);

}
