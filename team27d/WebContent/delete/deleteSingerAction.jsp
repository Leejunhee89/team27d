<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.SingerDao" %>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("euc-kr");

	String send_id = request.getParameter("send_id");
	SingerDao singerdao = new SingerDao();
	singerdao.deleteSigner(send_id);
	
	response.sendRedirect(request.getContextPath() + "/SingerList.jsp");
%>