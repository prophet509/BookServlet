package com.book.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.book.model.Book;

public class BookDAO {
	private static List<Book> initBooks = Arrays.asList(
			new Book("Harry Potter", "J.K.Rowling"),
			new Book("Never let me go", "Kazuo Ishiguro"), 
			new Book("The Snowman", "Jo Nesbo")
			);
	public static List<Book> listBooks = new ArrayList<>(initBooks);

	public static int addBook(Book book) {
		int status = 0;
		listBooks.add(book);
		status = 1;
		return status;
	}
	public static int updateBook(String id ,Book book) {
		int status = 0;
		for(Book b:listBooks) {
			if(id.equals(b.getId())) {
				b.setName(book.getName());
				b.setAuthor(book.getAuthor());
				break;
			}
		}
		status = 1;
		return status;
	}
	public static int deleteBook(String id) {
		int status = 0;
		for (int i = 0; i < listBooks.size(); i++) {
			if(listBooks.get(i).getId().equals(id) ){
				listBooks.remove(i);
				break;
			}
		}
		status = 1;
		return status;
	}
	public static Book getBookById(String id) {
		for(Book b:listBooks) {
			if(id.equals(b.getId())) {
				return b;
			}
		}
		return null;
	}
}
