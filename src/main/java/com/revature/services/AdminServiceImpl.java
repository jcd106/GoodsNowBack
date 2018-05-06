package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.*;
import com.revature.repositories.*;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	AccountRepository accountRepo;

	@Override
	public Admin addAdmin(Account newAccount, Admin newAdmin) {
		for (Account account : accountRepo.findAll()) {
			if (account.getUsername().equals(newAccount.getUsername())) {
				return null;
			}
		}
		for (Admin admin : findAllAdmins()) {
			if (admin.getEmail().equals(newAdmin.getEmail())) {
				return null;
			}
		}
		Account account = accountRepo.save(newAccount);
		newAdmin.setAccount(account);
		return adminRepo.save(newAdmin);
	}
	
	@Override
	public Admin addAdmin(Admin newAdmin) {
		for (Admin admin : findAllAdmins()) {
			if (admin.getEmail().equals(newAdmin.getEmail())) {
				return null;
			}
		}
		return adminRepo.save(newAdmin);
	}

	@Override
	public List<Admin> findAllAdmins() {
		return adminRepo.findAll();
	}

	@Override
	public Admin findAdminById(int id) {
		return adminRepo.getOne(id);
	}

	@Override
	public Admin findAdminByAccount(Account account) {
		return adminRepo.findAdminByAccount(account);
	}

	@Override
	public Admin findAdminByEmail(String email) {
		return adminRepo.findAdminByEmail(email);
	}

	@Override
	public Admin updateAdminById(Admin updatedAdmin) {
		return adminRepo.save(updatedAdmin);
	}

}
