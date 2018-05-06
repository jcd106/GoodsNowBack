package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.*;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
	
	public Seller findSellerByEmail(String email);
	public Seller findSellerByAccount(Account account);

}
