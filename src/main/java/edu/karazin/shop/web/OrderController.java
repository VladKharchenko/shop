package edu.karazin.shop.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.karazin.shop.model.Order;
import edu.karazin.shop.model.UserData;
import edu.karazin.shop.service.CartStore;
import edu.karazin.shop.service.OrderService;
import edu.karazin.shop.service.UserService;

@Controller
@RequestMapping("/orderlist")
public class OrderController {

	private final OrderService orderService;
	private final CartStore cartStore;
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	public OrderController(OrderService orderService, CartStore cartStore) {
		this.orderService = orderService;
		this.cartStore = cartStore;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		log.info("Order list");
		
		List<Order> orders = orderService.getOrders();		
		model.addAttribute("orders", orders);	
		model.addAttribute("cartSize", cartStore.sizeStore());
		
		return "order-list";
	}

}