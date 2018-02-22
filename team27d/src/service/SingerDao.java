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
	
	ResultSet resultset = null;
	Connection connection = null;
	PreparedStatement preparedstatement = null;
	
/*	public Singer uSelectforUpdate(String singerid) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT * FROM tb_user WHERE u_id=?";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			
			preparedstatement = connection.prepareStatement(sql);

			preparedstatement.setString(1, singerid);
			resultset = preparedstatement.executeQuery();
			if(resultset.next()) {
				System.out.println("쿼리 실행 결과 있나? mSelectforUpdate Mdao.java");
				Singer singerreturn = new Singer();
				singerreturn.setSingerId(resultset.getInt("singer_id"));
				singerreturn.setSingerName(resultset.getString("singer_name"));
				singerreturn.setSingerAge(resultset.getInt("singer_age"));
			}
		} catch (ClassNotFoundException e) {
			// ClassNotFoundException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		} catch (SQLException e) {
			// SQLException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		}finally {
			
			if(preparedstatement!=null) {try {preparedstatement.close();} catch (SQLException e) {e.printStackTrace();}}
			if(connection!=null) {try {connection.close();} catch (SQLException e) {e.printStackTrace();}}
		}
		return singerreturn;
	}*/
	
	public void updateSinger(Singer singer, Connection conn) {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		String sql = "UPDATE singer SET singer_name=?,singer_age=? WHERE singer_id = ?";
		connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		preparedstatement = connection.prepareStatement(sql);
		
		preparedstatement.setInt(1, singer.getSingerId());
		preparedstatement.setString(2, singer.getSingerName());
		preparedstatement.setInt(3, singer.getSingerAge());
	
		preparedstatement.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// ClassNotFoundException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		} catch (SQLException e) {
			// SQLException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		}finally {
			
			if(preparedstatement!=null) {try {preparedstatement.close();} catch (SQLException e) {e.printStackTrace();}}
			if(connection!=null) {try {connection.close();} catch (SQLException e) {e.printStackTrace();}}
		}
	}

	public void deleteSigner(String singerid) {

		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		String sql = "DELETE FROM tb_user WHERE u_id=?";
		connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		preparedstatement = connection.prepareStatement(sql);
		
		preparedstatement.setString(1, singerid);
		
		} catch (ClassNotFoundException e) {
			// ClassNotFoundException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		} catch (SQLException e) {
			// SQLException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		}finally {
			
			if(preparedstatement!=null) {try {preparedstatement.close();} catch (SQLException e) {e.printStackTrace();}}
			if(connection!=null) {try {connection.close();} catch (SQLException e) {e.printStackTrace();}}
		}
	}
	
	public void insertSigner(Singer singer) {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		String sql = "INSERT INTO `singer` (`singer_name`, `singer_age`) VALUES (?, ?);";
		connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		preparedstatement = connection.prepareStatement(sql);
		
/*		preparedstatement.setInt(1, id);*/
		preparedstatement.setString(1, singer.getSingerName());
		preparedstatement.setInt(2, singer.getSingerAge());
	
		} catch (ClassNotFoundException e) {
			// ClassNotFoundException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		} catch (SQLException e) {
			// SQLException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		}finally {
			
			if(preparedstatement!=null) {try {preparedstatement.close();} catch (SQLException e) {e.printStackTrace();}}
			if(connection!=null) {try {connection.close();} catch (SQLException e) {e.printStackTrace();}}
		}
	}

	public ArrayList<Singer> selectSingerList() {
		
		ArrayList<Singer> singerlist = new ArrayList<Singer>();
		
		/* ArrayList<Singer> 주소값을 담고있는 객체참조변수 list를 할당. */

		/* db 연결 및 실행을 위한 value값 설정 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* db로딩 */

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// SQL쿼리 키워드 대문자 사용
			String sql = "SELECT singer_id AS singerId, singer_name AS singerName, singer_age AS singerAge FROM singer ORDER BY singer_id ASC";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement(sql);

			/* 쿼리실행결과 사용 */
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				/*
				 * mySQL에 있는 데이터 값을 설정하기위해 Singer.java의 주소를 담고있는 sing 객체참조변수 생성. sing을 통해 데이터값을
				 * 셋팅 및 겟팅해준다. 설정된 값을 list에 sing을 add해준다.
				 */
				Singer sing = new Singer();
				sing.setSingerId(resultset.getInt("singerId"));
				sing.setSingerName(resultset.getString("singerName"));
				sing.setSingerAge(resultset.getInt("singerAge"));
				singerlist.add(sing);
			}
		} catch (ClassNotFoundException e) {
			// ClassNotFoundException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		} catch (SQLException e) {
			// SQLException 예외발생시 캐치절 매개변수로 넘겨준다.
			e.printStackTrace();

		}finally {
			if(resultset!=null) {try {resultset.close();} catch (SQLException e) {e.printStackTrace();}}
			if(preparedstatement!=null) {try {preparedstatement.close();} catch (SQLException e) {e.printStackTrace();}}
			if(connection!=null) {try {connection.close();} catch (SQLException e) {e.printStackTrace();}}
			}
		// list 값을 리턴시켜준다.
		return singerlist;

	}
}