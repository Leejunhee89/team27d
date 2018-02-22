//team27d [������] 
package service;

//<1>DB������ ���� Connection�� import ��Ų��.
import java.sql.Connection;
//<2>DB�� �����ϰ� �������� �����Ű�� ���� PreparedStatement�� import ��Ų��.
import java.sql.PreparedStatement;
//<3>�������� ���� ��ų ResultSet�� ����Ʈ �Ѵ�.
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
				
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "insert into actor(actor_name, actor_age) values(?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			/*pstmt.setInt(1, actor.getActorId());*/
			pstmt.setString(1, actor.getActorName());
			pstmt.setInt(2, actor.getActorAge());
						
			pstmt.executeUpdate();
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
		
		/*<1>DB������ ���� Connection �� �ʱ�ȭ �Ѵ�.
		 *<2>DB�� �����ϰ� �������� �����Ű�� ���� PreparedStatement �� �ʱ�ȭ �Ѵ�.
		 *<3>�������� ���� ��ų ResultSet �� �ʱ�ȭ �Ѵ�.
		 */		
						
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*����̹��ε��� ���� Class.forName �� Ʈ���� ĳġ������ ���Ѵ�. ����) ������ Ʋ�� ���ܸ� ����ش�.
			 *����̹��ε��� �ʿ��� �������� �Է����ش�.
			 *DB���ῡ conn = DriverManager.getConnection ���嵵 Ʈ���� ��ġ������ ���Ѵ�. ����) ������ Ʋ�� ���ܸ� ����ش�.
			 */
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "select actor_id as actorId, actor_name as actorName, actor_age as actorAge from actor";
			
			// � �������� ���� ������ �غ��Ѵ�.
			// �������� ����
			pstmt = conn.prepareStatement(sql); 
			result = pstmt.executeQuery();

			while(result.next()) {
				// ���� ���ܰ� ������ �ʰ� ������ �ȴٸ� while(result.next()) ������ ���� �ɰ��̴�.
				// �������忡�� ����� ���� Actor Ŭ������ ���õǰ� ���õȴ�. �� ������ �迭�� ����.			
				Actor actor = new Actor();
				int actorId = result.getInt("actorId");
				String actorName = result.getString("actorName");	
				int actorAge = result.getInt("actorAge");
				
				actor.setActorId(actorId);
				actor.setActorName(actorName);
				actor.setActorAge(actorAge);
				list.add(actor);		
			}
			//�����׽�Ʈ : �迭�̳� ��Ÿ ���ϰ��� ���� �ߵ����� Ȯ���ϱ� ���� �׽�Ʈ(�Է¸� �Ҷ� toString�� Ȱ���Ͽ� Ȱ���Ҽ��ִ�.)
			System.out.println(list.size());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			// ���� ó��
		} finally {
			//���� �̵� �ƴϵ� ������ result pstmt conn ���� ������. 
			if (result != null) try {result.close();} catch (SQLException ex) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null) try {conn.close();} catch (SQLException ex) {}
		}			
		return list;
	}	
}
