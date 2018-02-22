<!-- team27d[나윤주] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.SingerDao" %>
<%@ page import="service.Singer" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>insertSingerAction.jsp</title>
</head>
<body>
<%		
	request.setCharacterEncoding("euc-kr");
		
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
		
	SingerDao singerdao = new SingerDao();
	singerdao.insertSigner(id, name, age);
	
	response.sendRedirect(request.getContextPath() + "/singerList.jsp");
%>
</body>
</html>