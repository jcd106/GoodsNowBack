package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	public List<Order> findOrdersByCustomerCustomerId(int customerId);

}
