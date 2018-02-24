<!-- team27d [ÀÌÃá¸²] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.Member" %>
<!DOCTYPE html>
<%
	System.out.println("=====logoutAction.jsp=====");
	Member member = (Member)session.getAttribute("loginMember");
	
	session.invalidate();

	response.sendRedirect(request.getContextPath() + "/index.jsp");
%>
