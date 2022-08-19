package library.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.user.bean.User;
import library.user.dao.UserDao;



/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text./html");
		PrintWriter out = response.getWriter();

		
		out.println("done");
		int id =Integer.parseInt(request.getParameter("id"));
		System.out.println("ho gaya"+id);
		String name = request.getParameter("username");
		
		String email = request.getParameter("useremail");
		String password = request.getParameter("userpassword");
		System.out.println("ho gaya"+id);
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		UserDao ud =new UserDao();
		System.out.println("ho gaya"+id);
		ud.getUpdate(u);
		System.out.println("ho gaya"+id);
		response.sendRedirect("viewuser.jsp");
		System.out.println("ho gaya"+id);

	}

	

}
