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
				s.setSingerId("singer_id");
				s.setSingerName("singer_name");
				s.setSingerAge("singer_age");
				list.add(s);
		}	
		}catch(ClassNotFoundException e){ 
			//FileNotFoundException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ���
			System.out.println(e.getMessage	());
			System.out.println("���ܹ߻�");			
					
		}finally {
			if(rs!=null) try{ rs.close();} catch(SQLException ex) {}
			if(stmt!=null) try{ stmt.close();} catch(SQLException ex) {}
			if(conn!=null) try{ conn.close();} catch(SQLException ex) {}
			
		}
		return list;
				
			
	}
}