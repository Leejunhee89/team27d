<!-- team27d [¹æ¹Î¿µ] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "service.Comedian" %>

<!DOCTYPE html>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	
	Comedian comedian = new Comedian();
	comedian.setComedianName(name);
	comedian.setComedianAge(age);

	ComedianDao comediandao = new ComedianDao();
	comediandao.insertComedian(comedian);
	
	response.sendRedirect(request.getContextPath()+"/comedianList.jsp");

%>