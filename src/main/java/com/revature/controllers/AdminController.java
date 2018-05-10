package com.revature.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.revature.models.*;
import com.revature.services.*;

/**
 * Controller for Admin CRUD operations
 * @author Zach Vaughn
 *
 */
@RestController
@RequestMapping("/admins")
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AccountService accountService;
	
	/**
	 * Add a new admin to the database
	 * @param newAdmin
	 * @return The admin after it has been added to the database
	 */
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Admin addAdmin(@Valid @RequestBody Admin newAdmin) {
		Admin admin = adminService.addAdmin(newAdmin);
		if (admin != null) {
			if (admin.getAccount() != null) {
				admin.getAccount().setPassword("");
			}
		}
		return admin;
	}
	
	/**
	 * Get all admins in the database
	 * @return List of all Admins
	 */
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Admin> findAllAdmins() {
		List<Admin> admins = adminService.findAllAdmins();
		for (Admin admin : admins) {
			admin.getAccount().setPassword("");
		}
		return admins;
	}
	
	/**
	 * Get the Admin with the specified admin id from the database
	 * @param id
	 * @return The Admin with matching admin id
	 */
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Admin findAdminById(@PathVariable("id") int id) {
		Admin admin = adminService.findAdminById(id);
		admin.getAccount().setPassword("");
		return admin;
	}
	
	/**
	 * Update an admin in the database
	 * @param updatedAdmin
	 * @return The Admin after it has been updated in the database
	 */
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Admin updateAdmin(@RequestBody Admin updatedAdmin) {
		Account account = accountService.findAccountById(updatedAdmin.getAccount().getAccountId());
		updatedAdmin.setAccount(account);
		Admin admin = adminService.updateAdminById(updatedAdmin);
		admin.getAccount().setPassword("");
		return admin;
	}

}
