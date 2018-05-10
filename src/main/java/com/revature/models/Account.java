package com.revature.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

/**
 * Model for Accounts in the database
 * @author Josh Dughi
 */
@Component
@Entity
@Table(name="ACCOUNT")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACCOUNT_ID")
	private int accountId;
	
	@Column(name="USERNAME")
	@NotNull
	@Size(min=4, max=16)
	private String username;
	
	@Column(name="PASSWORD")
	@NotNull
	@Size(min=8, max=25)
	private String password;
	
	// 1: Customer, 2: Seller, 3: Admin
	@Column(name="ROLEID")
	@NotNull
	private int roleId;
	
	/**
	 * Default constructor
	 */
	public Account() {
		super();
	}

	/**
	 * Constructor to set all values in a new Account instance
	 * @param accountId
	 * @param username
	 * @param password
	 * @param roleId
	 */
	public Account(int accountId, String username, String password, int roleId) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}
	
	/**
	 * @return this.accountId
	 */
	public int getAccountId() {
		return accountId;
	}
	
	/**
	 * Set this.accountId
	 * @param accountId
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	/**
	 * @return this.username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Set this.username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return this.password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Set this.password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return this.roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	
	/**
	 * Set this.roleId
	 * @param roleId
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", username=" + username + ", roleId=" + roleId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + roleId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roleId != other.roleId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
