package com.revature.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.Order;

/**
 * Interface for getting Order information from the database
 * @author Josh Dughi
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	/**
	 * Find orders by customer id
	 * @param customerId
	 * @return List of Orders with matching customer id
	 */
	public List<Order> findOrdersByCustomerCustomerId(int customerId);

}
