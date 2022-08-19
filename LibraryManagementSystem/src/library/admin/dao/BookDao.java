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

import library.admin.bean.Admin;
import library.admin.bean.Book;
import library.connection.ConnectionProvider;
import library.user.bean.User;

public class BookDao {

	private Connection con;



	// method to insert user into database
	public boolean saveBook(Book book) {
		boolean f = false;
		try {
			con = ConnectionProvider.getDataSource().getConnection();
			String query = "insert into book(name,author,price)values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, book.getName());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getPrice());

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
	
	//update book into database
	public boolean updateBook(Book book)
	{
		try {
			con = ConnectionProvider.getDataSource().getConnection();
			String query="update book set name=?, author=?, price=? where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, book.getName());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getPrice());
			ps.setInt(4, book.getId());
			ps.executeUpdate();
			
			return true;
		} catch (Exception e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		return false;
	}

	// fetch database

	public List<Book> getAll() {

		List<Book> list = new ArrayList<Book>();

		try {
			con = ConnectionProvider.getDataSource().getConnection();
			String q = "Select id, name, author, price from book where status=1";
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getInt("price"));

				list.add(b);

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

// search book

	public List<Book> getSearch(String q) {
		String query = "select id, name, author, price from book where name like '%" + q + "%' and status=1";
		List<Book> list = new ArrayList();
		try {
			con = ConnectionProvider.getDataSource().getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));

				list.add(book);

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

	// deleteBook from database

	public boolean deleteBook(int id) {
		boolean del = false;
		try {
			con = ConnectionProvider.getDataSource().getConnection();

			String q = "update book set status=-1 where id=?;";

			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, id);
			del = ps.executeUpdate() > 0;

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
