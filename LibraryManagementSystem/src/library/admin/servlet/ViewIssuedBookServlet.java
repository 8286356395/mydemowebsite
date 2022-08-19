package library.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.admin.bean.IssueBook;
import library.admin.dao.IssueBookDao;
import java.util.*;

/**
 * Servlet implementation class ViewIssuedBookServlet
 */
@WebServlet("/ViewIssuedBookServlet")
public class ViewIssuedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewIssuedBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			IssueBookDao ibd=new IssueBookDao();
		
			 List<IssueBook> list=ibd.getIssueAll();
			 System.out.println("frrtr");
			 request.setAttribute("list",list);
			 System.out.println("tytyttr");
			
			
			/*
			 * IssueBookDao bd = new IssueBookDao(); List<IssueBook> list =
			 * bd.getIssueAll(); request.setAttribute("list", list);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewissuedbook.jsp");
		dispatcher.forward(request, response);
	}

}
