package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Admin;
import com.revature.services.AdminService;

@RestController
@RequestMapping("/admins")
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
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
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Admin> findAllAdmins() {
		List<Admin> admins = adminService.findAllAdmins();
		for (Admin admin : admins) {
			admin.getAccount().setPassword("");
		}
		return admins;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Admin findAdminById(@PathVariable("id") int id) {
		Admin admin = adminService.findAdminById(id);
		admin.getAccount().setPassword("");
		return admin;
	}
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Admin updateAdmin(@RequestBody Admin updatedAdmin) {
		Admin admin = adminService.updateAdminById(updatedAdmin);
		admin.getAccount().setPassword("");
		return admin;
	}

}
