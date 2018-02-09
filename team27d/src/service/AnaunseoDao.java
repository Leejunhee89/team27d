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
		
		//아나운서를 담을수 있는 어레이 리스트 생성
		ArrayList<Anaunseo> arrAnaunseo = new ArrayList<Anaunseo>();
		
		
		try {
			//DB로딩
			Class.forName("com.mysql.jdbc.Driver");
			//DB연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" +
					"useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//쿼리 준비
			pstmt = conn.prepareStatement("SELECT * FROM anaunseo");
			//쿼리 실행후 레코드 ResultSet rs에 저장
			rs = pstmt.executeQuery();
			//rs에  레코드 업을때까지 DB에 저장된 값 ana에 세팅 후 세팅된 ana를 어레이리스트에 저장
			while(rs.next()) {
				ana = new Anaunseo();
				ana.setAnaunseoId( rs.getInt("announcer_id") );
				ana.setAnaunseoName( rs.getString("announcer_name") );
				ana.setAnaunseoAge( rs.getInt("announcer_age") );
				
				arrAnaunseo.add(ana);
			}
		}catch(ClassNotFoundException e){ 
			System.out.println(e.getMessage	());
			System.out.println("예외발생");
		}finally {
			if(rs!=null) try{ rs.close();} catch(SQLException ex) {}
			if(pstmt!=null) try{ pstmt.close();} catch(SQLException ex) {}
			if(conn!=null) try{ conn.close();} catch(SQLException ex) {}
		}
		//세팅된 어레이 리스트의 주소를 리턴
		return arrAnaunseo;
	}
}


	

	
