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
		System.out.println(song); // �����׽�Ʈ
		return 0;
	}

	public ArrayList<Singer> selectSingerList() {

		ArrayList<Singer> list = new ArrayList<Singer>();
		/* ArrayList<Singer> �ּҰ��� ����ִ� ��ü�������� list�� �Ҵ�. */

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		/* db ���� �� ������ ���� value�� ���� */

		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* db�ε� */

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// SQL���� Ű���� �빮�� ���
			String sql = "SELECT singer_id AS singerId, singer_name AS singerName, singer_age AS singerAge FROM singer ORDER BY ASC";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			pstmt = conn.prepareStatement(sql);

			/* ���������� ��� */
			rs = pstmt.executeQuery();

			while (rs.next()) {
				/*
				 * mySQL�� �ִ� ������ ���� �����ϱ����� Singer.java�� �ּҸ� ����ִ� sing ��ü�������� ����. sing�� ���� �����Ͱ���
				 * ���� �� �������ش�. ������ ���� list�� sing�� add���ش�.
				 */
				Singer sing = new Singer();
				sing.setSingerId(rs.getInt("singerId"));
				sing.setSingerName(rs.getString("singerName"));
				sing.setSingerAge(rs.getInt("singerAge"));
				list.add(sing);
			}
		} catch (ClassNotFoundException e) {
			// ClassNotFoundException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ��ش�.
			e.printStackTrace();

		} catch (SQLException e) {
			// SQLException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ��ش�.
			e.printStackTrace();

		}finally {
			if(pstmt!=null) {try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs!=null) {try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
		}
		// list ���� ���Ͻ����ش�.
		return list;

	}
}