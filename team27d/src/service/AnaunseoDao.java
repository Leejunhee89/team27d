package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import service.Anaunseo;

public class AnaunseoDao {
	
	public ArrayList<Anaunseo> selectActorList() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Anaunseo ana = null;
		
		//�Ƴ���� ������ �ִ� ��� ����Ʈ ����
		ArrayList<Anaunseo> arrAnaunseo = new ArrayList<Anaunseo>();
		
		
		try {
			//DB�ε�
			Class.forName("com.mysql.jdbc.Driver");
			//DB����
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" +
					"useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//���� �غ�
			pstmt = conn.prepareStatement("SELECT * FROM anaunseo");
			//���� ������ ���ڵ� ResultSet rs�� ����
			rs = pstmt.executeQuery();
			//rs��  ���ڵ� ���������� DB�� ����� �� ana�� ���� �� ���õ� ana�� ��̸���Ʈ�� ����
			while(rs.next()) {
				ana = new Anaunseo();
				ana.setAnaunseoId( rs.getInt("announcer_id") );
				ana.setAnaunseoName( rs.getString("announcer_name") );
				ana.setAnaunseoAge( rs.getInt("announcer_age") );
				
				arrAnaunseo.add(ana);
			}
		}catch(ClassNotFoundException e){ 
			System.out.println(e.getMessage	());
			System.out.println("���ܹ߻�");
		}finally {
			if(rs!=null) try{ rs.close(); rs = null; } catch(SQLException ex) {}
			if(pstmt!=null) try{ pstmt.close(); pstmt = null; } catch(SQLException ex) {}
			if(conn!=null) try{ conn.close(); conn = null; } catch(SQLException ex) {}
		}
		//���õ� ��� ����Ʈ�� �ּҸ� ����
		return arrAnaunseo;
	}
}


	

	
