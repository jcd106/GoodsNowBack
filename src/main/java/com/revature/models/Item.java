package com.revature.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 * Model for Items in the database
 * @author Josh Dughi
 *
 */
@Component
@Entity
@Table(name="ITEM")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ITEM_ID")
	private int itemId;
	
	@Column(name="ITEM_NAME")
	@NotNull
	private String itemName;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SELLER_ID")
	@NotNull
	private Seller seller;
	
	@Column(name="PRICE")
	@NotNull
	private double price;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="CATEGORY")
	private String category;

	/**
	 * Default constructor
	 */
	public Item() {
		super();
	}

	/**
	 * Constructor setting all the fields
	 * @param itemId
	 * @param itemName
	 * @param description
	 * @param seller
	 * @param price
	 * @param image
	 * @param category
	 */
	public Item(int itemId, String itemName, String description, Seller seller, double price, String image,
			String category) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.seller = seller;
		this.price = price;
		this.image = image;
		this.category = category;
	}

	/**
	 * @return this.itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * Set this.itemId
	 * @param itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return this.itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Set this.itemName
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return this.description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set this.description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return this.seller
	 */
	public Seller getSeller() {
		return seller;
	}

	/**
	 * Set this.seller
	 * @param seller
	 */
	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	/**
	 * @return this.price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set this.price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return this.image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Set this.image
	 * @param image
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return this.category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Set this.category
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", description=" + description + ", seller="
				+ seller + ", price=" + price + ", image=" + image + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
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
		Item other = (Item) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		return true;
	}

}
