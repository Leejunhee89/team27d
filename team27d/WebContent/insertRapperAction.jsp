<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.RapperDao" %>
<!DOCTYPE html>
<%
	String name = request.getParameter("rapper_name");
	int age = Integer.parseInt(request.getParameter("rapper_age"));
	
	RapperDao rapdao = new RapperDao();
	rapdao.insertRapper(name, age);
	
	response.sendRedirect(request.getContextPath()+"/rapperList.jsp");
%>