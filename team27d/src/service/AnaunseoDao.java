// team27d [이춘림]
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
	
		//단위테스트
		System.out.println(anaunseo);
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int isUpdate = 0;
		try {
			//DB로딩
			Class.forName("com.mysql.jdbc.Driver");
			//DB연결
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
			System.out.println("예외발생");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage	());
			System.out.println("예외발생");
		}finally {
			//DB에 연결하여 DB에서 필요한 정보를 모두  Anaunseo객체 마다에 세팅한 후,
			//세팅이 끝난 Anaunseo객체를 ArrayList<Anaunseo> list에 넣어주었으므로 
			//DB단위에서 할 일은 모두 끝났다. 따라서 DB단위에서 사용된 개체를 모두 반환시켜주어야한다.
			// Connection, PreparedStatement 객체순으로 생성되었으므로 
			// close()메서드를 통한 메모리 반환 순서는 PreparedStatement, Connection 순서가 되어야 한다.
			// close()메서드 뒤에 prepareStatement, connection 의 객체참조변수를 null값으로 초기화하는 이유는
			// 혹시나 모를 잘못된 주소참조를 방지하기 위하여 null값으로 초기화시켜 두었다.
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
		//아나운서를 넣을수 있는 어레이 리스트 생성
		ArrayList<Anaunseo> list = new ArrayList<Anaunseo>();
		
		try {
			//DB로딩
			Class.forName("com.mysql.jdbc.Driver");
			//DB연결
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" +
					"useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			//anaunseo_id as anaunseoId : as는 생략가능하다
			//anaunseo_id anaunseoId : 가능
			//anaunseo_id "anaunseoId" : 가능
			//위의 주석 코드는  별명 붙이는 것이다
			String sql = "SELECT anaunseo_id as anaunseoId, anaunseo_name as anaunseoName,"
							+ " anaunseo_age as anaunseoAge FROM anaunseo";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			//쿼리 준비
			pstmt = conn.prepareStatement(sql);
			//쿼리 실행후 레코드 ResultSet rs에 저장
			rs = pstmt.executeQuery();
			//rs에  레코드 없을때까지 DB에 저장된 값 ana에 세팅 후 세팅된 ana를 어레이리스트에 저장
			while(rs.next()) {
				ana = new Anaunseo();
				ana.setAnaunseoId( rs.getInt("anaunseoId") );
				ana.setAnaunseoName( rs.getString("anaunseoName") );
				ana.setAnaunseoAge( rs.getInt("anaunseoAge") );
				
				list.add(ana);
			}
			//단위테스트 코드
			System.out.println(list.size() + "<=== 단위테스트 코드");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println(e.getMessage	());
			System.out.println("예외발생");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage	());
			System.out.println("예외발생");
		}finally {
			//DB에 연결하여 DB에서 필요한 정보를 모두  Anaunseo객체 마다에 세팅한 후,
			//세팅이 끝난 Anaunseo객체를 ArrayList<Anaunseo> list에 넣어주었으므로 
			//DB단위에서 할 일은 모두 끝났다. 따라서 DB단위에서 사용된 개체를 모두 반환시켜주어야한다.
			// Connection, PreparedStatement, ResultSet 객체순으로 생성되었으므로 
			// close()메서드를 통한 메모리 반환 순서는 ResultSet, PreparedStatement, Connection 순서가 되어야 한다.
			// close()메서드 뒤에 rs, pstmt, conn 의 객체참조변수를 null값으로 초기화하는 이유는
			// 혹시나 모를 잘못된 주소참조를 방지하기 위하여 null값으로 초기화시켜 두었다.
			if(rs != null) try{ rs.close(); rs = null; } catch(SQLException ex) {}
			if(pstmt != null) try{ pstmt.close(); pstmt = null; } catch(SQLException ex) {}
			if(conn != null) try{ conn.close(); conn = null; } catch(SQLException ex) {}
		}
		//세팅된 어레이 리스트의 주소를 리턴
		return list;
	}
}