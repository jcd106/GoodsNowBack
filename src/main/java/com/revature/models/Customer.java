package com.revature.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 * Model for Customers in the database
 * @author Josh Dughi
 */
@Component
@Entity
@Table(name="CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private int customerId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;

	@Column(name = "EMAIL")
	@NotNull
	private String email;

	@Column(name = "FIRST_NAME")
	@NotNull
	private String firstName;

	@Column(name = "LAST_NAME")
	@NotNull
	private String lastName;

	/**
	 * Default constructor
	 */
	public Customer() {
		super();
	}

	/**
	 * Constructor setting all values minus the customerId
	 * @param account
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public Customer(Account account, String email, String firstName, String lastName) {
		super();
		this.account = account;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Constructor setting all fields
	 * @param customerId
	 * @param account
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public Customer(int customerId, Account account, String email, String firstName, String lastName) {
		super();
		this.customerId = customerId;
		this.account = account;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return this.customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Set this.customerId
	 * @param customerId
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return this.account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Set this.account
	 * @param account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return this.email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set this.email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return this.firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set this.firstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return this.lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set this.lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", account=" + account + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Customer other = (Customer) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (customerId != other.customerId)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
