<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
%>
<%@ page import="service.SingerDao"%>
<%@ page import="service.Singer"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");
	
	SingerDao singerdao = new SingerDao();
	Singer singer = new Singer();
	singerdao.updateSinger(singer);

	response.sendRedirect(request.getContextPath() + "/singerList.jsp");
%>

