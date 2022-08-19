package library.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.logging.Level;
import java.util.logging.Logger;

import library.admin.bean.Book;
import library.admin.bean.IssueBook;
import library.connection.ConnectionProvider;

public class IssueBookDao {

	private Connection con;

	// method to insert user into database
	public boolean saveIssueBook(IssueBook issuebook) {
		boolean f = false;
		try {
			con = ConnectionProvider.getDataSource().getConnection();
			String query = "insert into issuebook(bookid,bookname,userid,username,period,issuedate)values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, issuebook.getBookid());
			ps.setString(2, issuebook.getBookname());
			ps.setInt(3, issuebook.getUserid());
			ps.setString(4, issuebook.getUsername());
			ps.setInt(5, issuebook.getPeriod());
			ps.setString(6, issuebook.getIssuedate());

			ps.executeUpdate();

			f = true;
		} catch (Exception e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		try {
			con.close();
		} catch (SQLException e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		return f;

	}

	// Fetch issued book table

	public List<IssueBook> getIssueAll() {
  System.out.println("akhoijhjbkj");
		List<IssueBook> list = new ArrayList<>();

		try {
			con = ConnectionProvider.getDataSource().getConnection();
			String q = "Select issueid, bookid, bookname, userid, username, period, issuedate, returndate from issuebook";
			PreparedStatement ps = con.prepareStatement(q);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			  int issueid =rs.getInt("issueid");
			  int bookid = rs.getInt("bookid");
			  String bookname= rs.getString("bookname");
			  int userid = rs.getInt("userid");
			  String username = rs.getString("username");
			  int period = rs.getInt("period");
			  String issuedate = rs.getString("issudate");
			  String returndate = rs.getString("returndate");
				list.add(new IssueBook(issueid,bookid,bookname,userid,username,period,issuedate,returndate));

			}

		} catch (Exception e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		try {
			con.close();
		} catch (SQLException e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		return list;
	}

	
	
	// 
	public boolean returnBook(int issueid, String returndate)
	{
		boolean del = false;
		try {
			con = ConnectionProvider.getDataSource().getConnection();

			String q = "update issuebook set returndate='returndate'where issueid=?;";

			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, issueid);
		
			del = ps.executeUpdate()>0;

		}

		catch (SQLException e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);

		}
		try {
			con.close();
		} catch (SQLException e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}

		return del;

	  	
	}

}
