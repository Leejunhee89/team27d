<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import="service.ActressDao" %>
<%@ page import="service.Actress" %>
<% 	request.setCharacterEncoding("utf-8"); %>
<%
	
	/* int actorId = Integer.parseInt(request.getParameter("id")); */
	String actressName =  request.getParameter("name");
	int actressAge = Integer.parseInt(request.getParameter("age"));
	System.out.println( ", " + actressName + ", " + actressAge);
	
	Actress actress = new Actress();
	/* actor.setActorId(actorId); */
	actress.setActressName(actressName);
	actress.setActressAge(actressAge);
	
	ActressDao actressdao = new ActressDao();
	actressdao.InsertActress(actress);
	
	response.sendRedirect(request.getContextPath()+ "/actressList.jsp");

%>