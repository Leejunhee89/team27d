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
	
	
	public ArrayList<Actor> selectActor() {
		ArrayList<Actor> arrayActor = null;
		
		//<1>DB������ ���� Connection �� �ʱ�ȭ �Ѵ�.
		Connection conn = null;
		//<2>DB�� �����ϰ� �������� �����Ű�� ���� PreparedStatement �� �ʱ�ȭ �Ѵ�.
		PreparedStatement pstmt = null;
		//<3>�������� ���� ��ų ResultSet �� �ʱ�ȭ �Ѵ�.
		ResultSet result = null;
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//����̹��ε��� ���� Class.forName �� Ʈ���� ĳġ������ ���Ѵ�. ����) ������ Ʋ�� ���ܸ� ����ش�.
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			// ����̹��ε��� �ʿ��� �������� �Է����ش�.
			// DB���ῡ conn = DriverManager.getConnection ���嵵 Ʈ���� ��ġ������ ���Ѵ�. ����) ������ Ʋ�� ���ܸ� ����ش�.
			
			pstmt = conn.prepareStatement("select actor_id as actorId, actor_name as actorName, actor_age as actorAge from actor"); 
			// � �������� ���� ������ �غ��Ѵ�.
			result = pstmt.executeQuery();
			// �������� ����
			
			arrayActor = new ArrayList<Actor>();
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
				arrayActor.add(actor);
				
								
						
			}
		
		
		
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
				
		return arrayActor;
	}	
}
