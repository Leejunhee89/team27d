package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import service.Anaunseo;

public class AnaunseoDao {
	
	public ArrayList<Anaunseo> selectActorList() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Anaunseo ana = null;
		
		ArrayList<Anaunseo> arrAnaunseo = new ArrayList<Anaunseo>();
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" +
				"useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		pstmt = conn.prepareStatement("SELECT * FROM anaunseo");
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ana = new Anaunseo();
			ana.setAnaunseoId( rs.getInt("announcer_id") );
			ana.setAnaunseoName( rs.getString("announcer_name") );
			ana.setAnaunseoAge( rs.getInt("announcer_age") );
			
			arrAnaunseo.add(ana);
		}
	
		if (pstmt != null) { pstmt.close(); } 
		if (conn != null) { conn.close(); }
		
		return arrAnaunseo;
	}
	
}
