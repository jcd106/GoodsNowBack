package com.revature.repositories;

import org.springframework.stereotype.Repository;
import com.revature.models.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	public List<Item> findItemsByCategory(String category);
	public List<Item> findItemsBySellerSellerId(int sellerId);
	public List<Item> findItemsBySellerCity(String city);
	public List<Item> findItemsBySellerZipcode(String zipcode);

}
