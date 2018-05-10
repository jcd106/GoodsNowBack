package com.revature.services;

import java.util.List;
import com.revature.models.Account;

/**
 * Interface for Account CRUD operations
 * @author Zach Vaughn
 */
public interface AccountService {

	/**
	 * Add a new account to the database
	 * @param newAccount
	 * @return the account added that was added to the database
	 */
	public Account addAccount(Account newAccount);
	
	/**
	 * Find all accounts in the database
	 * @return List of all accounts
	 */
	public List<Account> findAllAccounts();
	
	/**
	 * Find account by account id
	 * @param id
	 * @return Account with matching account id
	 */
	public Account findAccountById(int id);
	
	/**
	 * Find account by username
	 * @param username
	 * @return Account with matching username
	 */
	public Account findAccountByUsername(String username);
	
	/**
	 * Update account by account id
	 * @param updatedAccount
	 * @return The account after it has been updated in the database
	 */
	public Account updateAccountById(Account updatedAccount);
	
	/**
	 * Logs in an account with matching username and password
	 * @param logAccount
	 * @return The account being logged in
	 */
	public Account loginAccount(Account logAccount);
	
}
