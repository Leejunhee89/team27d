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
			//DB�ε�
			Class.forName("com.mysql.jdbc.Driver");
			//DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" +
					"useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO anaunseo VALUES(?, ?, ?)";
			
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, anaunseo.getAnaunseoId());
			prepareStatement.setString(2, anaunseo.getAnaunseoName());
			prepareStatement.setInt(3, anaunseo.getAnaunseoAge());
			
			isUpdate =prepareStatement.executeUpdate();
			
		} catch(ClassNotFoundException e){
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
			// Connection, PreparedStatement ��ü������ �����Ǿ����Ƿ� 
			// close()�޼��带 ���� �޸� ��ȯ ������ PreparedStatement, Connection ������ �Ǿ�� �Ѵ�.
			// close()�޼��� �ڿ� prepareStatement, connection �� ��ü���������� null������ �ʱ�ȭ�ϴ� ������
			// Ȥ�ó� �� �߸��� �ּ������� �����ϱ� ���Ͽ� null������ �ʱ�ȭ���� �ξ���.
			if(prepareStatement != null) try{ prepareStatement.close(); prepareStatement = null; } catch(SQLException ex) {}
			if(connection != null) try{ connection.close(); connection = null; } catch(SQLException ex) {}
		}
		
		return isUpdate;
	}
	
	public ArrayList<Anaunseo> selectActorList() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Anaunseo ana = null;
		//�Ƴ���� ������ �ִ� ��� ����Ʈ ����
		ArrayList<Anaunseo> list = new ArrayList<Anaunseo>();
		
		try {
			//DB�ε�
			Class.forName("com.mysql.jdbc.Driver");
			//DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" +
					"useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			//anaunseo_id as anaunseoId : as�� ���������ϴ�
			//anaunseo_id anaunseoId : ����
			//anaunseo_id "anaunseoId" : ����
			//���� �ּ� �ڵ��  ���� ���̴� ���̴�
			String sql = "SELECT anaunseo_id as anaunseoId, anaunseo_name as anaunseoName,"
							+ " anaunseo_age as anaunseoAge FROM anaunseo";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//���� �غ�
			pstmt = conn.prepareStatement(sql);
			//���� ������ ���ڵ� ResultSet rs�� ����
			rs = pstmt.executeQuery();
			//rs��  ���ڵ� ���������� DB�� ����� �� ana�� ���� �� ���õ� ana�� ��̸���Ʈ�� ����
			while(rs.next()) {
				ana = new Anaunseo();
				ana.setAnaunseoId( rs.getInt("anaunseoId") );
				ana.setAnaunseoName( rs.getString("anaunseoName") );
				ana.setAnaunseoAge( rs.getInt("anaunseoAge") );
				
				list.add(ana);
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