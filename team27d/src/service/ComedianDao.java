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
	
	public Comedian forUpdateComedian(int id) {
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
	
	public void deleteComedian(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM comedian where comedian_id=?";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
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
		
	
	public ArrayList<Comedian> selectComedianList(){
		
		list = new ArrayList<Comedian>();
		
		/*try안에 드라이버로딩, DB연결, 쿼리실행준비, 쿼리실행, 객체종료를 넣어주고 catch를 통해 예외를 잡은 후 finally안에서 return값을 받음.*/
		/*Class.forName메서드로 드라이버 로딩.
		 *드라이버주소, 아이디, 패스워드를 String데이터타입으로 값을 넣어주고 
		 *getConnection메서드를 실행한 후 --getConnection메서드의 리턴데이터타입이 Connection이므로--Connection클래스의 주소를 리턴하여 connection변수에 담는다.
		 *prepareStatement메서드를 sql을 매개변수로 하여 실행한 후 PreparedStatement클래스의 주소를 statement변수에 담는다.
		 *ececyteQuery메소드를 실행하여 쿼리를 실행한 후 ResultSet클래스의 주소를 resultSet변수에 담는다.
		 */
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
		
			/*while문을 실행하여 next메소드를 실행한다.
			 *Comedian객체를 생성하고 주소를 comedian변수에 담는다.
			 *ResultSet클래스 내의 getInt메서드를 실행하여 comedianId를 매개변수로  DB에 있는 comedian_id값을 가져와서,
			 *	Comedian클래스에 있는 setComedianId메소드를 실행하여 comedian_id값을 Comedian클래스 내 comedianId변수에 저장한다.
			 *DB에 있는 comedian_name데이터값과 comedian_age데이터값을 같은 방식으로 Comedian클래스 내에 setting한다.
			 *add메소드를 실행하여 Comedian객체의 주소를 list변수에 저장한다.
			 */
			while(resultSet.next()) {
				Comedian comedian = new Comedian();
				comedian.setComedianId(resultSet.getInt("comedianId"));
				comedian.setComedianName(resultSet.getString("comedianName"));
				comedian.setComedianAge(resultSet.getInt("comedianAge"));
				list.add(comedian);
			}	
			
		/*Class.forName메소드의 예외를 catch문을 통해 잡아내어 printStackTrace메소드로 예외를 알려준다.
		 *SQL예외를 catch문을 통해 잡아내어 printStackTrace메소드로 예외를 알려준다.
		 *finally문을 통해 list변수에 담긴 ArrayList<Comedian>주소를 리턴한다.
		 *statement변수에 값이 담겨있으면 PreparedStatement객체를 종료한다.
		 *connection변수에 값이 담겨있으면 Connection객체를 종료한다.
		 *resultSet변수에 값이 담겨있으면 ResultSet객체를 종료한다.
		 */
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				if(statement!=null) {try {statement.close();} catch (SQLException e) {e.printStackTrace();}}
				if(connection!=null) {try {connection.close();} catch (SQLException e) {e.printStackTrace();}}
				if(resultSet!=null) {try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}}
			}
		return list;
	}
}
