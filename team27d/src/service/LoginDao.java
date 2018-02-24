// team27d [이춘림]
package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	/*
		loginDao.loginCheck() 메서드의 매개변수로 받은 Member객체는 맴버변수인 memberId, memberPw만 세팅된 상태이다.
		member.memberId, member.memberPw 값이 DB에 저장되어있는 정보와 일치하여 로그인 조건이 성립하면,
		그 때, DB에서 오토 세팅하여 저장되어있던 member_no 값을 불러와
		loginDao.loginCheck() 메서드의 매개변수로 받은 Member객체의 memberNo 맴버변수를 값을 초기화시켜준다.
		매서드의 실행결과로 리턴되는 값은 로그인 성공 유무를 상징하는 int 값이며,
		0 : 예외조건 발생
		1 : 아이디, 패스워드 일치 조건 (로그인 성공)
		2 : 아이디 불일치 조건 (로그인 실패)
		3 : 패스워드 불일치 조건 (로그인 실패)
		를 의미한다.
	*/
	public int loginCheck(Member member) {
		System.out.println("@@@@@ int LoginDao.loginCheck(Member member) @@@@@");
		System.out.println("parameter member : " + member);
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String id = "root";
			String pw = "java0000";
			connection = DriverManager.getConnection(url, id, pw);
			preparedStatement = connection.prepareStatement("SELECT * FROM member WHERE member_id = ? ORDER BY member_no ASC");
			preparedStatement.setString(1, member.getMemberId());
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				System.out.println("아이디 일치");
				if(member.getMemberPw().equals(resultSet.getString("member_pw"))) {
					System.out.println("패스워드 일치 : 로그인 성공");
					//loginAction.jsp페이지에서 세션을 설정할 Member객체 이므로 로그인 성공 조건에서 set메서드를 통해 no값을 세팅해준다.
					member.setMemberNo(resultSet.getInt("member_no"));
					System.out.println("setting member.member_no : " + member);
					result = 1;
				}else {
					System.out.println("패스워드 불일치 : 로그인 실패");
					result = 3;
				}
			}else {
				System.out.println("아이디 불일치 : 로그인 실패");
				result = 2;
			}
			
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("LoginDao.loginCheck() / ClassNotFoundException");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage());
			System.out.println("LoginDao.loginCheck() / SQLException");
		}finally {
			if(resultSet != null) {
				try {
					resultSet.close();
					resultSet = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("LoginDao.loginCheck() / resultSet.close() 에외 발생");
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("LoginDao.loginCheck() / preparedStatement.close() 에외 발생");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("LoginDao.loginCheck() / connection.close() 에외 발생");
				}
			}
		}
		System.out.println("return result : " + result);
		System.out.println("@@@@@@@@@@");
		return result;
	}
}
