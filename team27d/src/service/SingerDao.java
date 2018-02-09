package service;

import java.sql.Connection;
import java.sql.Statement; 
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import service.Singer;

public class SingerDao {
	
	public ArrayList<Singer> selectSingerList() throws SQLException {
		
		ArrayList<Singer> list = new ArrayList<Singer>();

		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" + "useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
	
			stmt = conn.createStatement();
			String query = "Select * from singer";
			rs = stmt.executeQuery(query);			
			
		while(rs.next()){
				Singer s = new Singer();
				s.setSingerId(rs.getString("singer_id"));
				s.setSingerName(rs.getString("singer_name"));
				s.setSingerAge(rs.getString("singer_age"));
				list.add(s);
				}
		}catch(ClassNotFoundException e){ 
			//ClassNotFoundException 예외발생시 캐치절 매개변수로 넘겨줌
			System.out.println(e.getMessage	());
			System.out.println("예외발생");			
					
		}finally {
			if(rs!=null) try{ rs.close();} catch(SQLException ex) {}
			if(stmt!=null) try{ stmt.close();} catch(SQLException ex) {}
			if(conn!=null) try{ conn.close();} catch(SQLException ex) {}
			

		}
		return list;
					
	}
}