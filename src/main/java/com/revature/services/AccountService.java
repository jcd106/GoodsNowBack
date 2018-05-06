package com.revature.services;

import java.util.List;

import com.revature.models.Account;

public interface AccountService {

	public Account addAccount(Account newAccount);
	public List<Account> findAllAccounts();
	public Account findAccountById(int id);
	public Account findAccountByUsername(String username);
	public Account updateAccountById(Account updatedAccount);
	public Account loginAccount(Account logAccount);
	
}
