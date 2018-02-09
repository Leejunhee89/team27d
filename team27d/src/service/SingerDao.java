/*team27d[������]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import service.Singer;

public class SingerDao {
	
	public int insertSigner(Singer sing) {
		System.out.println(sing); //�����׽�Ʈ 
		return 0;
	}
		
	public ArrayList<Singer> selectSingerList() {
		
		ArrayList<Singer> singerlist = new ArrayList<Singer>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
 			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
 			String dbUser = "root";
 			String dbPass = "java0000";
			
			String sql = "select singer_id as singerId, singer_name as singerName, singer_age as singerAge from singer";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		while(rs.next()){
				Singer sing = new Singer();
				int singerId = rs.getInt("singer_id");
				String singerName = rs.getString("singer_name");
				int singerAge = rs.getInt("singer_age");
				
				sing.setSingerId(singerId);
				sing.setSingerName(singerName);
				sing.setSingerAge(singerAge);
				
				singerlist.add(sing);
				
				}
		}catch(ClassNotFoundException e){ 
			//ClassNotFoundException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ���
			e.printStackTrace();	
					
		}catch(SQLException e){ 
			//SQLException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ���
			e.printStackTrace();
					
		}finally {
			if(rs!=null) try{ rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try{ conn.close();} catch(SQLException ex) {}
		}
		 
		return singerlist;
	}
}