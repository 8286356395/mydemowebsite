package library.user.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.logging.Level;
import java.util.logging.Logger;

import library.connection.ConnectionProvider;
import library.user.bean.User;

public class UserDao {

	public Connection con;


	// method to insert user into database
	public boolean saveUser(User user) {
		boolean f = false;
		try {
			con = ConnectionProvider.getDataSource().getConnection();

			String query = "insert into user(name,email,password,gender)values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getGender());

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

	// get user by email and password

	public User getUserByEmailAndPassword(String email, String password) {

		User user = null;

		try {
			con = ConnectionProvider.getDataSource().getConnection();
			String query = "select name,email,password from user where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet set = ps.executeQuery();

			if (set.next()) {

				user = new User();

				// data from db

				// String name = set.getString("name");
				user.setName(set.getString("name"));
				user.setId(set.getInt("id"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));

			}

		} catch (Exception e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		try {
			con.close();
		} catch (SQLException e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		
		return user;
	}

	// fetch all data from database

	public List<User> getAll() {
		List<User> list = new ArrayList<User>();

		try {
			con = ConnectionProvider.getDataSource().getConnection();
			String q = "Select  id ,name,email,gender from user where status=1";
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setGender(rs.getString("gender"));
				list.add(u);

			}

		} catch (Exception e) {

		}
		try {
			con.close();
		} catch (SQLException e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		return list;
	}

	// update user details

	public void updateUser(int id, String name, String email, String password) {

		try {
			con = ConnectionProvider.getDataSource().getConnection();

			String q2 = "update  user set name=?,email=?,password=? where id=?";
			PreparedStatement ps = con.prepareStatement(q2);

			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (Exception e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		try {
			con.close();
		} catch (SQLException e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}

	}

	// get user from id

	public ResultSet getUser(int id) {
		ResultSet rs = null;
		try {
			con = ConnectionProvider.getDataSource().getConnection();
			String q2 = "select * from user where id=?";
			PreparedStatement ps = con.prepareStatement(q2);

			ps.setInt(1, id);

			rs = ps.executeQuery();

		} catch (Exception e) {

			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		try {
			con.close();
		} catch (SQLException e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		return rs;
	}

// delete data from database

	public boolean deleteUser(int id) {
		boolean del = false;

		try {
			con = ConnectionProvider.getDataSource().getConnection();
			String q = "update user set status=-1 where id=?;";

			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, id);
			del = ps.executeUpdate() > 0;

		} catch (Exception e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		try {
			con.close();
		} catch (SQLException e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		return del;

	}

	public void updateUser(int id) {
		// TODO Auto-generated method stub

	}

// search query	

	public List<User> getSearch(String q) {
		String query = "select id,name,email,gender from user where name like '%" + q + "%' and status=1";
		List<User> list = new ArrayList();
		try {
			con = ConnectionProvider.getDataSource().getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				//user.setPassword(rs.getString(4));
				user.setGender(rs.getString("gender"));
				list.add(user);

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

	public void getEdit(int id) {

	}

	public void getUpdate(User u) {
		try {
			con = ConnectionProvider.getDataSource().getConnection();

			String q2 = "update  user set name=?,email=?,password=? where id=?";
			PreparedStatement ps = con.prepareStatement(q2);

			ps.setString(2, u.getName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setInt(1, u.getId());

			ps.executeUpdate();
			

		} catch (Exception e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		try {
			con.close();
		} catch (SQLException e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}

	}

}
