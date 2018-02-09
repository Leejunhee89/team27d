package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.DriverManager;

public class ActorDao {
	
	public ArrayList<Actor> selectActor() {
		ArrayList<Actor> arrayActor = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
	
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			pstmt = conn.prepareStatement("select actor_id, actor_name, actor_age from actor"); 
			result = pstmt.executeQuery();
			
			arrayActor = new ArrayList<Actor>();
			while(result.next()) {
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
		} finally {
			if (result != null) try {result.close();} catch (SQLException ex) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null) try {conn.close();} catch (SQLException ex) {}
		}
		
		 
		
		
		return arrayActor;
	}	
}
