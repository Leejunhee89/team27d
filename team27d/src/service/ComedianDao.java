//team27d [방민영]

package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import service.Comedian;

public class ComedianDao {
	
	ArrayList<Comedian> list = null;
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	Comedian comedian = null;
	
	/*updateComedianForm.jsp에서 사용하기 위한 updateComedianOne(int id)메서드 선언. <-다른 메서드와 다르게 매개변수를 Comedian데이터 타입으로 받지 않은 이유는 이 메서드에서는 int형 하나의 매개변수를 받는 것이 updateComedianForm에서 코드작성이 더 간단하기 때문이다.
	 *리턴은 Comedian클래스 데이터 타입으로 받는다.
	 *드라이버 로딩, 데이터베이스 연결, select쿼리준비, 쿼리실행 후 resultSet.next()메서드가 '참'이면 ResultSet객체 내에서 데이터를 가져와 Comedian클래스에 세팅한다.
	 *사용한 객체 ResultSet, Statement, Connection을 종료한 후 comedian을 리턴한다.
	 */
	public Comedian updateComedianOne(int id) {
		comedian = new Comedian();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT * FROM comedian WHERE comedian_id=?";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				comedian.setComedianId(resultSet.getInt("comedian_id"));
				comedian.setComedianName(resultSet.getString("comedian_name"));
				comedian.setComedianAge(resultSet.getInt("comedian_age"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		return comedian;
	}
	
	/*updateComedianAction.jsp에서 사용하기 위한 updateComedian(Comedian comedian)메서드 선언.
	 *리턴은 받지 않는다.
	 *드라이버 로딩, 데이터베이스 연결, insert쿼리준비, 쿼리실행 후,
	 *사용한 객체 Statement, Connection을 종료한다.
	 */
	public void updateComedian(Comedian comedian) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "UPDATE comedian SET comedian_name=?, comedian_age=? WHERE comedian_id=?";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, comedian.getComedianName());
			statement.setInt(2, comedian.getComedianAge());
			statement.setInt(3, comedian.getComedianId());
			statement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*deleteComedianAction.jsp에서 사용하기 위한 deleteComedian(Comedian comedian)메서드 선언.
	 *리턴은 받지 않는다.
	 *드라이버 로딩, 데이터베이스 연결, insert쿼리준비, 쿼리실행 후,
	 *사용한 객체 Statement, Connection을 종료한다.
	 */
	public void deleteComedian(Comedian comedian) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM comedian WHERE comedian_id=?";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement=connection.prepareStatement(sql);
			statement.setInt(1, comedian.getComedianId());
			statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*insertComedianAction.jsp에서 사용하기 위한 insertComedian(Comedian comedian)메서드 선언.
	 *리턴은 받지 않는다.
	 *드라이버 로딩, 데이터베이스 연결, insert쿼리준비, 쿼리실행 후,
	 *사용한 객체 Statement, Connection을 종료한다.
	 */
	public void insertComedian(Comedian comedian) {
			try {
			Class.forName("com.mysql.jdbc.Driver");
		
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO comedian(comedian_name, comedian_age) VALUES (?, ?)";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	
			statement= connection.prepareStatement(sql);
			statement.setString(1, comedian.getComedianName());
			statement.setInt(2, comedian.getComedianAge());
			statement.executeUpdate();
		
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	
	/*ComedianList.jsp에서 코미디언 리스트를 보여주기 위한 selectComedianList()메서드 선언.
	 *리턴값은 Comedian클래스형 ArrayList형태로 받는다.
	 *드라이버 로딩, 데이터베이스 연결, select쿼리준비, 쿼리실행 후 resultSet.next()메서드가 '참'이면 ResultSet객체 내에서 데이터를 가져와 Comedian클래스에 세팅하고 값이 세팅된 객체참조변수 comedian을 객체참조변수 list에 담는다.
	 *사용한 객체 ResultSet, Statement, Connection을 종료한 후 list를 리턴한다. 
	 */
	public ArrayList<Comedian> selectComedianList(){
		
		list = new ArrayList<Comedian>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT comedian_id comedianId, comedian_name comedianName, comedian_age comedianAge FROM comedian ORDER BY comedian_id ASC";
			//comedian_id as comedianId에서 as생략함
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
		
			while(resultSet.next()) {
				comedian = new Comedian();
				comedian.setComedianId(resultSet.getInt("comedianId"));
				comedian.setComedianName(resultSet.getString("comedianName"));
				comedian.setComedianAge(resultSet.getInt("comedianAge"));
				list.add(comedian);
			}	
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
				
		}finally {
			if(resultSet!=null) {try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}}
			if(statement!=null) {try {statement.close();} catch (SQLException e) {e.printStackTrace();}}
			if(connection!=null) {try {connection.close();} catch (SQLException e) {e.printStackTrace();}}
		}
		return list;
	}
}
