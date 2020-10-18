package com.jakartamp.intro.itemsservice.model;

/**
 *
 * @author Adam M. Gamboa G
 */
public class Groceries {
	private int id;
	private String name;
	private String brand;
	private Stock stock;

	public Groceries(final int id, final String name, final String brand) {
		this.id = id;
		this.name = name;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(final String brand) {
		this.brand = brand;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(final Stock stock) {
		this.stock = stock;
	}

}
