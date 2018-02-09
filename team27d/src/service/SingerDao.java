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
	
	public int insertSigner(Singer song) {
		System.out.println(song); //�����׽�Ʈ
		return 0;
	}
		
	public ArrayList<Singer> selectSingerList() {
		
		ArrayList<Singer> list = new ArrayList<Singer>();
		/* ArrayList<Singer> �ּҰ��� ����ִ� ��ü�������� list�� �Ҵ�.*/
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/*db ���� �� ������ ���� �⺻�� ����*/	
		
		try {
			/*db�ε�*/
			Class.forName("com.mysql.jdbc.Driver"); 
			
			/*db����*/
 			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
 			String dbUser = "root";
 			String dbPass = "java0000";
 			
 			/*���� ����*/
			String sql = "select singer_id as singerId, singer_name as singerName, singer_age as singerAge from singer";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement(sql);
			/*���������� ���*/
			rs = pstmt.executeQuery();
			
		while(rs.next()){
				Singer sing = new Singer();
				sing.setSingerId(rs.getInt("singerId"));
				sing.setSingerName(rs.getString("singerName"));
				sing.setSingerAge(rs.getInt("singerAge"));
				list.add(sing);
				/*Singer.java�� �ּҸ� ����ִ� sing ��ü�������� ����. sing�� ���� �����Ͱ��� ���� �� �������ش�.
				 * ������ ����  list�� sing�� add���ش�. 
				 * */
				}
		}catch(ClassNotFoundException e){ 
			//ClassNotFoundException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ���
			e.printStackTrace();	
					
		}catch(SQLException e){ 
			//SQLException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ���
			e.printStackTrace();
					
		}finally {
			//result ��ü����
			if(rs!=null) try{ rs.close();} catch(SQLException ex) {}
			// PreparedStatement ��ü ����
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException ex) {}
			// Connection ��ü ����
			if(conn!=null) try{ conn.close();} catch(SQLException ex) {}
		}
		 
		return list;
	}
}