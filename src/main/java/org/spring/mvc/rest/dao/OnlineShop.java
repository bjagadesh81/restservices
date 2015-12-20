package org.spring.mvc.rest.dao;

import org.spring.mvc.rest.domain.Product;

public interface OnlineShop {

	boolean createProduct(Product product);
	
	Product findProductByBarCode(String barcode);
	
	boolean updateProduct(Product product);
	
	boolean deleteProduct(Product product);
}
