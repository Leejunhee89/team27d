//team27d [����ȭ]
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RapperDao {

	public ArrayList<Rapper> selectRapperList() throws SQLException {
		//ArrayList ����Ŭ����Ÿ������ ��ü����
		ArrayList<Rapper> rapperlist = new ArrayList<Rapper>();
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//����̹��ε�
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("---����̹��ε�---");
		
			//��񿬰�(��Ʈ���� ����)
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbID = "root";
			String dbPass = "java0000";
			//sql���� �������� �빮�ڷ� �������ְ�. ���Į������ ����ٸ� ���� ���� Ŭ�������� �빮�ڷ� �����̱⶧���� ��ġ�����ַ��� as�� ���� ����.
			String sql = "SELECT rapper_id as rapperId, rapper_name as rapperName, rapper_age as rapperAge FROM rapper";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			System.out.println("---��񿬰�---");

			//���������غ�
			pstmt = conn.prepareStatement(sql);
			System.out.println(pstmt + "---���������غ�---");
			
			//��������
			rs = pstmt.executeQuery();
			System.out.println(rs + "---��������---");
						
			//���������� ���
			while(rs.next()) {
				Rapper rapper = new Rapper(); //���۰�ü����
				rapper.setRapperId(rs.getInt("rapperId")); //����� ���۾��̵� �����ؼ� ������ ���۰�ü�� ����
				rapper.setRapperName(rs.getString("rapperName"));
				rapper.setRapperAge(rs.getInt("rapperAge"));
				rapperlist.add(rapper); //���۸���Ʈ�� ���۰�ü(�ݺ�) �߰�
				System.out.println("---while�� �ݺ� �����׽�Ʈ---");
				System.out.println(rapperlist.toString());
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
