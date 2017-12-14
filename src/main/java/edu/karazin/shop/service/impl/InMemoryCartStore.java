package edu.karazin.shop.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import edu.karazin.shop.model.BucketProducts;
import edu.karazin.shop.model.Product;
import edu.karazin.shop.service.CartStore;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
public class InMemoryCartStore implements CartStore {

	private final Set<BucketProducts> products = new HashSet<>();

	@Override
	public Set<BucketProducts> getProducts() {
		return products;
	}

	@Override
	public void addProduct(BucketProducts prod) {
		if (products.contains(prod)) {
			searchProduct(prod);
		} else {
			products.add(prod);
		}
	}

	private void searchProduct(BucketProducts prod) {
		for (BucketProducts temp : products) {
			if (temp.equals(prod)) {
				temp.addSameProduct();
				break;
			}
		}
	}

	@Override
	public void removeProduct(BucketProducts prod) {
		products.remove(prod);
	}

	@Override
	public void removeAllProduct() {
		products.clear();
	}

	@Override
	public int sizeStore() {
		return products.size();
	}

	@Override
	public long allTotalCost() {
		long cost=0;
		for(BucketProducts bucProd : products){
			cost += bucProd.getTotalCost();
		}
		return cost;
	}

	@Override
	public int getCountSomeProduct(Product product) {
		for(BucketProducts prod : products){
			if(prod.equals(product)){
				return prod.getCount();
			}
		}
		return 0;
	}
}
