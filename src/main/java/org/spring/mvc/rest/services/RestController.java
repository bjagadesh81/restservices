package org.spring.mvc.rest.services;

import org.spring.mvc.rest.dao.OnlineShop;
import org.spring.mvc.rest.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest")
public class RestController {

	@Autowired
	private OnlineShop onlineShop;

	@ResponseBody
	@RequestMapping(value = "/ping",method=RequestMethod.GET)
	public String test() {
		return "pong";
	}

	@RequestMapping(value = "shop/{barcode}", method = RequestMethod.GET)
	@ResponseBody
	public Product getProductByBarCode(@PathVariable String barcode) {
		return onlineShop.findProductByBarCode(barcode);
	}
	
	@RequestMapping(value = "shop/create", method = RequestMethod.PUT)
	public ResponseEntity<String> createNewProduct(@RequestBody Product product){
		onlineShop.createProduct(product);
		return new ResponseEntity<String>("New Product Created", HttpStatus.OK);
	}
	
	@RequestMapping(value = "shop/update", method = RequestMethod.POST)
	public ResponseEntity<String> updateProduct(@RequestBody Product product){
		onlineShop.updateProduct(product);
		return new ResponseEntity<String>("Product Updated", HttpStatus.OK);
	}
	
	@RequestMapping(value = "shop/delete", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProduct(@RequestBody Product product){
		onlineShop.deleteProduct(product);
		return new ResponseEntity<String>("Product deleted from DB", HttpStatus.OK);
	}
}
