package library.admin.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale.Category;
import java.util.logging.Level;
import java.util.logging.Logger;

import library.admin.bean.Admin;
import library.connection.ConnectionProvider;
import library.user.bean.User;

public class AdminDao {

	public Connection con;

	
	// insert new admin query
	
	
	public boolean saveAdmin(Admin admin) {
		boolean f = false;
		try {
			con = ConnectionProvider.getDataSource().getConnection();
			String query = "insert into admin(name,email,password,gender)values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getEmail());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getGender());

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

	public Admin getAdmin(String email, String password) {

		Admin admin = null;

		try {
			con = ConnectionProvider.getDataSource().getConnection();
			String query = "select name,email,password from admin where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet set = ps.executeQuery();

			if (set.next()) {

				admin = new Admin();

				// data from db
				admin.setName(set.getString("name"));
				// admin.setId(set.getInt("id")); 
								
				admin.setEmail(set.getString("email"));
				admin.setPassword(set.getString("password"));
				/* admin.setGender(set.getString("gender")); */

			}

		} catch (Exception e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		try {
			con.close();
		} catch (SQLException e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "something went wrong", e);
		}
		return admin;
	}

}
