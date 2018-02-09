<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

//드라이버로딩
Class.forName("com.mysql.jdbc.Driver"); 
//디비연결
String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
String dbID = "root";
String dbPass = "java0000";
conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
//쿼리실행준비
pstmt = conn.prepareStatement("SELECT * FROM anaunseo");
//쿼리실행
rs = pstmt.executeQuery();
//쿼리실행결과 사용
while(rs.next()) {
	rs.getInt(1);
	rs.getString("rapper_name");
	rs.getInt("rapper_age");
}
//닫기
rs.close();
pstmt.close();
conn.close();

%>

<body>
	<table>
		<tr>
			<td>아이디</td><td>이름</td><td>나이</td>
		<tr>
	</table>
</body>
</html>