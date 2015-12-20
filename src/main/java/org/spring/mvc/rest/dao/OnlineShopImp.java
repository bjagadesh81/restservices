/**
 * 
 */
package org.spring.mvc.rest.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.spring.mvc.rest.domain.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("onlineShop")
@Transactional(propagation = Propagation.REQUIRED)
public class OnlineShopImp implements OnlineShop {

	private static final Map<Integer, Product> tempMap = new HashMap<Integer, Product>();

	static {
		tempMap.put(12345, new Product(12345,"CELL","Apple iphone 6 space grey"));
	}
	
	@PersistenceContext(unitName="onlineshop")
	private EntityManager em;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.spring.mvc.rest.dao.OnlineShop#createProduct(org.spring.mvc.rest.
	 * domain.Product)
	 */
	@Override
	public boolean createProduct(Product product) {
		//tempMap.put(product.getBarcode(), product);
		em.persist(product);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.spring.mvc.rest.dao.OnlineShop#findProductByName(java.lang.String)
	 */
	@Override
	public Product findProductByBarCode(String barcode) {
		 List<?> products  = em.createNamedQuery(Product.PRODUCT_FIND_BY_BAR_CODE).setParameter("barcode", Integer.parseInt(barcode)).getResultList();
		 if(products.size() == 1){
			 return (Product)products.get(0);
		 }else
			 return null;
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
		Product existingProduct = tempMap.get(product.getBarcode());
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
		tempMap.remove(product.getBarcode());
		return true;
	}

}
