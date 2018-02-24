<!-- team27d [ÀÌÃá¸²] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.Member" %>
<!DOCTYPE html>
<%
	System.out.println("=====logoutAction.jsp=====");
	//·Î±×¾Æ¿ô ½Ã ¼¼¼ÇÀ» ´Ý¾ÆÁØ´Ù.
	session.invalidate();

	response.sendRedirect(request.getContextPath() + "/index.jsp");
%>
