<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.ActressDao" %>
<!DOCTYPE html>

<%
	String actressId1 = request.getParameter("actressId");
	int actressId = Integer.parseInt(actressId1);
	System.out.println(actressId + "¹«¾ùÀÌ? actorId" );
	ActressDao actress = new ActressDao();
	actress.DeleteActress(actressId);
	
	response.sendRedirect(request.getContextPath() +"/actressList.jsp");
%>
