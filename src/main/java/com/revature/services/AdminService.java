package com.revature.services;

import java.util.List;

import com.revature.models.*;

public interface AdminService {
	
	public Admin addAdmin(Account newAccount, Admin newAdmin);
	public Admin addAdmin(Admin newAdmin);
	public List<Admin> findAllAdmins();
	public Admin findAdminById(int id);
	public Admin findAdminByAccount(Account account);
	public Admin findAdminByEmail(String email);
	public Admin updateAdminById(Admin updatedAdmin);

}
