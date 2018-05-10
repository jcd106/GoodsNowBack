package com.revature.models;

import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 * Model for Orders in the database
 * @author Josh Dughi
 */
@Component
@Entity
@Table(name="ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID")
	private int orderId;
	
	@Column(name="ADDRESS")
	@NotNull
	private String address;
	
	@Column(name="CITY")
	@NotNull
	private String city;
	
	@Column(name="STATE")
	@NotNull
	private String state;
	
	@Column(name="ZIPCODE")
	@NotNull
	private String zipcode;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	
	@Column(name="SUBMITTED")
	@NotNull
	private Timestamp submitted;

	/**
	 * Default constructor
	 */
	public Order() {
		super();
	}

	/**
	 * Constructor for setting all the fields
	 * @param orderId
	 * @param address
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param customer
	 * @param submitted
	 */
	public Order(int orderId, String address, String city, String state, String zipcode, Customer customer,
			Timestamp submitted) {
		super();
		this.orderId = orderId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.customer = customer;
		this.submitted = submitted;
	}

	/**
	 * @return this.orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Set this.orderId
	 * @param orderId
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	 * @return this.customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Set this.customer
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return this.submitted
	 */
	public Timestamp getSubmitted() {
		return submitted;
	}

	/**
	 * Set this.submitted
	 * @param submitted
	 */
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
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
		Order other = (Order) obj;
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
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderId != other.orderId)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

}
