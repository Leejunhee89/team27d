<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	
	int singerId = Integer.parseInt("singer_id");
	String singerName = request.getParameter("singer_name");
	int singerAge = Integer.parseInt("Singer_age");
	
	Singer insert = new Singer();
	insert.setSingerId(singerId);
	insert.setSingerName(singerName);
	insert.setSingerAge(singerAge);
	
	SingerDao singerdao = new SingerDao();
	singerdao.insertSigner(insert);
	
	response.sendRedirect(request.getContextPath() + "/singerList.jsp");

%>
</body>
</html>