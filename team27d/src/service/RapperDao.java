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
			//sql에서 쿼리문은 대문자로 구분해주고. 디비칼럼명은 언더바를 많이 쓰고 클래스명은 대문자로 구분이기때문에 일치시켜주려고 as를 쓰면 좋다.
			String sql = "SELECT rapper_id as rapperId, rapper_name as rapperName, rapper_age as rapperAge FROM rapper";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			System.out.println("---디비연결---");

			//쿼리실행준비
			pstmt = conn.prepareStatement(sql);
			System.out.println(pstmt + "---쿼리실행준비---");
			
			//쿼리실행
			rs = pstmt.executeQuery();
			System.out.println(rs + "---쿼리실행---");
						
			//쿼리실행결과 사용
			while(rs.next()) {
				Rapper rapper = new Rapper(); //래퍼객체생성
				rapper.setRapperId(rs.getInt("rapperId")); //디비의 래퍼아이디를 게팅해서 생성한 래퍼객체에 세팅
				rapper.setRapperName(rs.getString("rapperName"));
				rapper.setRapperAge(rs.getInt("rapperAge"));
				rapperlist.add(rapper); //래퍼리스트에 래퍼객체(반복) 추가
				System.out.println("---while문 반복 단위테스트---");
				System.out.println(rapperlist.toString());
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
