
package library.connection;

import java.nio.file.Path;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale.Category;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionProvider {

	private static final String DB_USERNAME = "db.username";
	private static final String DB_PASSWORD = "db.password";
	private static final String DB_URL = "db.url";
	private static Properties properties = null;
	private static MysqlDataSource dataSource;
	static {
		try {

			properties = new PropertyFinder().getProperty();

			dataSource = new MysqlDataSource();
			System.out.println("hoiiiii" + properties.getProperty(DB_URL));

			dataSource.setUrl(properties.getProperty(DB_URL));
			dataSource.setUser(properties.getProperty(DB_USERNAME));
			dataSource.setPassword(properties.getProperty(DB_PASSWORD));

			Logger logger = Logger.getLogger("mylogger");
			logger.info("" + dataSource);
		} catch (Exception e) {
			Logger.getLogger(Category.class.getName()).log(Level.SEVERE, "Error", e);
		}
	}

	public static DataSource getDataSource() {
		return dataSource;

	}

}
