package com.revature.services;

import java.util.List;
import com.revature.models.*;

public interface SellerService {
	
	public Seller addSeller(Account newAccount, Seller newSeller);
	public Seller addSeller(Seller newSeller);
	public List<Seller> findAllSellers();
	public Seller findSellerById(int sellerId);
	public Seller findSellerByAccount(Account account);
	public Seller findSellerByEmail(String email);
	public Seller updateSellerById(Seller updatedSeller);

}
