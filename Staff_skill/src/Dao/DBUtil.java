package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;




public class DBUtil {
	private static final String driver;
	private static final String url;
	private static final String user;
	private static final String pw;
	static {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://127.0.0.1:3306/jjdev?useUnicode=true&characterEncoding=euckr";
		user = "root";
		pw = "java0000";
	}
	
	public static Connection getConnection() throws ClassNotFoundException{
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if(rs != null) {
			try{
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	if(stmt != null) {
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	if(conn != null){
		try{
			conn.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	}
	
}