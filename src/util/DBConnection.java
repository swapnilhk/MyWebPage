package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private Connection con;
	
	public DBConnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_web_page","root","andromeda");
	}	
	
	public ResultSet executeQuery(String query) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}
	
	public int executeUpdate(String query) throws SQLException {
		Statement stmt = con.createStatement();		
		int ret = stmt.executeUpdate(query);
		return ret;
	}
	
	public void finalize() throws SQLException{
		con.close();
	}	
}
