package library.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.admin.dao.BookDao;
import library.admin.dao.IssueBookDao;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	    int issueid =Integer.parseInt(request.getParameter("issueid"));
	    String returndate = request.getParameter("returndate");		
		IssueBookDao book =new IssueBookDao();
		book.returnBook(issueid , returndate);
	   // response.sendRedirect("viewbook.jsp");
		response.sendRedirect("viewissuedbook.jsp");
	}

}
