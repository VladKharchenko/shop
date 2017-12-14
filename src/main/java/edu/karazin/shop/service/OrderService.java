package edu.karazin.shop.service;

import java.util.List;

import edu.karazin.shop.model.Order;
import edu.karazin.shop.model.UserData;

public interface OrderService {
	
	List<Order> getOrders();
	
	Order createOrder(Order order);

	Order getOrder(Long id);
	
	List<Order> getOrders(UserData userData);
}
