package service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;

public class ActorDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	
	Class.forName("com.mysql.jdbc.Driver");
	String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev? useUnicode=true&characterEncoding=euckr";
	String dbUser = "root";
	String dbPass = "java0000";
	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	
	pstmt = conn.prepareStatement(
			"INSERT INTO actor VALUES (?, ?, ?)");
	System.out.println(pstmt + "<-- pstmt 1");
	pstmt.setString(1, m_id);
	pstmt.setString(2, m_pw);
	pstmt.setString(3, m_level);
	
}
