package library.user.servlet;

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

import library.encryption.Encryption;
import library.user.bean.User;
import library.user.dao.UserDao;



/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		

				String dPassword=null;
		try {
			dPassword = new Encryption().encrypt(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		UserDao dao = new UserDao();
		User user = dao.getUserByEmailAndPassword(email, dPassword);
	

		if (user == null) {
			response.sendRedirect("error.jsp");
			
		}
		
		else {
		HttpSession s=request.getSession();
		s.setAttribute("User", user);
		response.sendRedirect("userfunction.jsp");
	}
	}

	
}
