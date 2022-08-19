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

import library.encryption.Encryption;
import library.user.bean.User;
import library.user.dao.UserDao;

@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String check=request.getParameter("check");
		if(check==null) {
			out.println("box not checked");
		}else {
		String name = request.getParameter("username");
		
		
		String email = request.getParameter("useremail");
		String sPassword = request.getParameter("userpassword");
		String password=null;
		try {
			password = new Encryption().encrypt(sPassword);
		} catch (Exception e) {
			
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}

		String gender = request.getParameter("gender"); 
		User user=new User(name,email,password,gender);
        
        
		UserDao dao=new UserDao();
		
		if(dao.saveUser(user)) {
			response.sendRedirect("success.jsp");
		}else
		{
			response.sendRedirect("error.jsp");
		}
		}
		
	
	
	{
	}
	
	}
	
		
		
		
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
