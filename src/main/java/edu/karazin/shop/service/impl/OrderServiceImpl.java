package edu.karazin.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.karazin.shop.dao.OrderRepository;
import edu.karazin.shop.model.Order;
import edu.karazin.shop.model.UserData;
import edu.karazin.shop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	private final OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	public Order createOrder(Order order) {	
		return orderRepository.save(order);
	}

	@Override
	public Order getOrder(Long id) {
		return orderRepository.findOne(id);
	}

	@Override
	public List<Order> getOrders() {
		return (List<Order>) orderRepository.findAll();
	}

	@Override
	public List<Order> getOrders(UserData userData) {
		return (List<Order>) orderRepository.findByUserData(userData.getId());
	}

}
