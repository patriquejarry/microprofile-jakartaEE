package com.jakartamp.intro.itemsservice.model;

/**
 *
 * @author Adam M. Gamboa G
 */
public class Book {
	private int id;
	private String name;
	private String author;
	private Stock stock;

	public Book(final int id, final String name, final String author) {
		this.id = id;
		this.name = name;
		this.author = author;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(final Stock stock) {
		this.stock = stock;
	}

}
