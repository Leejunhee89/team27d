<!-- team27d [���Ḳ] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.Member" %>
<!DOCTYPE html>
<%
	System.out.println("=====logoutAction.jsp=====");
	//�α׾ƿ� �� ������ �ݾ��ش�.
	session.invalidate();

	response.sendRedirect(request.getContextPath() + "/index.jsp");
%>
