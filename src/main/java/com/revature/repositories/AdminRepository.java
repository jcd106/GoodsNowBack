package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.*;

/**
 * Interface for getting Admin infromation from the database
 * @author Zach Vaughn
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	/**
	 * Find the admin by email
	 * @param email
	 * @return Admin with matching email
	 */
	public Admin findAdminByEmail(String email);
	
	/**
	 * Find admin by account
	 * @param account
	 * @return Admin with matching Account
	 */
	public Admin findAdminByAccount(Account account);

}
