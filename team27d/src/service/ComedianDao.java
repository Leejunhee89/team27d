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
				Comedian comedian = new Comedian();
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
			if(statement!=null) {try {statement.close();} catch (SQLException e) {e.printStackTrace();}}
			if(connection!=null) {try {connection.close();} catch (SQLException e) {e.printStackTrace();}}
			if(resultSet!=null) {try {resultSet.close();} catch (SQLException e) {e.printStackTrace();}}
		}
		return list;
	}
}
