//team27d [����ȭ]
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RapperDao {// ���ܴ� ���� try-catch ó��
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	// ���� �Է� �޼���
	public void InsertRapper(Rapper rapper) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbID = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO `rapper` (`rapper_name`, `rapper_age`) VALUES (?, ?);";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rapper.getRapperName());
			pstmt.setInt(2, rapper.getRapperAge());
			
			pstmt.executeUpdate();
		
			pstmt.close();
			conn.close();			
		}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}		
	}
	
	// ��� ���� ����Ʈ �޼���
	public ArrayList<Rapper> selectRapperList() {
		// ArrayList ����Ŭ����Ÿ������ ��ü���� - ������������ ���� list�� ����
		// rapperlist -> list�� �ϰ������Ϸ���! ������ ��-Refactor-RenameŬ��
		ArrayList<Rapper> rapperlist = new ArrayList<Rapper>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbID = "root";
			String dbPass = "java0000";
			// sql���� �������� �빮�ڷ� �������ְ�. ���Į������ ����ٸ� ���� ���� Ŭ�������� �빮�ڷ� �����̱⶧���� ��ġ�����ַ��� as�� ����
			// ����.
			// select + order by
			String sql = "SELECT rapper_id AS rapperId, rapper_name AS rapperName, rapper_age AS rapperAge FROM rapper ORDER BY rapper_id ASC";
			conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Rapper rapper = new Rapper(); 
				rapper.setRapperId(rs.getInt("rapperId")); 
				rapper.setRapperName(rs.getString("rapperName"));
				rapper.setRapperAge(rs.getInt("rapperAge"));
				rapperlist.add(rapper); // ���۸���Ʈ�� ���۰�ü(�ݺ�) �߰� -> ���ϰ����� ���� ������***
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ݱ�
			if (rs != null)	try {rs.close(); rs = null;} catch (SQLException ex) {}
			if (pstmt != null) try {pstmt.close(); pstmt = null;} catch (SQLException ex) {}
			if (conn != null) try {conn.close();conn = null;} catch (SQLException ex) {}
		}
		return rapperlist; // ***�߰��� ����Ʈ���� ��ȯ
	}
}