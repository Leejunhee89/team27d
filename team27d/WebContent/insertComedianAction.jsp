<!-- team27d [¹æ¹Î¿µ] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao" %>
<!DOCTYPE html>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));

	ComedianDao comediandao = new ComedianDao();
	comediandao.insertComedian(name, age);
	
	response.sendRedirect(request.getContextPath()+"/comedianList.jsp");

%>