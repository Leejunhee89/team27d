//team27d [유국화]
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RapperDao {
	// 예외는 전부 try-catch 처리
	public ArrayList<Rapper> selectRapperList() {
		// ArrayList 래퍼클래스타입으로 객체생성 - 참조변수명은 보통 list로 쓴다
		// rapperlist -> list로 일괄변경하려면! 변수명 블럭-Refactor-Rename클릭
		ArrayList<Rapper> rapperlist = new ArrayList<Rapper>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 드라이버로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			// 디비연결(루트계정 접근)
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbID = "root";
			String dbPass = "java0000";
			// sql에서 쿼리문은 대문자로 구분해주고. 디비칼럼명은 언더바를 많이 쓰고 클래스명은 대문자로 구분이기때문에 일치시켜주려고 as를 쓰면
			// 좋다.
			// select + order by
			String sql = "SELECT rapper_id as rapperId, rapper_name as rapperName, rapper_age as rapperAge FROM rapper ORDER BY rapper_id ASC";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			
			// 쿼리실행준비
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리실행
			rs = pstmt.executeQuery();
			
			// 쿼리실행결과 사용
			while (rs.next()) {
				Rapper rapper = new Rapper(); // 래퍼객체생성
				rapper.setRapperId(rs.getInt("rapperId")); // 디비의 래퍼아이디를 게팅해서 생성한 래퍼객체에 세팅
				rapper.setRapperName(rs.getString("rapperName"));
				rapper.setRapperAge(rs.getInt("rapperAge"));
				rapperlist.add(rapper); // 래퍼리스트에 래퍼객체(반복) 추가 -> 리턴값으로 담을 데이터***
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 닫기
			if (rs != null)	try {rs.close(); rs = null;} catch (SQLException ex) {}
			if (pstmt != null) try {pstmt.close(); pstmt = null;} catch (SQLException ex) {}
			if (conn != null) try {conn.close();conn = null;} catch (SQLException ex) {}
		}
		return rapperlist; // ***추가한 리스트들을 반환
	}
}