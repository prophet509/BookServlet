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

public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		Book existingBook = BookDAO.getBookById(id);
		if (existingBook == null) {
			out.println("Not found book with id");
			out.close();
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Form.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String author = request.getParameter("author");

		Book updatedBook = new Book(name, author);
		int status = BookDAO.updateBook(id, updatedBook);
		if (status == 1) {
			response.sendRedirect("/Book/");
			return;
		}
		out.println("Cannot add book");
		out.close();

	}

}
