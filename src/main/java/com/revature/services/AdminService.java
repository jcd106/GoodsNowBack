package com.revature.services;

import java.util.List;
import com.revature.models.*;

/**
 * Interface for Admin CRUD operations
 * @author Zach Vaughn
 */
public interface AdminService {
	
	/**
	 * Add a new Account and Admin to the database
	 * @param newAccount
	 * @param newAdmin
	 * @return the added Admin
	 */
	public Admin addAdmin(Account newAccount, Admin newAdmin);
	
	/**
	 * Add a new Admin to the database
	 * @param newAdmin
	 * @return the added Admin
	 */
	public Admin addAdmin(Admin newAdmin);
	
	/**
	 * Find all admins in the database
	 * @return List of all admins
	 */
	public List<Admin> findAllAdmins();
	
	/**
	 * Find admin by admin id
	 * @param id
	 * @return Admin with matching admin id
	 */
	public Admin findAdminById(int id);
	
	/**
	 * Find admin by account
	 * @param account
	 * @return Admin with matching account
	 */
	public Admin findAdminByAccount(Account account);
	
	/**
	 * Find admin by email
	 * @param email
	 * @return Admin with matching email
	 */
	public Admin findAdminByEmail(String email);
	
	/**
	 * Update admin by admin id
	 * @param updatedAdmin
	 * @return The admin after it has been updated in the database
	 */
	public Admin updateAdminById(Admin updatedAdmin);

}
