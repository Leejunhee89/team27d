//team27d [방민영]

package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComedianDao {
	
	/*ArrayList<Comedian>리턴타입으로 selectComedianList메서드 호출.
	 *ArrayList<Comedian>데이터타입으로 list변수를 선언하고 동시에 ArrayList<Comedian>객체생성.
	 *Connection데이터타입으로 connection변수를 선언하고 null값을 넣어줌.
	 *PreparedStatement데이터타입으로 statement변수를 선언하고 null값을 넣어줌.
	 *ResultSet데이터타입으로 resultSet변수를 선언하고 null값을 넣어줌.	 * 
	 */
	public ArrayList<Comedian> selectComedianList(){
		ArrayList<Comedian> list = new ArrayList<Comedian>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		
		/*try안에 드라이버로딩, DB연결, 쿼리실행준비, 쿼리실행, 객체종료를 넣어주고 catch를 통해 예외를 잡은 후 finally안에서 return값을 받음.*/
		/*Class.forName메서드로 드라이버 로딩.
		 *드라이버주소, 아이디, 패스워드를 String데이터타입으로 값을 넣어주고 getConnection메서드를 실행한 후 
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "SELECT comedian_id comedianId, comedian_name comedianName, comedian_age comedianAge FROM comedian";
			//comedian_id as comedianId에서 as생략함
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
		
						
			while(resultSet.next()) {
				Comedian comedian = new Comedian();
				comedian.setComedianId(resultSet.getInt("comedianId"));
				comedian.setComedianName(resultSet.getString("comedianName"));
				comedian.setComedianAge(resultSet.getInt("comedianAge"));
				list.add(comedian);
				
			if(statement!=null) {statement.close();}
			if(connection!=null) {connection.close();}
			if(resultSet!=null) {resultSet.close();}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return list;
		}
	}
}
