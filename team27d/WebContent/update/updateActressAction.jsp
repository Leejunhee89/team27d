<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ page import="service.ActressDao" %>
<%@ page import="service.Actress" %>
<!DOCTYPE html>
<% 	request.setCharacterEncoding("utf-8"); %>

<%
	int actressId = Integer.parseInt(request.getParameter("id"));
	String actressName = request.getParameter("name");
	int actressAge = Integer.parseInt(request.getParameter("age"));
	
	Actress actress = new Actress();
	actress.setActressId(actressId);
	actress.setActressName(actressName);
	actress.setActressAge(actressAge);
	
	ActressDao actressdao = new ActressDao();
	actressdao.updateActress(actress);
	response.sendRedirect(request.getContextPath() + "/list/actressList.jsp");



%>