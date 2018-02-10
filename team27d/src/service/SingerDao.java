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
	
	Connection connection = null;
	PreparedStatement preparedstatement = null;
	
	public void insertSigner(Singer insert) {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		String sql = "INSERT INTO singer VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		preparedstatement = connection.prepareStatement(sql);

		preparedstatement.setInt(1, insert.getSingerId());
		preparedstatement.setString(2, insert.getSingerName());
		preparedstatement.setInt(3, insert.getSingerAge());
	
		} catch (ClassNotFoundException e) {
			// ClassNotFoundException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ��ش�.
			e.printStackTrace();

		} catch (SQLException e) {
			// SQLException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ��ش�.
			e.printStackTrace();

		}finally {
			if(preparedstatement!=null) {try {preparedstatement.close();} catch (SQLException e) {e.printStackTrace();}}
			if(connection!=null) {try {connection.close();} catch (SQLException e) {e.printStackTrace();}}
		}
	}

	public ArrayList<Singer> selectSingerList() {
		
		ResultSet resultset = null;

		ArrayList<Singer> list = new ArrayList<Singer>();
		/* ArrayList<Singer> �ּҰ��� ����ִ� ��ü�������� list�� �Ҵ�. */

		/* db ���� �� ������ ���� value�� ���� */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* db�ε� */

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// SQL���� Ű���� �빮�� ���
			String sql = "SELECT singer_id AS singerId, singer_name AS singerName, singer_age AS singerAge FROM singer ORDER BY ASC";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement(sql);

			/* ���������� ��� */
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				/*
				 * mySQL�� �ִ� ������ ���� �����ϱ����� Singer.java�� �ּҸ� ����ִ� sing ��ü�������� ����. sing�� ���� �����Ͱ���
				 * ���� �� �������ش�. ������ ���� list�� sing�� add���ش�.
				 */
				Singer sing = new Singer();
				sing.setSingerId(resultset.getInt("singerId"));
				sing.setSingerName(resultset.getString("singerName"));
				sing.setSingerAge(resultset.getInt("singerAge"));
				list.add(sing);
			}
		} catch (ClassNotFoundException e) {
			// ClassNotFoundException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ��ش�.
			e.printStackTrace();

		} catch (SQLException e) {
			// SQLException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ��ش�.
			e.printStackTrace();

		}finally {
			if(preparedstatement!=null) {try {preparedstatement.close();} catch (SQLException e) {e.printStackTrace();}}
			if(connection!=null) {try {connection.close();} catch (SQLException e) {e.printStackTrace();}}
			if(resultset!=null) {try {resultset.close();} catch (SQLException e) {e.printStackTrace();}}
		}
		// list ���� ���Ͻ����ش�.
		return list;

	}
}