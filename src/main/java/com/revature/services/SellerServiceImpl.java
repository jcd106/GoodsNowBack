package com.revature.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.*;
import com.revature.repositories.*;

/**
 * Implementation for SellerService
 * @author Zach Vaughn
 */
@Service
@Transactional
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerRepository sellerRepo;
	
	@Autowired
	AccountRepository accountRepo;
	
	@Override
	public Seller addSeller(Account newAccount, Seller newSeller) {
		for (Account account : accountRepo.findAll()) {
			if (account.getUsername().equals(newAccount.getUsername())) {
				return null;
			}
		}
		for (Seller seller : findAllSellers()) {
			if (seller.getEmail().equals(newSeller.getEmail())) {
				return null;
			}
		}
		Account account = accountRepo.save(newAccount);
		newSeller.setAccount(account);
		return sellerRepo.save(newSeller);
	}
	
	@Override
	public Seller addSeller(Seller newSeller) {
		for (Seller seller : findAllSellers()) {
			if (seller.getEmail().equals(newSeller.getEmail())) {
				return null;
			}
		}
		return sellerRepo.save(newSeller);
	}

	@Override
	public List<Seller> findAllSellers() {
		return sellerRepo.findAll();
	}

	@Override
	public Seller findSellerById(int sellerId) {
		return sellerRepo.getOne(sellerId);
	}
	
	@Override
	public Seller findSellerByAccount(Account account) {
		return sellerRepo.findSellerByAccount(account);
	}

	@Override
	public Seller findSellerByEmail(String email) {
		return sellerRepo.findSellerByEmail(email);
	}

	@Override
	public Seller updateSellerById(Seller updatedSeller) {
		return sellerRepo.save(updatedSeller);
	}

}
