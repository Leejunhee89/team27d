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
	
	
	public ArrayList<Actor> selectActor() {
		ArrayList<Actor> arrayActor = null;
		
		//<1>DB연결을 위해 Connection 을 초기화 한다.
		Connection conn = null;
		//<2>DB를 연결하고 쿼리문을 실행시키기 위해 PreparedStatement 을 초기화 한다.
		PreparedStatement pstmt = null;
		//<3>쿼리문을 실행 시킬 ResultSet 을 초기화 한다.
		ResultSet result = null;
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//드라이버로딩을 위해 Class.forName 을 트라이 캐치문으로 감싼다. 이유) 정보가 틀릴 예외를 잡아준다.
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			// 드라이버로딩에 필요한 정보들을 입력해준다.
			// DB연결에 conn = DriverManager.getConnection 문장도 트라이 케치문으로 감싼다. 이유) 정보가 틀릴 예외를 잡아준다.
			
			pstmt = conn.prepareStatement("select actor_id, actor_name, actor_age from actor"); 
			// 어떤 쿼리문을 쓸지 문장을 준비한다.
			result = pstmt.executeQuery();
			// 쿼리문을 실행
			
			arrayActor = new ArrayList<Actor>();
			while(result.next()) {
				// 만약 예외가 생기지 않고 실행이 된다면 while(result.next()) 문장이 실행 될것이다.
				// 쿼리문장에서 실행된 값이 Actor 클래스에 겟팅되고 셋팅된다. 그 값들이 배열에 담긴다.
				
				Actor actor = new Actor();
				String actorId = result.getString("actor_id");
				String actorName = result.getString("actor_name");	
				String actorAge = result.getString("actor_age");
				
				actor.setActorId(Integer.parseInt(actorId));
				actor.setActorName(actorName);
				actor.setActorAge(Integer.parseInt(actorAge));
				arrayActor.add(actor);
				
								
						
			}
		
		
		
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
				
		return arrayActor;
	}	
}
