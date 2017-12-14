package edu.karazin.shop.web;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.karazin.shop.model.Product;
import edu.karazin.shop.service.ProductService;
import edu.karazin.shop.web.form.ProductSearchId;

@RestController
@RequestMapping("products")
public class ProductDeleteController {

	ProductService productService;

	private static final Logger log = LoggerFactory.getLogger(ProductDeleteController.class);

	public ProductDeleteController(@Autowired ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/del")
	public ResponseEntity<?> deleteViaAjax(@RequestBody ProductSearchId searchId) {

		ProductListAjaxResponse response = new ProductListAjaxResponse();

		if (searchId.getIdArr() != null) {
			removeProducts(searchId.getIdArr());
		}

		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		log.info("Product list for role user " + role);

		List<Product> products = productService.searchProducts(null);

		response.setProducts(products);
		response.setRole(role);

		return ResponseEntity.ok(response);

	}

	private void removeProducts(String strId) {
		String[] idArr = strId.split(" ");
		long id;
		for (int i = 0; i < idArr.length; i++) {
			id = Long.valueOf(idArr[i]);

			if (productService.getProduct(id) != null) {
				removeProduct(id);
			}
		}
	}

	private void removeProduct(long id) {
		log.info("Delete product" + id);
		productService.removeProduct(id);
	}
}
