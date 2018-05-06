package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.*;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	public Admin findAdminByEmail(String email);
	public Admin findAdminByAccount(Account account);

}
