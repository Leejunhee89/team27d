//team27d [이준희] 
package service;

//<1>DB연결을 위해 Connection을 import 시킨다.
import java.sql.Connection;
//<2>DB를 연결하고 쿼리문을 실행시키기 위해 PreparedStatement을 import 시킨다.
import java.sql.PreparedStatement;
//<3>쿼리문을 실행 시킬 ResultSet을 임포트 한다.
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
		/*<1>DB연결을 위해 Connection 을 초기화 한다.
		 *<2>DB를 연결하고 쿼리문을 실행시키기 위해 PreparedStatement 을 초기화 한다.
		 *<3>쿼리문을 실행 시킬 ResultSet 을 초기화 한다.
		 */		
					
		try {
			/*드라이버로딩을 위해 Class.forName 을 트라이 캐치문으로 감싼다. 이유) 정보가 틀릴 예외를 잡아준다.
			 *드라이버로딩에 필요한 정보들을 입력해준다.
			 *DB연결에 conn = DriverManager.getConnection 문장도 트라이 케치문으로 감싼다. 이유) 정보가 틀릴 예외를 잡아준다.
			 */
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			String sql = "select actress_id as actressId, actress_name as actressName, actress_age as actressAge from actress";
					
			// 어떤 쿼리문을 쓸지 문장을 준비한다.
			// 쿼리문을 실행			
			pstmt = conn.prepareStatement(sql); 
			result = pstmt.executeQuery();
			
			
			while(result.next()) {
				// 만약 예외가 생기지 않고 실행이 된다면 while(result.next()) 문장이 실행 될것이다.
				// 쿼리문장에서 실행된 값이 Actor 클래스에 겟팅되고 셋팅된다. 그 값들이 배열에 담긴다.
				
				Actress actress = new Actress();
				int actressId = result.getInt("actressId");
				String actressName = result.getString("actressName");	
				int actressAge = result.getInt("actressAge");
				
				actress.setActressId(actressId);
				actress.setActressName(actressName);
				actress.setActressAge(actressAge);
				list.add(actress);
				
								
						
			}
		
			//단위테스트 : 배열이나 기타 리턴값에 값이 잘들어갔는지 확인하기 위한 테스트(입력만 할때 toString을 활용하여 활용할수있다.)
			System.out.println(list.size());
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			// 예외 처리
		} finally {
			//예외 이든 아니든 무조건 result pstmt conn 들이 닫힌다. 
			if (result != null) try {result.close();} catch (SQLException ex) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null) try {conn.close();} catch (SQLException ex) {}
		}
		return list;
				
		
	}	
}
