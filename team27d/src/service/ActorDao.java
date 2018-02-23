//team27d [이준희] 
package service;

//<1>DB연결을 위해 Connection을 import 시킨다.
import java.sql.Connection;
//<2>DB를 연결하고 쿼리문을 실행시키기 위해 PreparedStatement을 import 시킨다.
import java.sql.PreparedStatement;
//<3>쿼리문을 실행 시킬 ResultSet을 임포트 한다.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.DriverManager;

public class ActorDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	Actor actor = null;
	
	public Actor updateActorOne(int actorId) {
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
		String dbUser = "root";
		String dbPass = "java0000";
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		String sql = "SELECT * FROM actor WHERE actor_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, actorId);
		result = pstmt.executeQuery();
		
		if (result.next()) {
			actor = new Actor();
			actor.setActorId(result.getInt("actor_id"));
			actor.setActorName(result.getString("actor_name"));
			actor.setActorAge(result.getInt("actor_age"));
		}
		
		pstmt.close();
		conn.close();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}
	
	public void updateActor(Actor actor) {
		System.out.println(actor.toString());
		System.out.println("-------------------");
		try {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
		String dbUser = "root";
		String dbPass = "java0000";
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		String sql = "UPDATE actor SET actor_name=?, actor_age=? WHERE actor_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, actor.getActorName());
		pstmt.setInt(2, actor.getActorAge());
		pstmt.setInt(3, actor.getActorId());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteActor(int actorId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "DELETE FROM actor WHERE actor_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, actorId);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public void insertActor(Actor actor)  {
		// 배우등록을 위한 메서드 실행 Actor(참조형)데이터 타입 변수를 사용하고 변수이름을 actor라고 지었다. 
		// 실제 Actor 클래스에 필드값을 사용하게 된다. 
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "insert into actor(actor_name, actor_age) values(?, ?)";
			// insert 쿼리문을 작성하고 이름과 나이 값만 넣는다. 
			
			pstmt = conn.prepareStatement(sql);
			/*pstmt.setInt(1, actor.getActorId());*/
			pstmt.setString(1, actor.getActorName());
			pstmt.setInt(2, actor.getActorAge());
			pstmt.executeUpdate();
			
			//쿼리문을 준비시키고, ? 에 해당하는 값을 셋팅해준다. 
			// ? 에 해당되는값은 
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Actor> selectActor() {
		ArrayList<Actor> list = new ArrayList<Actor>();
		
		/*<1>DB연결을 위해 Connection 을 초기화 한다.
		 *<2>DB를 연결하고 쿼리문을 실행시키기 위해 PreparedStatement 을 초기화 한다.
		 *<3>쿼리문을 실행 시킬 ResultSet 을 초기화 한다.
		 */		
						
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*드라이버로딩을 위해 Class.forName 을 트라이 캐치문으로 감싼다. 이유) 정보가 틀릴 예외를 잡아준다.
			 *드라이버로딩에 필요한 정보들을 입력해준다.
			 *DB연결에 conn = DriverManager.getConnection 문장도 트라이 케치문으로 감싼다. 이유) 정보가 틀릴 예외를 잡아준다.
			 */
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "select actor_id as actorId, actor_name as actorName, actor_age as actorAge from actor";
			
			// 어떤 쿼리문을 쓸지 문장을 준비한다.
			// 쿼리문을 실행
			pstmt = conn.prepareStatement(sql); 
			result = pstmt.executeQuery();

			while(result.next()) {
				// 만약 예외가 생기지 않고 실행이 된다면 while(result.next()) 문장이 실행 될것이다.
				// 쿼리문장에서 실행된 값이 Actor 클래스에 겟팅되고 셋팅된다. 그 값들이 배열에 담긴다.			
				Actor actor = new Actor();
				int actorId = result.getInt("actorId");
				String actorName = result.getString("actorName");	
				int actorAge = result.getInt("actorAge");
				
				actor.setActorId(actorId);
				actor.setActorName(actorName);
				actor.setActorAge(actorAge);
				list.add(actor);		
			}
			//단위테스트 : 배열이나 기타 리턴값에 값이 잘들어갔는지 확인하기 위한 테스트(입력만 할때 toString을 활용하여 활용할수있다.)
			System.out.println(list.size());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			// 예외 처리
		} finally {
			//예외 이든 아니든 무조건 result pstmt conn 들이 닫힌다. 
			if (result != null) try {result.close();} catch (SQLException ex) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null) try {conn.close();} catch (SQLException ex) {}
		}			
		return list;
	}	
}
