package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RapperDao {

	public ArrayList<Rapper> selectRapperList() throws SQLException {
		ArrayList<Rapper> rapperlist = new ArrayList<Rapper>();
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//����̹��ε�
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("---����̹��ε�---");
		
			//��񿬰�
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbID = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			System.out.println("---��񿬰�---");

			//���������غ�
			pstmt = conn.prepareStatement("SELECT * FROM rapper");
			System.out.println(pstmt + "---���������غ�---");
			
			//��������
			rs = pstmt.executeQuery();
			System.out.println(rs + "---��������---");
						
			//���������� ���
			while(rs.next()) {
				Rapper rapper = new Rapper();
				rapper.setRapperId(rs.getInt("rapper_id"));
				rapper.setRapperName(rs.getString("rapper_name"));
				rapper.setRapperAge(rs.getInt("rapper_age"));
				rapperlist.add(rapper);
				System.out.println("---while�� �ݺ�---");
			}
		}catch(ClassNotFoundException e){
				System.out.println("catch-���ܹ߻�");
		}finally {
		//�ݱ�			
			if(rs!=null) try{ rs.close(); rs = null; } catch(SQLException ex) {}
			if(pstmt!=null) try{ pstmt.close(); pstmt = null; } catch(SQLException ex) {}
			if(conn!=null) try{ conn.close(); conn = null; } catch(SQLException ex) {}
		}
		return rapperlist;
	}
}
