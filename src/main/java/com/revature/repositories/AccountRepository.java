package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	public Account findAccountByUsername(String username);
	public Account findAccountByUsernameAndPassword(String username, String password);	

}