//team27d [유국화]
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RapperDao {

	public ArrayList<Rapper> selectRapperList() throws SQLException {
		//ArrayList 래퍼클래스타입으로 객체생성
		ArrayList<Rapper> rapperlist = new ArrayList<Rapper>();
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//드라이버로딩
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("---드라이버로딩---");
		
			//디비연결(루트계정 접근)
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbID = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			System.out.println("---디비연결---");

			//쿼리실행준비
			pstmt = conn.prepareStatement("SELECT * FROM rapper");
			System.out.println(pstmt + "---쿼리실행준비---");
			
			//쿼리실행
			rs = pstmt.executeQuery();
			System.out.println(rs + "---쿼리실행---");
						
			//쿼리실행결과 사용
			while(rs.next()) {
				Rapper rapper = new Rapper(); //래퍼객체생성
				rapper.setRapperId(rs.getInt("rapper_id")); //디비의 래퍼아이디를 게팅해서 생성한 래퍼객체에 세팅
				rapper.setRapperName(rs.getString("rapper_name"));
				rapper.setRapperAge(rs.getInt("rapper_age"));
				rapperlist.add(rapper); //래퍼리스트에 래퍼객체(반복) 추가
				System.out.println("---while문 반복---");
				System.out.println(rapperlist.add(rapper));
			}
		}catch(ClassNotFoundException e){
				System.out.println("catch-예외발생");
		}finally {
		//닫기			
			if(rs!=null) try{ rs.close(); rs = null; } catch(SQLException ex) {}
			if(pstmt!=null) try{ pstmt.close(); pstmt = null; } catch(SQLException ex) {}
			if(conn!=null) try{ conn.close(); conn = null; } catch(SQLException ex) {}
		}
		return rapperlist;
	}
}
