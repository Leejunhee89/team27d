<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.SingerDao" %>
<%@ page import="service.Singer" %>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("euc-kr");

	
	int singerid = Integer.parseInt(request.getParameter("singerId"));
	System.out.print(singerid);
	SingerDao singerdao = new SingerDao();
	singerdao.deleteSinger(singerid);
	
	response.sendRedirect(request.getContextPath() + "/list/singerList.jsp");
%>
