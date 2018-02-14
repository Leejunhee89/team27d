<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.RapperDao" %>
<!DOCTYPE html>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	System.out.println(id + ", " + name + ", " + age);
	
	RapperDao rapdao = new RapperDao();
	rapdao.insertRapper(id, name, age);
	
	response.sendRedirect(request.getContextPath()+"/rapperList.jsp");
%>