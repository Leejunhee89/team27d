<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.SingerDao" %>
<%@ page import="service.Singer" %>
<!DOCTYPE html>
<%
	int singerId = Integer.parseInt(request.getParameter("singerId"));
	SingerDao singerdao = new SingerDao();
	singerdao.deleteSinger(singerId);	
	response.sendRedirect(request.getContextPath() + "/singer/singerList.jsp");
%>