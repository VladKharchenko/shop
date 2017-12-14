package edu.karazin.shop.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.karazin.shop.model.Product;
import edu.karazin.shop.service.CartStore;
import edu.karazin.shop.service.ProductService;

@Controller
@RequestMapping("productview")
public class ProductViewController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductViewController.class);

	private final ProductService productService;
	private final CartStore cartStore;

	public ProductViewController(@Autowired ProductService productService, 
			@Autowired CartStore cartStore) {
		this.productService = productService;
		this.cartStore = cartStore;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public String editProduct(Model model, @PathVariable("id") Long productId) {
		log.info("Product view id=" + productId);

		Product p = productService.getProduct(productId);
		if (p == null) {
			throw new NotFoundException();
		}

		model.addAttribute("product", p);
		model.addAttribute("cartSize", cartStore.sizeStore());
		return "product-view";
	}
}
