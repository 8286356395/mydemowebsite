package library.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.admin.bean.Admin;
import library.admin.dao.AdminDao;
import library.encryption.Encryption;

/**
 * Servlet implementation class RegisterAdminServlet
 */
@WebServlet("/RegisterAdminServlet")
public class RegisterAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String gender = request.getParameter("gender"); 
      Admin admin=new Admin(name,email,password,gender);
        
        
		AdminDao dao=new AdminDao();
		
		if(dao.saveAdmin(admin)) {
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
