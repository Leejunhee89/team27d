<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.ActressDao" %>
<!DOCTYPE html>

<%
	String actressId1 = request.getParameter("actressId");
	int actressId = Integer.parseInt(actressId1);
	System.out.println(actressId + "������? actressId" );
	ActressDao actress = new ActressDao();
	actress.deleteActress(actressId);
	
	response.sendRedirect(request.getContextPath() +"/actress/actressList.jsp");
%>
