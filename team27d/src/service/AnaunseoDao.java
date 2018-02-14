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
	
	public int insertAnaunseo(Anaunseo anaunseo) throws ClassNotFoundException, SQLException {
	
		//�����׽�Ʈ
		System.out.println(anaunseo);
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int isUpdate = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO anaunseo VALUES(?, ?, ?)";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, anaunseo.getAnaunseoId());
			prepareStatement.setString(2, anaunseo.getAnaunseoName());
			prepareStatement.setInt(3, anaunseo.getAnaunseoAge());
			
			isUpdate = prepareStatement.executeUpdate();
			
		} catch(ClassNotFoundException exception){
			exception.printStackTrace();
			System.out.println(exception.getMessage	());
			System.out.println("���ܹ߻�");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage	());
			System.out.println("���ܹ߻�");
		}finally {
			if(prepareStatement != null) {
				try{
					prepareStatement.close();
					prepareStatement = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("���ܹ߻�");
				}
			}
			if(connection != null) {
				try{
					connection.close();
					connection = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("���ܹ߻�");
				}
			}
		}
		return isUpdate;
	}
	
	public ArrayList<Anaunseo> selectActorList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//�Ƴ���� ������ �ִ� ��� ����Ʈ ����
		ArrayList<Anaunseo> list = new ArrayList<Anaunseo>();
		
		try {
			//DB�ε�
			Class.forName("com.mysql.jdbc.Driver");
			//DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			//anaunseo_id as anaunseoId : as�� ���������ϴ�
			//anaunseo_id anaunseoId : ����
			//anaunseo_id "anaunseoId" : ����
			//���� �ּ� �ڵ��  ���� ���̴� ���̴�
			// ���� ���ٷ�....<ok>
			String sql = "SELECT anaunseo_id AS anaunseoId, anaunseo_name AS anaunseoName, anaunseo_age AS anaunseoAge FROM anaunseo ORDER BY anaunseo_id ASC";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//���� �غ�
			pstmt = conn.prepareStatement(sql);
			//���� ������ ���ڵ� ResultSet rs�� ����
			rs = pstmt.executeQuery();
			//rs��  ���ڵ� ���������� DB�� ����� �� ana�� ���� �� ���õ� ana�� ��̸���Ʈ�� ����
			while(rs.next()) {
				Anaunseo anaunseo = new Anaunseo();
				anaunseo.setAnaunseoId( rs.getInt("anaunseoId") );
				anaunseo.setAnaunseoName( rs.getString("anaunseoName") );
				anaunseo.setAnaunseoAge( rs.getInt("anaunseoAge") );
				
				list.add(anaunseo);
			}
			//�����׽�Ʈ �ڵ�
			System.out.println(list.size() + "<=== �����׽�Ʈ �ڵ�");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println(e.getMessage	());
			System.out.println("���ܹ߻�");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage	());
			System.out.println("���ܹ߻�");
		}finally {
			//DB�� �����Ͽ� DB���� �ʿ��� ������ ���  Anaunseo��ü ���ٿ� ������ ��,
			//������ ���� Anaunseo��ü�� ArrayList<Anaunseo> list�� �־��־����Ƿ� 
			//DB�������� �� ���� ��� ������. ���� DB�������� ���� ��ü�� ��� ��ȯ�����־���Ѵ�.
			// Connection, PreparedStatement, ResultSet ��ü������ �����Ǿ����Ƿ� 
			// close()�޼��带 ���� �޸� ��ȯ ������ ResultSet, PreparedStatement, Connection ������ �Ǿ�� �Ѵ�.
			// close()�޼��� �ڿ� rs, pstmt, conn �� ��ü���������� null������ �ʱ�ȭ�ϴ� ������
			// Ȥ�ó� �� �߸��� �ּ������� �����ϱ� ���Ͽ� null������ �ʱ�ȭ���� �ξ���.
			if(rs != null) try{ rs.close(); rs = null; } catch(SQLException ex) {}
			if(pstmt != null) try{ pstmt.close(); pstmt = null; } catch(SQLException ex) {}
			if(conn != null) try{ conn.close(); conn = null; } catch(SQLException ex) {}
		}
		//���õ� ��� ����Ʈ�� �ּҸ� ����
		return list;
	}
}