package org.spring.mvc.rest.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Product.findbyBarcode",query="select p from Product p where p.barcode=:barcode")
	})
public class Product implements Serializable {

	public static final String PRODUCT_FIND_BY_BAR_CODE="Product.findbyBarcode";
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	String name;

	@Column(name = "barcode")
	int barcode;

	@Column(name = "description")
	String description;

	public Product() {
	};

	public Product(int barcode, String name, String description) {
		super();
		this.name = name;
		this.barcode = barcode;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
