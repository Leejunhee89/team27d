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
		//단위테스트
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
			System.out.println("예외발생");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage	());
			System.out.println("예외발생");
		}finally {
			if(preparedStatement != null) {
				try{
					preparedStatement.close();
					preparedStatement = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("예외발생");
				}
			}
			if(connection != null) {
				try{
					connection.close();
					connection = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("예외발생");
				}
			}
		}
	}
	
	public ArrayList<Anaunseo> selectAnaunseo() {
		//아나운서를 넣을수 있는 어레이 리스트 생성
		ArrayList<Anaunseo> list = new ArrayList<Anaunseo>();
		
		try {
			//DB로딩
			Class.forName("com.mysql.jdbc.Driver");
			//DB연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			//anaunseo_id as anaunseoId : as는 생략가능하다
			//anaunseo_id anaunseoId : 가능
			//anaunseo_id "anaunseoId" : 가능
			//위의 주석 코드는  별명 붙이는 것이다
			// 쿼리 한줄로....<ok>
			String sql = "SELECT anaunseo_id AS anaunseoId, anaunseo_name AS anaunseoName, anaunseo_age AS anaunseoAge FROM anaunseo ORDER BY anaunseo_id ASC";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//쿼리 준비
			preparedStatement = connection.prepareStatement(sql);
			//쿼리 실행후 레코드 ResultSet rs에 저장
			resultSet = preparedStatement.executeQuery();
			//rs에  레코드 없을때까지 DB에 저장된 값 ana에 세팅 후 세팅된 ana를 어레이리스트에 저장
			while(resultSet.next()) {
				Anaunseo anaunseo = new Anaunseo();
				anaunseo.setAnaunseoId( resultSet.getInt("anaunseoId") );
				anaunseo.setAnaunseoName( resultSet.getString("anaunseoName") );
				anaunseo.setAnaunseoAge( resultSet.getInt("anaunseoAge") );
				
				list.add(anaunseo);
			}
			//단위테스트 코드
			System.out.println(list.size() + "<=== 단위테스트 코드");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println(e.getMessage	());
			System.out.println("예외발생");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage	());
			System.out.println("예외발생");
		}finally {
			//DB에 연결하여 DB에서 필요한 정보를 모두  Anaunseo객체 마다에 세팅한 후,
			//세팅이 끝난 Anaunseo객체를 ArrayList<Anaunseo> list에 넣어주었으므로 
			//DB단위에서 할 일은 모두 끝났다. 따라서 DB단위에서 사용된 개체를 모두 반환시켜주어야한다.
			// Connection, PreparedStatement, ResultSet 객체순으로 생성되었으므로 
			// close()메서드를 통한 메모리 반환 순서는 ResultSet, PreparedStatement, Connection 순서가 되어야 한다.
			// close()메서드 뒤에 rs, pstmt, conn 의 객체참조변수를 null값으로 초기화하는 이유는
			// 혹시나 모를 잘못된 주소참조를 방지하기 위하여 null값으로 초기화시켜 두었다.
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
		//세팅된 어레이 리스트의 주소를 리턴
		return list;
	}
}