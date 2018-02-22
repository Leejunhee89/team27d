//team27d [��ο�]

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
		
		/*try�ȿ� ����̹��ε�, DB����, ���������غ�, ��������, ��ü���Ḧ �־��ְ� catch�� ���� ���ܸ� ���� �� finally�ȿ��� return���� ����.*/
		/*Class.forName�޼���� ����̹� �ε�.
		 *����̹��ּ�, ���̵�, �н����带 String������Ÿ������ ���� �־��ְ� 
		 *getConnection�޼��带 ������ �� --getConnection�޼����� ���ϵ�����Ÿ���� Connection�̹Ƿ�--ConnectionŬ������ �ּҸ� �����Ͽ� connection������ ��´�.
		 *prepareStatement�޼��带 sql�� �Ű������� �Ͽ� ������ �� PreparedStatementŬ������ �ּҸ� statement������ ��´�.
		 *ececyteQuery�޼ҵ带 �����Ͽ� ������ ������ �� ResultSetŬ������ �ּҸ� resultSet������ ��´�.
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT comedian_id comedianId, comedian_name comedianName, comedian_age comedianAge FROM comedian ORDER BY comedian_id ASC";
			//comedian_id as comedianId���� as������
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
		
			/*while���� �����Ͽ� next�޼ҵ带 �����Ѵ�.
			 *Comedian��ü�� �����ϰ� �ּҸ� comedian������ ��´�.
			 *ResultSetŬ���� ���� getInt�޼��带 �����Ͽ� comedianId�� �Ű�������  DB�� �ִ� comedian_id���� �����ͼ�,
			 *	ComedianŬ������ �ִ� setComedianId�޼ҵ带 �����Ͽ� comedian_id���� ComedianŬ���� �� comedianId������ �����Ѵ�.
			 *DB�� �ִ� comedian_name�����Ͱ��� comedian_age�����Ͱ��� ���� ������� ComedianŬ���� ���� setting�Ѵ�.
			 *add�޼ҵ带 �����Ͽ� Comedian��ü�� �ּҸ� list������ �����Ѵ�.
			 */
			while(resultSet.next()) {
				Comedian comedian = new Comedian();
				comedian.setComedianId(resultSet.getInt("comedianId"));
				comedian.setComedianName(resultSet.getString("comedianName"));
				comedian.setComedianAge(resultSet.getInt("comedianAge"));
				list.add(comedian);
			}	
			
		/*Class.forName�޼ҵ��� ���ܸ� catch���� ���� ��Ƴ��� printStackTrace�޼ҵ�� ���ܸ� �˷��ش�.
		 *SQL���ܸ� catch���� ���� ��Ƴ��� printStackTrace�޼ҵ�� ���ܸ� �˷��ش�.
		 *finally���� ���� list������ ��� ArrayList<Comedian>�ּҸ� �����Ѵ�.
		 *statement������ ���� ��������� PreparedStatement��ü�� �����Ѵ�.
		 *connection������ ���� ��������� Connection��ü�� �����Ѵ�.
		 *resultSet������ ���� ��������� ResultSet��ü�� �����Ѵ�.
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
