package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Account;
import com.revature.services.AccountService;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Account addUser(@Valid @RequestBody Account newAccount) {
		Account account = accountService.addAccount(newAccount);
		if (account != null) {
			account.setPassword("");
		}
		return account;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Account> findAllAccounts() {
		List<Account> accounts = accountService.findAllAccounts();
		for (Account account : accounts) {
			account.setPassword("");
		}
		return accounts;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Account findAccountById(@PathVariable("id") int id) {
		Account account = accountService.findAccountById(id);
		account.setPassword("");
		return account;
	}
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Account updateAccount(@RequestBody Account updatedAccount) {
		Account account = accountService.updateAccountById(updatedAccount);
		account.setPassword("");
		return account;
	}

}
