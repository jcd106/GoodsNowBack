package com.revature.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.revature.models.Account;
import com.revature.services.AccountService;

/**
 * Controller for Account CRUD operations
 * @author Zach Vaughn
 */
@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	/**
	 * Add a new account to the database
	 * @param newAccount
	 * @return The account after it has been added to the database
	 */
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Account addUser(@Valid @RequestBody Account newAccount) {
		Account account = accountService.addAccount(newAccount);
		if (account != null) {
			account.setPassword("");
		}
		return account;
	}
	
	/**
	 * Get all accounts in the database
	 * @return List of all Accounts
	 */
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Account> findAllAccounts() {
		List<Account> accounts = accountService.findAllAccounts();
		for (Account account : accounts) {
			account.setPassword("");
		}
		return accounts;
	}
	
	/**
	 * Get the Account with the specified account id from the database
	 * @param id
	 * @return The Account with matching account id
	 */
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Account findAccountById(@PathVariable("id") int id) {
		Account account = accountService.findAccountById(id);
		account.setPassword("");
		return account;
	}
	
	/**
	 * Update an account in the database
	 * @param updatedAccount
	 * @return The Account after it has been updated in the database
	 */
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Account updateAccount(@RequestBody Account updatedAccount) {
		Account account = accountService.updateAccountById(updatedAccount);
		account.setPassword("");
		return account;
	}

}
