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

//����̹��ε�
Class.forName("com.mysql.jdbc.Driver"); 
//��񿬰�
String jdbcDriver = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
String dbID = "root";
String dbPass = "java0000";
conn = DriverManager.getConnection(jdbcDriver, dbID, dbPass);
//���������غ�
pstmt = conn.prepareStatement("SELECT * FROM anaunseo");
//��������
rs = pstmt.executeQuery();
//���������� ���
while(rs.next()) {
	rs.getInt(1);
	rs.getString("rapper_name");
	rs.getInt("rapper_age");
}
//�ݱ�
rs.close();
pstmt.close();
conn.close();

%>

<body>
	<table>
		<tr>
			<td>���̵�</td><td>�̸�</td><td>����</td>
		<tr>
	</table>
</body>
</html>