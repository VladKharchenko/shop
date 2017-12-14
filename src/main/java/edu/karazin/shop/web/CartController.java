package edu.karazin.shop.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.karazin.shop.model.BucketProducts;
import edu.karazin.shop.model.Product;
import edu.karazin.shop.service.CartStore;
import edu.karazin.shop.service.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {

	private static final Logger log = LoggerFactory.getLogger(CartController.class);
	
	private final ProductService productService;
	private final CartStore cartStore;

	public CartController(@Autowired ProductService productService, @Autowired CartStore cartStore) {
		this.productService = productService;
		this.cartStore = cartStore;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		log.info("List product in cart");
		model.addAttribute("products", cartStore.getProducts());
		model.addAttribute("allTotalCost", cartStore.allTotalCost());
		return "cart-list";
	}

	@RequestMapping(method = RequestMethod.GET, params = "add")
	public String addProduct(@RequestParam("prodId") Long prodId, Model model) {
		Product product = productService.getProduct(prodId);
		if(product.getBalance()>cartStore.getCountSomeProduct(product)){	
			log.info("Add to cart");
			cartStore.addProduct(new BucketProducts(product));
		}
		return list(model);
	}

	@RequestMapping(method = RequestMethod.GET, params = "delete")
	public String removeProduct(@RequestParam("prodId") Long prodId, Model model) {
		Product product = productService.getProduct(prodId);
		log.info("Remove product from cart " + product);
		cartStore.removeProduct(new BucketProducts(product));
		return list(model);
	}
}
