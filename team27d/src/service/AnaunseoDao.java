// team27d [이춘림]
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
	 * updateAnaunseo() 메서드는 레퍼런스 타입인 Anaunseo 타입의 객체참조변수를 매개변수로 받는다.
	 * 이 때, Anaunseo 타입의 객체참조변수에는 Anaunseo 객체의 주소값이 저장되어 있어야 하며,
	 * Anaunseo 객체의 맴버 변수인 anaunseoId, anaunseoName, anaunseoAge에는 UPDATE SQL문을 통해 변경시키고자 하는 값들이 updateAnaunseo() 메서드 호출 이전에 세팅되어 있어야 한다. 
	 * 
	 * updateAnaunseo() 메서드의 매개변수로 들어온 객체참조변수로 참조할 수 있는 Anaunseo 객체의 맴버변수 anaunseoId의 값을 이용하여,
	 * 
	 * anaunseo 테이블 안에서 속성명 anaunseo_id에 해당되는 값들 중에  anaunseoId에 저장되어있는 값과 일치하는 부분의 레코드에서(ID값은 Primary Key이므로 유일성이 보장된다. 따라서 하나의 레코드를 가리킨다.)
	 * 속성명이  anaunseo_name, anaunseo_age인 부분에 해당되는 값을  Anaunseo 객체의 맴버변수  anaunseoName, anaunseoAge의 값으로 바꾸어 준다.(적절히 세팅된 UPDATE SQL문과 executeUpdate() 메서드 실행을 통해서.)
	 * 
	 * updateAnaunseo() 메서드는 리턴형이 void형이므로, DB UPDATE가 완료된 후 리턴하는 값 없이 메서드가 종료되게 된다.
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
		 * Exception 발생 여부와 상관없이 finally문은 실행이된다.
		 * Exception 발생 여부와 상관없이 sql관련 객체의 소멸은 해주어야 하므로 finally문에 close()메서드를 작성하는것이 바람직하다.
		 *
		 * 사용하였던(sql관련 객체 : Connection, PreparedStatement, ResultSet 등) sql 자원(객체)을 반환(소멸)해 주어야
		 * 메모리 릭(Memory Leak) 현상을 막을 수 있다.
		 * 
		 * java에는 가비지 컬렉터(garbage collector)가 있어 사용하지 않는 자원(객체)을 주기적으로 반환(소멸)해 주지만,
		 * sql관련 객체는 예외에 해당되기 때문에 프로그래머가 직접 close()메서드를 통해 자원을 반환시켜주어야 한다.
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
	 * updateAnaunseoForm.jsp에서 <form>태그 하위의 <input>테그의 value 부분에  Anaunseo객체를 통해 값을 넣어주려면,
	 * 우선, Anaunseo객체가 있어야 하고 또, Anaunseo객체의 맴버변수인 anaunseoId, anaunseoName, anaunseoAge의 값을  적절히 세팅을 해주어야 한다.
	 * 
	 * updateAnaunseoOne() 메서드는 updateAnaunseoForm.jsp 에서 필요한  Anaunseo객체를 생성하고 적절히 값을 세팅하고 세팅된 Anaunseo객체의 주소를 리턴하는 역할을 한다.
	 * 
	 * updateAnaunseoOne() 메서드는,
	 * SELECT문을 통해 anaunseo 테이블의 anaunseo_id 속성값이 매개변수로 들어온 int타입의 ID값과 일치하는, anaunseo_id, anaunseo_name, anaunseo_age 속성이 담긴 레코드를 가져온후,
	 * 
	 * next()메서드를 통해 SELECT문 결과로 나온 레코드를 커서가 가리키게 한다.(next()메서드를 사용해야 커서가 SELECT문 결과로 나온 첫번째 레코드를 가리킬 수 있다.) 
	 * 가리키고 있는 레코드의 속성명인 anaunseo_id, anaunseo_name, anaunseo_age에 해당되는 값을  생성해 놓은 Anaunseo 객체에 세팅한다.
	 * 
	 * Anaunseo 객체의 세팅을 완료하고, 
	 * 세팅이 완료된 Anaunseo 객체의 주소값을 리턴시킨다.
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
	 * deleteAnaunseo() 메서드는 매개변수로 int타입의 값을 받는다.
	 * deleteAnaunseo() 메서드를 호출하여 매개변수를 넘길때, 매개변수에 넣어야 될 값은 int타입의 삭제하고자 하는  ID값이어야 한다.
	 * 
	 * 세팅이 완료된 DELETE SQL문과 executeUpdate()메서드 호출을 통하여,
	 * anaunseo테이블에 있는 속성명 anaunseo_id 속성에 해당되는 값과 매개변수로 넘어온 id값이 동일한 부분에 해당되는 레코드를 삭제한다.(매개변수로 넘어온 id값에 해당되는 레코드를 삭제한다.)
	 * 
	 * deleteAnaunseo() 메서드는 리턴형이 void이므로 매서드 실행결과로 리턴되는 값이 없다.
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
	 * insertAnaunseo() 메서드는 매개변수로 Anaunseo타입의 객체참조변수를 받게 되는데
	 * 이때, Anaunseo타입의 객체참조변수에는 Anaunseo 객체의 주소가 담겨져 있어야 하며, Anaunseo 객체의 맴버변수 anaunseoName, anaunseoAge에 적절한 값이 사전에 세팅되어 있어야 한다.
	 * 
	 * Anaunseo 객체의 맴버변수 anaunseoName, anaunseoAge값을 INSERT SQL문에 세팅하여 
	 * executeUpdate()메서드를 호출하면, 세팅이 완료된 INSERT구문에 따라  DB에 값이 들어가게 된다.
	 * 
	 * insertAnaunseo() 메서드는 리턴형이 void이므로 메서드 실행결과로 리턴하는 값이 없다.
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
	 * SELECT문을 통해 anaunseo 테이블에서   anaunseo_id, anaunseo_name, anaunseo_age 속성이 담긴 레코드들을 모두 가져온후,
	 * 
	 * while문의 돌아오는 주기마다 next()메서드를 통해 다음다음의 레코드를 가리키면서(최초로 next()메서드 사용시 가장 상단의 레코드를 가리킨다.) 
	 * 가리키고 있는 레코드의 id, name, age에 해당되는 값을 while문 주기마다 생성되는  Anaunseo 객체에 세팅한다.
	 * 그리고 세팅된 Anaunseo 객체를 ArrayList에 Add()메서드를 사용하여 넣는다.
	 * 위의 상황을 while문이 끝날때까지 반복하며 next()메서드를 통해 더 이상 가리킬 레코드가 없을 때까지 반복한다.
	 * 
	 * 더 이상 가리킬 레코드가 없다면 next()메서드는 false를 반환하며 while문이 종료된다. 
	 * 
	 * 세팅된 Anaunseo 객체들의 주소값들은 ArrayList<Anaunseo> 객체에 저장되어 있고,
	 * ArrayList<Anaunseo> 객체의 주소값은 list라고 명명한 객체참조변수에 저장되어 있다.
	 * 
	 * selectAnaunseo() 메서드는 레퍼런스 타입인 ArrayList<Anaunseo>타입의 객체참조변수 list에 담겨있는  ArrayList<Anaunseo> 객체의 주소(어레이 리스트의 주소)를 리턴하게 된다.
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
				SQL문 속성명 별명 붙이기
				anaunseo_id as anaunseoId : as는 생략가능하다
				anaunseo_id anaunseoId : 가능
				anaunseo_id "anaunseoId" : 가능
				위의 주석 코드는  별명 붙이는 것이다
				쿼리 한줄로 하기
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