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
			//db로딩
			Class.forName("com.mysql.jdbc.Driver"); 
			//db연결
 			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
 			String dbUser = "root";
 			String dbPass = "java0000";
			//쿼리 실행
			String sql = "select singer_id as singerId, singer_name as singerName, singer_age as singerAge from singer";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement(sql);
			//쿼리실행결과 사용
			rs = pstmt.executeQuery();
			
		while(rs.next()){
				Singer sing = new Singer();
				sing.setSingerId(rs.getInt("singerId"));
				sing.setSingerName(rs.getString("singerName"));
				sing.setSingerAge(rs.getInt("singerAge"));
				list.add(sing);
				//결과값을 셋팅 및 겟딩 해줌.
				}
		}catch(ClassNotFoundException e){ 
			//ClassNotFoundException 예외발생시 캐치절 매개변수로 넘겨줌
			e.printStackTrace();	
					
		}catch(SQLException e){ 
			//SQLException 예외발생시 캐치절 매개변수로 넘겨줌
			e.printStackTrace();
					
		}finally {
			//result 객체종료
			if(rs!=null) try{ rs.close();} catch(SQLException ex) {}
			// PreparedStatement 객체 종료
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException ex) {}
			// Connection 객체 종료
			if(conn!=null) try{ conn.close();} catch(SQLException ex) {}
		}
		 
		return list;
	}
}