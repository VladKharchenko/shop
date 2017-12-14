package edu.karazin.shop.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "order_table")
public class Order {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany
    @JoinColumn(name = "product_id")
	private Set<Product> products;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="data_id")
	private UserData userData;

	public Order(){
	}
	
	public Order(UserData userData, Set<Product> products){
		this.userData = userData;
		this.products = products;
	}
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", products=" + products + ", userData=" + userData + "]";
	}

	
	
}
