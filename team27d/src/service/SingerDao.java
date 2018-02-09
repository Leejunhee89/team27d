package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import service.Singer;

public class SingerDao {
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	public void selectSingerList(Singer list, Connection conn) {
		

			Class.forName("com.mysql.jdbc.Driver"); 
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" + "useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			
			pstmt = conn.prepareStatement("select * from tb_user");
			rs = pstmt.executeQuery();
			
}