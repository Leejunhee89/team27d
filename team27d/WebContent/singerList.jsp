<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.SQLException" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "service.Singer" %>


singerList <br>
<table>
<tr>
	<td>아이디</td><td>이름</td><td>나이</td>
</tr>
<% 
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs = null;

	try{
	
		Class.forName("com.mysql.jdbc.Driver"); 
		String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?" + "useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		
		pstmt = conn.prepareStatement("select * from tb_user");
		rs = pstmt.executeQuery();
		
	} while(rs.next()){
%>
		<tr>
			<td><%= rs.getString(" singer_id")%></td>
			<td><%= rs.getString("singer_name")%></td>
			<td><%= rs.getString("singer_age")%></td>
		</tr>
<%
	} catch(SQLException ex) {
		out.println(ex.getMessage());
		ex.printStackTrace();
		
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
%>
</table>