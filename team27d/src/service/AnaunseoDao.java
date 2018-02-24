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
	
	/*
	 * updateAnaunseo() �޼���� ���۷��� Ÿ���� Anaunseo Ÿ���� ��ü���������� �Ű������� �޴´�.
	 * �� ��, Anaunseo Ÿ���� ��ü������������ Anaunseo ��ü�� �ּҰ��� ����Ǿ� �־�� �ϸ�,
	 * Anaunseo ��ü�� �ɹ� ������ anaunseoId, anaunseoName, anaunseoAge���� UPDATE SQL���� ���� �����Ű���� �ϴ� ������ updateAnaunseo() �޼��� ȣ�� ������ ���õǾ� �־�� �Ѵ�. 
	 * 
	 * updateAnaunseo() �޼����� �Ű������� ���� ��ü���������� ������ �� �ִ� Anaunseo ��ü�� �ɹ����� anaunseoId�� ���� �̿��Ͽ�,
	 * 
	 * anaunseo ���̺� �ȿ��� �Ӽ��� anaunseo_id�� �ش�Ǵ� ���� �߿�  anaunseoId�� ����Ǿ��ִ� ���� ��ġ�ϴ� �κ��� ���ڵ忡��(ID���� Primary Key�̹Ƿ� ���ϼ��� ����ȴ�. ���� �ϳ��� ���ڵ带 ����Ų��.)
	 * �Ӽ�����  anaunseo_name, anaunseo_age�� �κп� �ش�Ǵ� ����  Anaunseo ��ü�� �ɹ�����  anaunseoName, anaunseoAge�� ������ �ٲپ� �ش�.(������ ���õ� UPDATE SQL���� executeUpdate() �޼��� ������ ���ؼ�.)
	 * 
	 * updateAnaunseo() �޼���� �������� void���̹Ƿ�, DB UPDATE�� �Ϸ�� �� �����ϴ� �� ���� �޼��尡 ����ǰ� �ȴ�.
	 * 
	 * */	
	public void updateAnaunseo(Anaunseo anaunseo) {
		System.out.println("@@@@@ Anaunseo updateAnaunseoOne(int anaunseoId) @@@@@");
		System.out.println("parameter anaunseo : " + anaunseo);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String id = "root";
			String pw = "java0000";
			String sql = "UPDATE anaunseo SET anaunseo_name = ?, anaunseo_age = ? WHERE anaunseo_id = ?";
			
			connection = DriverManager.getConnection(url, id, pw);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, anaunseo.getAnaunseoName());
			preparedStatement.setInt(2, anaunseo.getAnaunseoAge());
			preparedStatement.setInt(3, anaunseo.getAnaunseoId());
			
			preparedStatement.executeUpdate();
			
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("AnaunseoDao.updateAnaunseo() / SQLException");
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("AnaunseoDao.updateAnaunseo() / ClassNotFoundException");
		/*
		 * Exception �߻� ���ο� ������� finally���� �����̵ȴ�.
		 * Exception �߻� ���ο� ������� sql���� ��ü�� �Ҹ��� ���־�� �ϹǷ� finally���� close()�޼��带 �ۼ��ϴ°��� �ٶ����ϴ�.
		 *
		 * ����Ͽ���(sql���� ��ü : Connection, PreparedStatement, ResultSet ��) sql �ڿ�(��ü)�� ��ȯ(�Ҹ�)�� �־��
		 * �޸� ��(Memory Leak) ������ ���� �� �ִ�.
		 * 
		 * java���� ������ �÷���(garbage collector)�� �־� ������� �ʴ� �ڿ�(��ü)�� �ֱ������� ��ȯ(�Ҹ�)�� ������,
		 * sql���� ��ü�� ���ܿ� �ش�Ǳ� ������ ���α׷��Ӱ� ���� close()�޼��带 ���� �ڿ��� ��ȯ�����־�� �Ѵ�.
		 * 
		 * */
		}finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.updateAnaunseo() / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.updateAnaunseo() / connection.close() / SQLException");
				}
			}
		}
		System.out.println("@@@@@@@@@@");
	}
	
	/*
	 * updateAnaunseoForm.jsp���� <form>�±� ������ <input>�ױ��� value �κп�  Anaunseo��ü�� ���� ���� �־��ַ���,
	 * �켱, Anaunseo��ü�� �־�� �ϰ� ��, Anaunseo��ü�� �ɹ������� anaunseoId, anaunseoName, anaunseoAge�� ����  ������ ������ ���־�� �Ѵ�.
	 * 
	 * updateAnaunseoOne() �޼���� updateAnaunseoForm.jsp ���� �ʿ���  Anaunseo��ü�� �����ϰ� ������ ���� �����ϰ� ���õ� Anaunseo��ü�� �ּҸ� �����ϴ� ������ �Ѵ�.
	 * 
	 * updateAnaunseoOne() �޼����,
	 * SELECT���� ���� anaunseo ���̺��� anaunseo_id �Ӽ����� �Ű������� ���� intŸ���� ID���� ��ġ�ϴ�, anaunseo_id, anaunseo_name, anaunseo_age �Ӽ��� ��� ���ڵ带 ��������,
	 * 
	 * next()�޼��带 ���� SELECT�� ����� ���� ���ڵ带 Ŀ���� ����Ű�� �Ѵ�.(next()�޼��带 ����ؾ� Ŀ���� SELECT�� ����� ���� ù��° ���ڵ带 ����ų �� �ִ�.) 
	 * ����Ű�� �ִ� ���ڵ��� �Ӽ����� anaunseo_id, anaunseo_name, anaunseo_age�� �ش�Ǵ� ����  ������ ���� Anaunseo ��ü�� �����Ѵ�.
	 * 
	 * Anaunseo ��ü�� ������ �Ϸ��ϰ�, 
	 * ������ �Ϸ�� Anaunseo ��ü�� �ּҰ��� ���Ͻ�Ų��.
	 * 
	 */
	public Anaunseo updateAnaunseoOne(int anaunseoId) {
		System.out.println("@@@@@ Anaunseo updateAnaunseoOne(int anaunseoId) @@@@@");
		System.out.println("parameter anaunseoId : " + anaunseoId);
		Anaunseo anaunseo = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String id = "root";
			String pw = "java0000";
			String sql = "SELECT anaunseo_id AS anaunseoId, anaunseo_name AS anaunseoName, anaunseo_age AS anaunseoAge FROM anaunseo WHERE anaunseo_id = ? ORDER BY anaunseo_id ASC";
			
			connection = DriverManager.getConnection(url, id, pw);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, anaunseoId);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				anaunseo = new Anaunseo();
				anaunseo.setAnaunseoId(resultSet.getInt("anaunseoId"));
				anaunseo.setAnaunseoName(resultSet.getString("anaunseoName"));
				anaunseo.setAnaunseoAge(resultSet.getInt("anaunseoAge"));
			}
			
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("AnaunseoDao.updateAnaunseoOne() / SQLException");
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("AnaunseoDao.updateAnaunseoOne() / ClassNotFoundException");
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.updateAnaunseoOne() / resultSet.close() / SQLException");
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.updateAnaunseoOne() / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.updateAnaunseoOne() / connection.close() / SQLException");
				}
			}
		}
		System.out.println("return anaunseo : " + anaunseo);
		System.out.println("@@@@@@@@@@");
		return anaunseo;
	}
	
	/*
	 * deleteAnaunseo() �޼���� �Ű������� intŸ���� ���� �޴´�.
	 * deleteAnaunseo() �޼��带 ȣ���Ͽ� �Ű������� �ѱ涧, �Ű������� �־�� �� ���� intŸ���� �����ϰ��� �ϴ�  ID���̾�� �Ѵ�.
	 * 
	 * ������ �Ϸ�� DELETE SQL���� executeUpdate()�޼��� ȣ���� ���Ͽ�,
	 * anaunseo���̺� �ִ� �Ӽ��� anaunseo_id �Ӽ��� �ش�Ǵ� ���� �Ű������� �Ѿ�� id���� ������ �κп� �ش�Ǵ� ���ڵ带 �����Ѵ�.(�Ű������� �Ѿ�� id���� �ش�Ǵ� ���ڵ带 �����Ѵ�.)
	 * 
	 * deleteAnaunseo() �޼���� �������� void�̹Ƿ� �ż��� �������� ���ϵǴ� ���� ����.
	 */
	public void deleteAnaunseo(int anaunseoId) {
		System.out.println("@@@@@ void AnaunseoDao.deleteAnaunseo(int anaunseoId) @@@@@");
		System.out.println("parameter anunseoId : " + anaunseoId);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String id = "root";
			String pw = "java0000";
			String sql = "DELETE FROM anaunseo WHERE anaunseo_id = ?";
			
			connection = DriverManager.getConnection(url, id, pw);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, anaunseoId);

			preparedStatement.executeUpdate();
			
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("AnaunseoDao.deleteAnaunseo() / SQLException");
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("AnaunseoDao.deleteAnaunseo() / ClassNotFoundException");
		}finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.deleteAnaunseo() / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.deleteAnaunseo() / connection.close() / SQLException");
					
				}
			}
		}
		System.out.println("@@@@@@@@@@");
	}
	
	/*
	 * insertAnaunseo() �޼���� �Ű������� AnaunseoŸ���� ��ü���������� �ް� �Ǵµ�
	 * �̶�, AnaunseoŸ���� ��ü������������ Anaunseo ��ü�� �ּҰ� ����� �־�� �ϸ�, Anaunseo ��ü�� �ɹ����� anaunseoName, anaunseoAge�� ������ ���� ������ ���õǾ� �־�� �Ѵ�.
	 * 
	 * Anaunseo ��ü�� �ɹ����� anaunseoName, anaunseoAge���� INSERT SQL���� �����Ͽ� 
	 * executeUpdate()�޼��带 ȣ���ϸ�, ������ �Ϸ�� INSERT������ ����  DB�� ���� ���� �ȴ�.
	 * 
	 * insertAnaunseo() �޼���� �������� void�̹Ƿ� �޼��� �������� �����ϴ� ���� ����.
	 */
	public void insertAnaunseo(Anaunseo anaunseo) {
		System.out.println("@@@@@ void AnaunseoDao.insertAnaunseo(int anaunseoId) @@@@@");
		System.out.println("parameter anaunseo : " + anaunseo);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String id = "root";
			String pw = "java0000";
			String sql = "INSERT INTO anaunseo(anaunseo_name, anaunseo_age) VALUES(?, ?)";
			
			connection = DriverManager.getConnection(url, id, pw);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, anaunseo.getAnaunseoName());
			preparedStatement.setInt(2, anaunseo.getAnaunseoAge());

			preparedStatement.executeUpdate();
			
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			System.out.println(exception.getMessage	());
			System.out.println("AnaunseoDao.insertAnaunseo() / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage	());
			System.out.println("AnaunseoDao.insertAnaunseo() / SQLException");
		}finally {
			if(preparedStatement != null) {
				try{
					preparedStatement.close();
					preparedStatement = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.insertAnaunseo() / preparedStatement.close() / SQLExcpetion");
				}
			}
			if(connection != null) {
				try{
					connection.close();
					connection = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.insertAnaunseo() / connection.close() / SQLException");
				}
			}
		}
		System.out.println("@@@@@@@@@@");
	}
	
	/*
	 * SELECT���� ���� anaunseo ���̺���   anaunseo_id, anaunseo_name, anaunseo_age �Ӽ��� ��� ���ڵ���� ��� ��������,
	 * 
	 * while���� ���ƿ��� �ֱ⸶�� next()�޼��带 ���� ���������� ���ڵ带 ����Ű�鼭(���ʷ� next()�޼��� ���� ���� ����� ���ڵ带 ����Ų��.) 
	 * ����Ű�� �ִ� ���ڵ��� id, name, age�� �ش�Ǵ� ���� while�� �ֱ⸶�� �����Ǵ�  Anaunseo ��ü�� �����Ѵ�.
	 * �׸��� ���õ� Anaunseo ��ü�� ArrayList�� Add()�޼��带 ����Ͽ� �ִ´�.
	 * ���� ��Ȳ�� while���� ���������� �ݺ��ϸ� next()�޼��带 ���� �� �̻� ����ų ���ڵ尡 ���� ������ �ݺ��Ѵ�.
	 * 
	 * �� �̻� ����ų ���ڵ尡 ���ٸ� next()�޼���� false�� ��ȯ�ϸ� while���� ����ȴ�. 
	 * 
	 * ���õ� Anaunseo ��ü���� �ּҰ����� ArrayList<Anaunseo> ��ü�� ����Ǿ� �ְ�,
	 * ArrayList<Anaunseo> ��ü�� �ּҰ��� list��� ����� ��ü���������� ����Ǿ� �ִ�.
	 * 
	 * selectAnaunseo() �޼���� ���۷��� Ÿ���� ArrayList<Anaunseo>Ÿ���� ��ü�������� list�� ����ִ�  ArrayList<Anaunseo> ��ü�� �ּ�(��� ����Ʈ�� �ּ�)�� �����ϰ� �ȴ�.
	 *   
	 * */
	public ArrayList<Anaunseo> selectAnaunseo() {
		System.out.println("@@@@@ ArrayList<Anaunseo> selectAnaunseo() @@@@@");
		ArrayList<Anaunseo> list = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			/*
				SQL�� �Ӽ��� ���� ���̱�
				anaunseo_id as anaunseoId : as�� ���������ϴ�
				anaunseo_id anaunseoId : ����
				anaunseo_id "anaunseoId" : ����
				���� �ּ� �ڵ��  ���� ���̴� ���̴�
				���� ���ٷ� �ϱ�
			*/
			String sql = "SELECT anaunseo_id AS anaunseoId, anaunseo_name AS anaunseoName, anaunseo_age AS anaunseoAge FROM anaunseo ORDER BY anaunseo_id ASC";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			
			list = new ArrayList<Anaunseo>();
			while(resultSet.next()) {
				Anaunseo anaunseo = new Anaunseo();
				anaunseo.setAnaunseoId(resultSet.getInt("anaunseoId"));
				anaunseo.setAnaunseoName(resultSet.getString("anaunseoName"));
				anaunseo.setAnaunseoAge(resultSet.getInt("anaunseoAge"));
				
				list.add(anaunseo);
			}
			System.out.println("list.size() : " + list.size());
			
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("AnaunseoDao.selectAnaunseo() / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("AnaunseoDao.selectAnaunseo() / SQLException");
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.selectAnaunseo() / resultSet.close() / SQLException");
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.selectAnaunseo() / preparedStatement.close() / SQLException");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("AnaunseoDao.selectAnaunseo() / connection.close() / SQLException");
				}
			}
		}
		System.out.println("return list : " + list);
		System.out.println("@@@@@@@@@@");
		return list;
	}
}