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
	 * Find the Admin
	 * @param email
	 * @return
	 */
	public Admin findAdminByEmail(String email);
	public Admin findAdminByAccount(Account account);

}
