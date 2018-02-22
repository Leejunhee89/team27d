<!-- team27d[³ªÀ±ÁÖ] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="service.SingerDao" %>
<%@ page import="service.Singer" %>
<% 	request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<%		
	String singer_name = request.getParameter("singer_name");
	int singer_age = Integer.parseInt(request.getParameter("singer_age"));
	
	Singer singer = new Singer();
	singer.setSingerName(singer_name);
	singer.setSingerAge(singer_age);
	
	SingerDao singerdao = new SingerDao();
	singerdao.insertSigner(singer);
	
	response.sendRedirect(request.getContextPath() + "/singerList.jsp");
%>