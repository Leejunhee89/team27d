/*team27d[������]*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import service.Singer;

public class SingerDao {
	
	ResultSet resultset = null;
	Connection connection = null;
	PreparedStatement preparedstatement = null;
	Singer singer = null;

	public Singer updateSingerOne(int singerid) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("SELECT * FROM singer WHERE singer_id = ?");
			preparedstatement.setInt(1, singerid);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				singer = new Singer();
				singer.setSingerId(resultset.getInt("singer_id"));
				singer.setSingerName(resultset.getString("singer_name"));
				singer.setSingerAge(resultset.getInt("singer_age"));
			}			
		}catch(SQLException exception) {
			exception.printStackTrace();
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		}finally {
			if(resultset != null) {
				try {
					resultset.close();
					resultset = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
			if(preparedstatement != null) {
				try {
					preparedstatement.close();
					preparedstatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
		}
		return singer;
	}
	
	public void updateSinger(Singer singer) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement("UPDATE singer SET singer_name = ?, singer_age = ? WHERE singer_id = ?");
			preparedstatement.setString(1, singer.getSingerName());
			preparedstatement.setInt(2, singer.getSingerAge());
			preparedstatement.setInt(3, singer.getSingerId());
			preparedstatement.executeUpdate();			
		}catch(SQLException exception) {
			exception.printStackTrace();
		}catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		}finally {
			if(preparedstatement != null) {
				try {
					preparedstatement.close();
					preparedstatement = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
					connection = null;
				}catch(SQLException exception) {
					exception.printStackTrace();
				}
			}
		}
	}

	public void deleteSinger(int singerid) {		
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "DELETE FROM `singer` WHERE  `singer_id`=?";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement(sql);	
			preparedstatement.setInt(1, singerid);	
			preparedstatement.executeUpdate();		
			
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			System.out.println(exception.getMessage	());
			System.out.println("���ܹ߻�");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage	());
			System.out.println("���ܹ߻�");
		}finally {
			if(preparedstatement != null) {
				try{
					preparedstatement.close();
					preparedstatement = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("���ܹ߻�");
				}
			}
			if(connection != null) {
				try{
					connection.close();
					connection = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("���ܹ߻�");
				}
			}
		}
	}
	
	public void insertSigner(Singer singer) {
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			String sql = "INSERT INTO `singer` (`singer_name`, `singer_age`) VALUES (?, ?);";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement(sql);
		
			preparedstatement.setString(1, singer.getSingerName());
			preparedstatement.setInt(2, singer.getSingerAge());
			preparedstatement.executeUpdate();
	
		}catch(ClassNotFoundException exception){
			exception.printStackTrace();
			System.out.println(exception.getMessage	());
			System.out.println("���ܹ߻�");
		}catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println(exception.getMessage	());
			System.out.println("���ܹ߻�");
		}finally {
			if(preparedstatement != null) {
				try{
					preparedstatement.close();
					preparedstatement = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("���ܹ߻�");
				}
			}
			if(connection != null) {
				try{
					connection.close();
					connection = null;
				} catch(SQLException exception) {
					exception.printStackTrace();
					System.out.println(exception.getMessage());
					System.out.println("���ܹ߻�");
				}
			}
		}
	}

	public ArrayList<Singer> selectSinger() {
		
		ArrayList<Singer> singerlist = new ArrayList<Singer>();
		
		/* ArrayList<Singer> �ּҰ��� ����ִ� ��ü�������� list�� �Ҵ�. */

		/* db ���� �� ������ ���� value�� ���� */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			/* db�ε� */

			String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			// SQL���� Ű���� �빮�� ���
			String sql = "SELECT singer_id AS singerId, singer_name AS singerName, singer_age AS singerAge FROM singer ORDER BY singer_id ASC";
			connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			preparedstatement = connection.prepareStatement(sql);

			/* ���������� ��� */
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				/*
				 * mySQL�� �ִ� ������ ���� �����ϱ����� Singer.java�� �ּҸ� ����ִ� sing ��ü�������� ����. sing�� ���� �����Ͱ���
				 * ���� �� �������ش�. ������ ���� list�� sing�� add���ش�.
				 */
				Singer sing = new Singer();
				sing.setSingerId(resultset.getInt("singerId"));
				sing.setSingerName(resultset.getString("singerName"));
				sing.setSingerAge(resultset.getInt("singerAge"));
				singerlist.add(sing);
			}
		} catch (ClassNotFoundException e) {
			// ClassNotFoundException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ��ش�.
			e.printStackTrace();

		} catch (SQLException e) {
			// SQLException ���ܹ߻��� ĳġ�� �Ű������� �Ѱ��ش�.
			e.printStackTrace();

		}finally {
			if(resultset!=null) {try {resultset.close();} catch (SQLException e) {e.printStackTrace();}}
			if(preparedstatement!=null) {try {preparedstatement.close();} catch (SQLException e) {e.printStackTrace();}}
			if(connection!=null) {try {connection.close();} catch (SQLException e) {e.printStackTrace();}}
			}
		// list ���� ���Ͻ����ش�.
		return singerlist;

	}
}