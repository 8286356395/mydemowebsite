package library.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.admin.bean.Book;
import library.admin.dao.BookDao;

/**
 * Servlet implementation class ViewBookServlet
 */
@WebServlet("/ViewBookServlet")
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("booklistnabhv"
				+ "55455");
		
		HttpSession session = null;
		List<Book>booklist=null;
		//Book book=new Book();
		BookDao bookdao=new BookDao();
		 booklist= bookdao.getAll();
		System.out.println("booklist"+booklist);
	
		session.setAttribute("clist", booklist);
		System.out.println("booklist22");
		response.sendRedirect("viewbook.jsp");
		System.out.println("booklis66t");
		 
		//response.sendRedirect("viewbook.jsp");
		
	
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
