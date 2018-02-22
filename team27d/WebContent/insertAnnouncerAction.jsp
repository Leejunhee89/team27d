<!-- team27d [ÀÌÃá¸²] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.PreparedStatement" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");
	String anaunseo_name = request.getParameter("anaunseo_name");
	int anaunseo_age = Integer.parseInt(request.getParameter("anaunseo_age"));
	
	Class.forName("com.mysql.jdbc.Driver");
	
	String dbUrl = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=euckr";
	String dbId = "root";
	String dbPw = "java0000";
	Connection connection = DriverManager.getConnection(dbUrl, dbId, dbPw);

	PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO anaunseo(anaunseo_name, anaunseo_age) VALUES(?, ?)");
	preparedStatement.setString(1, anaunseo_name);
	preparedStatement.setInt(2, anaunseo_age);
	preparedStatement.executeUpdate();
	
	response.sendRedirect(request.getContextPath() + "/announcerList.jsp");
%>