package edu.karazin.shop.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.karazin.shop.model.Product;
import edu.karazin.shop.service.CartStore;
import edu.karazin.shop.service.ProductService;
import edu.karazin.shop.web.form.ProductSerachForm;

@Controller
@RequestMapping("products")
public class ProductListController {

	private static final Logger log = LoggerFactory.getLogger(ProductListController.class);

	private final ProductService productService;
	private final CartStore cartStore;

	public ProductListController(@Autowired ProductService productService, 
			@Autowired CartStore cartStore) {
		this.productService = productService;
		this.cartStore = cartStore;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("cartSize", cartStore.sizeStore());
		return "product-list";
	}
	
	@RequestMapping("/search")
	public ResponseEntity<?> getSearchResultViaAjax(@RequestBody ProductSerachForm form) {
		
		ProductListAjaxResponse response = new ProductListAjaxResponse();
		String searchText = form.getSearchText();
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		
		log.info("Search product " + searchText);
		List<Product> products = productService.searchProducts(searchText);
		
		log.info("Product list for role user " + role);
		
		response.setProducts(products);
		response.setRole(role);
		
		return ResponseEntity.ok(response);
	}
	
}