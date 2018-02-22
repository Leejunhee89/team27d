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
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	Actress actress = null;
	
	public Actress updateSelectActress(int actressId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "SELECT * FROM actress WHERE actress_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, actressId);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				actress = new Actress();
				actress.setActressId(result.getInt("actress_id"));
				actress.setActressName(result.getString("actress_name"));
				actress.setActressAge(result.getInt("actress_age"));
			}
			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actress;
	}
	
	public void updateActress (Actress actress) {
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
		
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "UPDATE actress SET actress_name=?, actress_age=? WHERE actress_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, actress.getActressName());
			pstmt.setInt(2, actress.getActressAge());
			pstmt.setInt(3, actress.getActressId());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
					
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public void DeleteActress(int actressId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "DELETE FROM actress WHERE actress_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, actressId);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void InsertActress(Actress actress)  {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "insert into actress(actress_name, actress_age) values(?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			/*pstmt.setInt(1, actress.getActressId());*/
			pstmt.setString(1, actress.getActressName());
			pstmt.setInt(2, actress.getActressAge());
						
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
			
	public ArrayList<Actress> selectActress() {
		ArrayList<Actress> list = new ArrayList<Actress>();
		/*<1>DB������ ���� Connection �� �ʱ�ȭ �Ѵ�.
		 *<2>DB�� �����ϰ� �������� �����Ű�� ���� PreparedStatement �� �ʱ�ȭ �Ѵ�.
		 *<3>�������� ���� ��ų ResultSet �� �ʱ�ȭ �Ѵ�.
		 */		
					
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
