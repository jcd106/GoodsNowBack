package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Account;
import com.revature.repositories.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepo;
	
	@Override
	public Account addAccount(Account newAccount) {
		for (Account account : findAllAccounts()) {
			if (account.getUsername().equals(newAccount.getUsername())) {
				return null;
			}
		}
		return accountRepo.save(newAccount);
	}

	@Override
	public List<Account> findAllAccounts() {
		return accountRepo.findAll();
	}

	@Override
	public Account findAccountById(int id) {
		return accountRepo.getOne(id);
	}

	@Override
	public Account findAccountByUsername(String username) {
		return accountRepo.findAccountByUsername(username);
	}

	@Override
	public Account updateAccountById(Account updatedAccount) {
		return accountRepo.save(updatedAccount);
	}

	@Override
	public Account loginAccount(Account logAccount) {
		String username = logAccount.getUsername().toLowerCase();
		String password = logAccount.getPassword();
		return accountRepo.findAccountByUsernameAndPassword(username, password);
	}

}
