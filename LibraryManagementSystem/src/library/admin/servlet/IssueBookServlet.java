package library.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.admin.bean.IssueBook;
import library.admin.dao.IssueBookDao;

/**
 * Servlet implementation class IssueBookServlet
 */
@WebServlet("/IssueBookServlet")
public class IssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		String bookname = request.getParameter("bookname");
		int userid = Integer.parseInt(request.getParameter("userid"));
		String username = request.getParameter("username");
		int period = Integer.parseInt(request.getParameter("period"));
		String issuedate = request.getParameter("issuedate");

		IssueBook issuebook = new IssueBook(bookid,bookname,userid,username,period, issuedate );

		IssueBookDao dao = new IssueBookDao();
		if (dao.saveIssueBook(issuebook)) {
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("error.jsp");
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
