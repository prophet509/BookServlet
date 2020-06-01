package com.book.model;

import java.util.UUID;

public class Book {
	protected String id;
	protected String name;
	protected String author;

	public Book() {
		super();
	}

	public Book(String name, String author) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + "]";
	}

}
