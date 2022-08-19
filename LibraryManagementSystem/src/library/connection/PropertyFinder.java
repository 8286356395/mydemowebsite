package library.connection;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFinder {
	
	
	public Properties getProperty() throws Exception{
		
		Properties ps=new Properties();
		FileInputStream fetch= new FileInputStream("C:\\Users\\Satya\\Desktop\\Documents\\LibraryManagementSystem\\src\\database.properties");
		ps.load(fetch);
		fetch.close();
		return ps;
			
	}
	

}
