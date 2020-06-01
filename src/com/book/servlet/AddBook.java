package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.DAO.BookDAO;
import com.book.model.Book;

public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Form.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String author = request.getParameter("author");
		Boolean isJustContainSpace = name.trim().length() == 0;
		if (isJustContainSpace) {
			out.println("Name don\'t contain just space");
			return;
		}
		Book newBook = new Book(name, author);
		int status = BookDAO.addBook(newBook);
		if (status == 1) {
			response.sendRedirect("/Book/");
		} else {
			out.println("Cannot add book");
		}
	};
}
