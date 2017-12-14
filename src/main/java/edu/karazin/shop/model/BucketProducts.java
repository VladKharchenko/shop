package edu.karazin.shop.model;

public class BucketProducts extends Product {
	
	private int count;
	private long totalCost;
	
	public BucketProducts(){
	}
	
	public BucketProducts(Product prod){
		super(prod.getId(), prod.getTitle(), prod.getDescription(), prod.getImage(), 
				prod.getImageMimeType(), prod.getCost(), prod.getBalance());
		addSameProduct();	
	}
	
	public void addSameProduct(){
		this.count++;
		this.totalCost += this.getCost();		
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}	
	
}
