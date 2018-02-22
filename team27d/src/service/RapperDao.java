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
	
	// 래퍼 수정처리 메서드
	// 래퍼 클래스를 입력변수로 받아 데이터를 게팅(getRapperName, getRapperAge, getRapperId)
	// 게팅한 데이터를 쿼리문에 세팅(입력)해서 업데이트쿼리 실행.
	public void updateRapper(Rapper rapper) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbID = "root";
			String dbPass = "java0000";
			String sql = "UPDATE `rapper` SET `rapper_name`=?, `rapper_age`=? WHERE  `rapper_id`=?";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rapper.getRapperName());
			pstmt.setInt(2, rapper.getRapperAge());
			pstmt.setInt(3, rapper.getRapperId());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();			
		}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
	
	// 래퍼 수정화면 메서드
	// 선택한 래퍼 아이디를 입력변수로 받아 쿼리문의 조건으로 레코드 선택
	// 선택한 레코드를 게팅하고 Rapper클래스에 세팅 후 Rapper클래스를 반환한다. (수정화면에 출력)
	public Rapper updateRapperOne(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbID = "root";
			String dbPass = "java0000";
			String sql = "SELECT * FROM rapper WHERE rapper_id=?";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {		
				rapper = new Rapper();
				rapper.setRapperId(rs.getInt("rapper_id"));
				rapper.setRapperName(rs.getString("rapper_name"));
				rapper.setRapperAge(rs.getInt("rapper_age"));
			}
			pstmt.close();
			conn.close();
		}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
		return rapper;
	}
	
	// 래퍼 삭제 메서드
	// 선택한 래퍼 아이디를 입력변수로 받아 쿼리문의 조건으로 레코드를 삭제
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
	
	// 래퍼 입력화면 메서드
	// 래퍼 클래스를 입력변수로 받아 데이터를 게팅(getRapperName, getRapperAge)
	// getParameter로 바로 받을거면 name, age로 입력변수.
	// 게팅한 데이터를 쿼리문에 세팅(입력)해서 업데이트쿼리 실행.
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
	
	// 모든 래퍼 리스트화면 메서드
	public ArrayList<Rapper> selectRapper() {
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