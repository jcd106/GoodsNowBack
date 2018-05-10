package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.Account;

/**
 * Interface for getting Account information from the database
 * @author Zach Vaughn
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	/**
	 * Find the account by username
	 * @param username
	 * @return Account with matching username
	 */
	public Account findAccountByUsername(String username);
	
	/**
	 * Find the account by username and password
	 * @param username
	 * @param password
	 * @return Account with matching username and password
	 */
	public Account findAccountByUsernameAndPassword(String username, String password);	

}
