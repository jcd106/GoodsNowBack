package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.*;
import com.revature.services.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	SellerService sellerService;
	
	@Autowired
	AdminService adminService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object loginAccount(@RequestBody Account logAccount) {
		Account account = accountService.loginAccount(logAccount);
		if (account == null) {
			return null;
		}
		switch (account.getRoleId()) {
		case 1:
			Customer customer = customerService.findCustomerByAccount(account);
			customer.getAccount().setPassword("");
			return customer;
		case 2:
			Seller seller = sellerService.findSellerByAccount(account);
			seller.getAccount().setPassword("");
			return seller;
		case 3:
			Admin admin = adminService.findAdminByAccount(account);
			admin.getAccount().setPassword("");
			return admin;
		}
		return null;
	}

}
