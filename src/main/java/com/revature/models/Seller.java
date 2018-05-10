package com.revature.models;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model for Sellers in the database
 * @author Josh Dughi
 */
@Component
@Entity
@Table(name="SELLER")
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SELLER_ID")
	private int sellerId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;

	@Column(name = "EMAIL")
	@NotNull
	private String email;

	@Column(name = "NAME")
	@NotNull
	private String name;

	@Column(name = "ADDRESS")
	@NotNull
	private String address;

	@Column(name = "CITY")
	@NotNull
	private String city;

	@Column(name = "STATE")
	@NotNull
	private String state;

	@Column(name = "ZIPCODE")
	@NotNull
	private String zipcode;
	
	@Column(name = "MONEY_OWED")
	private double money;

	@OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Item> items;

	/**
	 * Default constructor
	 */
	public Seller() {
		super();
	}

	/**
	 * Constructor setting all fields
	 * @param sellerId
	 * @param account
	 * @param email
	 * @param name
	 * @param address
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param money
	 */
	public Seller(int sellerId, Account account, String email, String name, String address, String city, String state,
			String zipcode, double money) {
		super();
		this.sellerId = sellerId;
		this.account = account;
		this.email = email;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.money = money;
	}

	/**
	 * @return this.sellerId
	 */
	public int getSellerId() {
		return sellerId;
	}

	/**
	 * Set this.sellerId
	 * @param sellerId
	 */
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
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
	 * @return this.name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set this.name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return this.address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set this.address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return this.city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set this.city
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return this.state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set this.state
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return this.zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * Set this.zipcode
	 * @param zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the Items associated with this Seller
	 */
	@JsonIgnore
	public List<Item> getItems() {
		return items;
	}

	/**
	 * Set this.items
	 * @param items
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * @return the money owed to this Seller
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * Set the money owed to this Seller
	 * @param money
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", account=" + account + ", email=" + email + ", name=" + name
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", money="
				+ money + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sellerId;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		Seller other = (Seller) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sellerId != other.sellerId)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

}
