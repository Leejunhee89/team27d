/*team27d[나윤주]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import service.Singer;

public class SingerDao {
	
	public int insertSigner(Singer song) {
		System.out.println(song); //단위테스트 
		return 0;
	}
		
	public ArrayList<Singer> selectSingerList() {
		
		ArrayList<Singer> list = new ArrayList<Singer>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

			
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
				sing.setSingerId(rs.getInt("singerId"));
				sing.setSingerName(rs.getString("singerName"));
				sing.setSingerAge(rs.getInt("singerAge"));
				list.add(sing);
								
				}
		}catch(ClassNotFoundException e){ 
			//ClassNotFoundException 예외발생시 캐치절 매개변수로 넘겨줌
			e.printStackTrace();	
					
		}catch(SQLException e){ 
			//SQLException 예외발생시 캐치절 매개변수로 넘겨줌
			e.printStackTrace();
					
		}finally {
			if(rs!=null) try{ rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try{ conn.close();} catch(SQLException ex) {}
		}
		 
		return list;
	}
}