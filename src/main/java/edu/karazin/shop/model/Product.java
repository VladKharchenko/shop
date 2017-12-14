package edu.karazin.shop.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=2, max=30)
	private String title;
	@Size(min=10, max=100)
	private String description;
	private byte[] image;
	private String imageMimeType;
	@Min(1)
	private long cost;
	@Min(1)
	private int balance;

	public Product() {
	}

	public Product(Long id, String title, String description) {
		this(id, title, description, null, null, 0L, 0);
	}

	public Product(Long id, String title, String description, byte[] image, String imageMimeType, long cost,
			int balance) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.imageMimeType = imageMimeType;
		this.cost = cost;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageMimeType() {
		return imageMimeType;
	}

	public void setImageMimeType(String imageMimeType) {
		this.imageMimeType = imageMimeType;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", image="
				+ Arrays.toString(image) + ", imageMimeType=" + imageMimeType + ", cost=" + cost + ", balance="
				+ balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
