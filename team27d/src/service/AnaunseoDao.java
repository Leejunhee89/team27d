package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnaunseoDao {
	
	public Connection getConnection(Anaunseo ana) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" +
				"useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		if (pstmt != null) { pstmt.close(); } 
		
		return conn;
	}
	
	public void AnaInsert(Anaunseo ana) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
	
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" +
				"useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		pstmt = conn.prepareStatement("INSERT INTO Anaunseo VALUES(?, ?, ?)");
		pstmt.setString(1, ana.getAnaunseoId());
		pstmt.setString(2, ana.getAnaunseoName());
		pstmt.setString(3, ana.getAnaunseoAge());
		
		pstmt.executeUpdate();
	
		if (pstmt != null) { pstmt.close(); } 
		if (conn != null) { conn.close(); }
	}
	
	
	
}
