package library.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale.Category;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.admin.bean.Admin;
import library.admin.dao.AdminDao;
import library.encryption.Encryption;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	



		String email = request.getParameter("email");
		String password = request.getParameter("password");

		/*
		 * String dPassword = null; try { dPassword = new
		 * Encryption().encrypt(password); } catch (Exception e) {
		 * 
		 * Logger.getLogger(Category.class.getName()).log(Level.SEVERE,
		 * "something went wrong", e); }
		 */
		AdminDao dao = new AdminDao();
		Admin admin = dao.getAdmin(email, password);

		if (admin == null) {

			response.sendRedirect("error.jsp");
		} else {
			HttpSession s=request.getSession();
			s.setAttribute("Admin", admin);

			response.sendRedirect("adminfunction.jsp");
		}

	}

	

}
