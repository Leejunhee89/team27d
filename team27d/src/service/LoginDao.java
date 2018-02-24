// team27d [���Ḳ]
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
			preparedStatement.setString(1, member.getMember_id());
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				System.out.println("���̵� ��ġ");
				if(member.getMember_pw().equals(resultSet.getString("member_pw"))) {
					System.out.println("�н����� ��ġ : �α��� ����");
					member.setMember_no(resultSet.getInt("member_no"));
					result = 1;
				}else {
					System.out.println("�н����� ����ġ : �α��� ����");
					result = 3;
				}
			}else {
				System.out.println("���̵� ����ġ : �α��� ����");
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
					System.out.println("LoginDao.loginCheck() / resultSet.close() ���� �߻�");
				}
			}
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
					preparedStatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("LoginDao.loginCheck() / preparedStatement.close() ���� �߻�");
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("LoginDao.loginCheck() / connection.close() ���� �߻�");
				}
			}
		}
		System.out.println("return result : " + result);
		System.out.println("@@@@@@@@@@");
		return result;
	}
}
