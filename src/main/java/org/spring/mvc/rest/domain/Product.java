package org.spring.mvc.rest.domain;

public class Product {

	String name;
	int badcode;
	String description;

	public Product() {};
	public Product(int badcode, String name, String description) {
		super();
		this.name = name;
		this.badcode = badcode;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBadcode() {
		return badcode;
	}

	public void setBadcode(int badcode) {
		this.badcode = badcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
