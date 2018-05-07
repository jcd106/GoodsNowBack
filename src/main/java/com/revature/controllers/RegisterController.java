package com.revature.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.models.*;
import com.revature.services.*;

@RestController
@RequestMapping("/register")
@CrossOrigin
public class RegisterController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	SellerService sellerService;
	
	@Autowired
	AdminService adminService;
	
	@PostMapping(value="/customer", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Customer addNewCustomer(@Valid @RequestBody ObjectNode on) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String aStr = mapper.writeValueAsString(on.get("Account"));
			//System.out.println(aStr);
			Account newAccount = mapper.readValue(aStr, Account.class);
			newAccount.setUsername(newAccount.getUsername().toLowerCase());
			newAccount.setRoleId(1);
			//Account account = accountService.addAccount(newAccount);
			String cStr = mapper.writeValueAsString(on.get("Customer"));
			//System.out.println(cStr);
			Customer newCustomer = mapper.readValue(cStr, Customer.class);
			newCustomer.setEmail(newCustomer.getEmail().toLowerCase());
			//newCustomer.setAccount(account);
			Customer customer = customerService.addCustomer(newAccount, newCustomer);
			if (customer != null) {
				customer.getAccount().setPassword("");
			}
			return customer;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping(value="/seller", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Seller addNewSeller(@Valid @RequestBody ObjectNode on) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String aStr = mapper.writeValueAsString(on.get("Account"));
			//System.out.println(aStr);
			Account newAccount = mapper.readValue(aStr, Account.class);
			newAccount.setUsername(newAccount.getUsername().toLowerCase());
			newAccount.setRoleId(2);
			//Account account = accountService.addAccount(newAccount);
			String sStr = mapper.writeValueAsString(on.get("Seller"));
			//System.out.println(sStr);
			Seller newSeller = mapper.readValue(sStr, Seller.class);
			newSeller.setEmail(newSeller.getEmail().toLowerCase());
			//newSeller.setAccount(account);
			newSeller.setMoney(0);
			Seller seller = sellerService.addSeller(newAccount, newSeller);
			if (seller != null) {
				seller.getAccount().setPassword("");
			}
			return seller;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping(value="/admin", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Admin addNewAdmin(@Valid @RequestBody ObjectNode on) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String aStr = mapper.writeValueAsString(on.get("Account"));
			//System.out.println(aStr);
			Account newAccount = mapper.readValue(aStr, Account.class);
			newAccount.setUsername(newAccount.getUsername().toLowerCase());
			newAccount.setRoleId(3);
			//Account account = accountService.addAccount(newAccount);
			String adStr = mapper.writeValueAsString(on.get("Admin"));
			//System.out.println(adStr);
			Admin newAdmin = mapper.readValue(adStr, Admin.class);
			newAdmin.setEmail(newAdmin.getEmail().toLowerCase());
			//newAdmin.setAccount(account);
			Admin admin = adminService.addAdmin(newAccount, newAdmin);
			if (admin != null) {
				admin.getAccount().setPassword("");
			}
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
