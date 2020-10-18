package com.jakartamp.intro.stockservice.model;

/**
 *
 * @author Adam M. Gamboa G
 */
public class Stock {
	private String id;
	private Integer quantity;
	private String status;
	private Double price;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(final Double price) {
		this.price = price;
	}

}
