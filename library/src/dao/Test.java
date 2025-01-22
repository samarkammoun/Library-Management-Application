package dao;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {
	public static Connection connection(String url, String login,String mp) {
		Connection c = null;
		try {
			c=DriverManager.getConnection(url,login,mp); //faire la connexion avec la base
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return c;
		
		
	}
	

	

}
