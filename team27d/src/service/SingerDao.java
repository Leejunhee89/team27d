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
		System.out.println(song); // 단위테스트
		return 0;
	}

	public ArrayList<Singer> selectSingerList() {

		ArrayList<Singer> list = new ArrayList<Singer>();
		/* ArrayList<Singer> 주소값을 담고있는 객체참조변수 list를 할당. */

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/* db 연결 및 실행을 위한 value값 설정 */

		try {

			Class.forName("com.mysql.jdbc.Driver");
			/* db로딩 */

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// SQL쿼리 키워드 대문자 사용
			String sql = "SELECT singer_id AS singerId, singer_name AS singerName, singer_age AS singerAge FROM singer ORDER BY ASC";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			pstmt = conn.prepareStatement(sql);

			/* 쿼리실행결과 사용 */
			rs = pstmt.executeQuery();

			while (rs.next()) {
				/*
				 * mySQL에 있는 데이터 값을 설정하기위해 Singer.java의 주소를 담고있는 sing 객체참조변수 생성. sing을 통해 데이터값을
				 * 셋팅 및 겟팅해준다. 설정된 값을 list에 sing을 add해준다.
				 */
				Singer sing = new Singer();
				sing.setSingerId(rs.getInt("singerId"));
				sing.setSingerName(rs.getString("singerName"));
				sing.setSingerAge(rs.getInt("singerAge"));
				list.add(sing);
			}
		} catch (ClassNotFoundException e) {
			// ClassNotFoundException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		} catch (SQLException e) {
			// SQLException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		} finally {
			// result 객체종료
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			// PreparedStatement 객체 종료
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			// Connection 객체 종료
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		// list 값을 리턴시켜준다.
		return list;

	}
}