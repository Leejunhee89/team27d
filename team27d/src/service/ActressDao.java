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

public class ActressDao {
	
	
	public ArrayList<Actress> selectActress() {
		ArrayList<Actress> list = new ArrayList<Actress>();
		/*<1>DB������ ���� Connection �� �ʱ�ȭ �Ѵ�.
		 *<2>DB�� �����ϰ� �������� �����Ű�� ���� PreparedStatement �� �ʱ�ȭ �Ѵ�.
		 *<3>�������� ���� ��ų ResultSet �� �ʱ�ȭ �Ѵ�.
		 */		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
				
		try {
			/*����̹��ε��� ���� Class.forName �� Ʈ���� ĳġ������ ���Ѵ�. ����) ������ Ʋ�� ���ܸ� ����ش�.
			 *����̹��ε��� �ʿ��� �������� �Է����ش�.
			 *DB���ῡ conn = DriverManager.getConnection ���嵵 Ʈ���� ��ġ������ ���Ѵ�. ����) ������ Ʋ�� ���ܸ� ����ش�.
			 */
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "select actress_id as actressId, actress_name as actressName, actress_age as actressAge from actress";
					
			// � �������� ���� ������ �غ��Ѵ�.
			// �������� ����			
			pstmt = conn.prepareStatement(sql); 
			result = pstmt.executeQuery();
			
			
			while(result.next()) {
				// ���� ���ܰ� ������ �ʰ� ������ �ȴٸ� while(result.next()) ������ ���� �ɰ��̴�.
				// �������忡�� ����� ���� Actor Ŭ������ ���õǰ� ���õȴ�. �� ������ �迭�� ����.
				
				Actress actress = new Actress();
				int actressId = result.getInt("actressId");
				String actressName = result.getString("actressName");	
				int actressAge = result.getInt("actressAge");
				
				actress.setActressId(actressId);
				actress.setActressName(actressName);
				actress.setActressAge(actressAge);
				list.add(actress);
				
								
						
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
