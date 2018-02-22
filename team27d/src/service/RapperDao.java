//team27d [유국화]
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RapperDao {// 예외는 전부 try-catch 처리
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Rapper rapper = null;
	
	// 래퍼 삭제 메서드
	public void deleteRapper(int rapperID) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbID = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM `rapper` WHERE  `rapper_id`=?";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rapperID);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
	
	// 래퍼 입력 메서드
	public void insertRapper(Rapper rapper) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbID = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO `rapper` (`rapper_name`, `rapper_age`) VALUES (?, ?);";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rapper.getRapperName());
			pstmt.setInt(2, rapper.getRapperAge());
			
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
	
	// 모든 래퍼 리스트 메서드
	public ArrayList<Rapper> selectRapperList() {
		// ArrayList 래퍼클래스타입으로 객체생성 - 참조변수명은 보통 list로 쓴다
		// rapperlist -> list로 일괄변경하려면! 변수명 블럭-Refactor-Rename클릭
		ArrayList<Rapper> rapperlist = new ArrayList<Rapper>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbID = "root";
			String dbPass = "java0000";
			// sql에서 쿼리문은 대문자로 구분해주고. 디비칼럼명은 언더바를 많이 쓰고 클래스명은 대문자로 구분이기때문에 일치시켜주려고 as를 쓰면
			// 좋다.
			// select + order by
			String sql = "SELECT rapper_id AS rapperId, rapper_name AS rapperName, rapper_age AS rapperAge FROM rapper ORDER BY rapper_id ASC";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Rapper rapper = new Rapper(); 
				rapper.setRapperId(rs.getInt("rapperId")); 
				rapper.setRapperName(rs.getString("rapperName"));
				rapper.setRapperAge(rs.getInt("rapperAge"));
				rapperlist.add(rapper); // 래퍼리스트에 래퍼객체(반복) 추가 -> 리턴값으로 담을 데이터***
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rapperlist; // ***추가한 리스트들을 반환
	}
}