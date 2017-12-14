package edu.karazin.shop.web;

import java.util.List;

import edu.karazin.shop.model.Product;

public class ProductListAjaxResponse {
	String role;
	List<Product> products;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
