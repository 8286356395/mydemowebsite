package library.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.admin.bean.Book;
import library.admin.dao.BookDao;


@WebServlet("/AddNewBookServlet")
public class AddNewBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String name = request.getParameter("bookname");

		String author = request.getParameter("authorname");
		int price = Integer.parseInt(request.getParameter("bookprice"));

		Book book = new Book(name, author, price);

		BookDao dao = new BookDao();
		if (dao.saveBook(book)) {
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("bookname");

		String author = request.getParameter("authorname");
		int price = Integer.parseInt(request.getParameter("bookprice"));
		int id=Integer.parseInt(request.getParameter("bookid"));

		Book book = new Book( id,name, author, price);

		BookDao dao = new BookDao();
		if (dao.updateBook(book)) {
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}
