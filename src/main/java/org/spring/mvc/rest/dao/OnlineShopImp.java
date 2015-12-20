/**
 * 
 */
package org.spring.mvc.rest.dao;

import java.util.HashMap;
import java.util.Map;

import org.spring.mvc.rest.domain.Product;
import org.springframework.stereotype.Repository;

@Repository("onlineShop")
public class OnlineShopImp implements OnlineShop {

	private static final Map<Integer, Product> tempMap = new HashMap<Integer, Product>();

	static {
		tempMap.put(12345, new Product(12345,"CELL","Apple iphone 6 space grey"));
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.spring.mvc.rest.dao.OnlineShop#createProduct(org.spring.mvc.rest.
	 * domain.Product)
	 */
	@Override
	public boolean createProduct(Product product) {
		tempMap.put(product.getBadcode(), product);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.spring.mvc.rest.dao.OnlineShop#findProductByName(java.lang.String)
	 */
	@Override
	public Product findProductByBarCode(int barcode) {
		return tempMap.get(barcode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.spring.mvc.rest.dao.OnlineShop#updateProduct(org.spring.mvc.rest.
	 * domain.Product)
	 */
	@Override
	public boolean updateProduct(Product product) {
		Product existingProduct = tempMap.get(product.getBadcode());
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.spring.mvc.rest.dao.OnlineShop#deleteProduct(org.spring.mvc.rest.
	 * domain.Product)
	 */
	@Override
	public boolean deleteProduct(Product product) {
		tempMap.remove(product.getBadcode());
		return true;
	}

}
