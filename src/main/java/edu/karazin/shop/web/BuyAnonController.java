package edu.karazin.shop.web;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.karazin.shop.model.BucketProducts;
import edu.karazin.shop.model.Order;
import edu.karazin.shop.model.Product;
import edu.karazin.shop.model.UserData;
import edu.karazin.shop.service.CartStore;
import edu.karazin.shop.service.OrderService;
import edu.karazin.shop.service.ProductService;
import edu.karazin.shop.web.form.UserDataForm;

@Controller
@RequestMapping("contact")
public class BuyAnonController {

	private static final Logger log = LoggerFactory.getLogger(BuyAnonController.class);

	private final OrderService orderService;
	private final CartStore cartStore;
	private final ProductService productService;
	private Product product;

	public BuyAnonController(@Autowired OrderService orderService, @Autowired CartStore cartStore,
			@Autowired ProductService productService) {
		this.orderService = orderService;
		this.cartStore = cartStore;
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		log.info("Render form for contact");
		model.addAttribute("userDataForm", new UserDataForm());
		return "contact";
	}

	@RequestMapping(method = RequestMethod.GET, path = "{prodId}")
	public String list(Model model, @PathVariable("prodId") Long prodId) {
		log.info("Render form for contact " + prodId);
		product = productService.getProduct(prodId);
		model.addAttribute("userDataForm", new UserDataForm());
		return "contact";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String buybucket(UserData userData) {
		log.info("Buy from the basket");
		Set<Product> products = new HashSet<>();
		Product product;

		for (BucketProducts bucket : cartStore.getProducts()) {

			product = new Product(bucket.getId(), bucket.getTitle(), bucket.getDescription(), bucket.getImage(),
					bucket.getImageMimeType(), bucket.getCost(), bucket.getBalance() - bucket.getCount());
			products.add(product);
			productService.updateProduct(product);
		}
		orderService.createOrder(new Order(userData, products));
		cartStore.removeAllProduct();

		return "redirect:/products";
	}

	@RequestMapping(method = RequestMethod.POST, path = "{prodId}")
	public String buy(UserData userData) {
		log.info("Buy " + userData);
		Set<Product> products = new HashSet<>();

		product.setBalance(product.getBalance() - 1);
		productService.updateProduct(product);
		products.add(product);
		
		orderService.createOrder(new Order(userData, products));

		return "redirect:/products";
	}
}
