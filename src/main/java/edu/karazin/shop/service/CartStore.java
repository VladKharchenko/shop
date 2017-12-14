package edu.karazin.shop.service;

import java.util.Set;

import edu.karazin.shop.model.BucketProducts;
import edu.karazin.shop.model.Product;

public interface CartStore {

	Set<BucketProducts> getProducts();

	void addProduct(BucketProducts prod);

	void removeProduct(BucketProducts prod);
	
	void removeAllProduct();
	
	int sizeStore();
	
	long allTotalCost();
	
	int getCountSomeProduct(Product product);
}
