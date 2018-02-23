// team27d [���Ḳ]
package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import service.Anaunseo;

public class AnaunseoDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public void updateAnaunseo(Anaunseo anaunseo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String id = "root";
			String pw = "java0000";
			connection = DriverManager.getConnection(url, id, pw);
			preparedStatement = connection.prepareStatement("UPDATE anaunseo SET anaunseo_name = ?, anaunseo_age = ? WHERE anaunseo_id = ?");
			preparedStatement.setString(1, anaunseo.getAnaunseoName());
			preparedStatement.setInt(2, anaunseo.getAnaunseoAge());
			preparedStatement.setInt(3, anaunseo.getAnaunseoId());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException exception) {
			exception.printStackTrace();
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		}finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
	
	public Anaunseo updateAnaunseoOne(int anaunseoId) {
		Anaunseo anaunseo = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String id = "root";
			String pw = "java0000";
			connection = DriverManager.getConnection(url, id, pw);
			preparedStatement = connection.prepareStatement("SELECT * FROM anaunseo WHERE anaunseo_id = ?");
			preparedStatement.setInt(1, anaunseoId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				anaunseo = new Anaunseo();
				anaunseo.setAnaunseoId(resultSet.getInt("anaunseo_id"));
				anaunseo.setAnaunseoName(resultSet.getString("anaunseo_name"));
				anaunseo.setAnaunseoAge(resultSet.getInt("anaunseo_age"));
			}
			
		}catch(SQLException exception) {
			exception.printStackTrace();
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
		}
		return anaunseo;
	}
	
	public void deleteAnaunseo(int anaunseoId) {
		System.out.println("anunseoId : " + anaunseoId);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String id = "root";
			String pw = "java0000";
			connection = DriverManager.getConnection(url, id, pw);
			preparedStatement = connection.prepareStatement("DELETE FROM anaunseo WHERE anaunseo_id = ?");
			preparedStatement.setInt(1, anaunseoId);
			preparedStatement.toString();
			preparedStatement.executeUpdate();
			
		}catch(SQLException exception) {
			exception.printStackTrace();
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		}finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
	
	public void insertAnaunseo(Anaunseo anaunseo) {
		//�����׽�Ʈ
		System.out.println(anaunseo);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO anaunseo(anaunseo_name, anaunseo_age) VALUES(?, ?)";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, anaunseo.getAnaunseoName());
			preparedStatement.setInt(2, anaunseo.getAnaunseoAge());
			
			preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			System.out.println(exception.getMessage	());
			System.out.println("���ܹ߻�");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage	());
			System.out.println("���ܹ߻�");
		}finally {
			if(preparedStatement != null) {
				try{
					preparedStatement.close();
					preparedStatement = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("���ܹ߻�");
				}
			}
			if(connection != null) {
				try{
					connection.close();
					connection = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("���ܹ߻�");
				}
			}
		}
	}
	
	public ArrayList<Anaunseo> selectAnaunseo() {
		//�Ƴ���� ������ �ִ� ��� ����Ʈ ����
		ArrayList<Anaunseo> list = new ArrayList<Anaunseo>();
		
		try {
			//DB�ε�
			Class.forName("com.mysql.jdbc.Driver");
			//DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			//anaunseo_id as anaunseoId : as�� ���������ϴ�
			//anaunseo_id anaunseoId : ����
			//anaunseo_id "anaunseoId" : ����
			//���� �ּ� �ڵ��  ���� ���̴� ���̴�
			// ���� ���ٷ�....<ok>
			String sql = "SELECT anaunseo_id AS anaunseoId, anaunseo_name AS anaunseoName, anaunseo_age AS anaunseoAge FROM anaunseo ORDER BY anaunseo_id ASC";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Anaunseo anaunseo = new Anaunseo();
				anaunseo.setAnaunseoId( resultSet.getInt("anaunseoId") );
				anaunseo.setAnaunseoName( resultSet.getString("anaunseoName") );
				anaunseo.setAnaunseoAge( resultSet.getInt("anaunseoAge") );
				
				list.add(anaunseo);
			}
			System.out.println("AnaunseoDao.selectAnaunseo()/list.size() : " + list.size());
			
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("ClassNotFoundException ���� �߻�");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("SQLException ���� �߻�");
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("result ��ü �Ҹ�� ���ܹ߻�");
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("preparedStatement ��ü �Ҹ�� ���� �߻�");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("connection ��ü �Ҹ�� ���� �߻�");
				}
			}
		}
		return list;
	}
}