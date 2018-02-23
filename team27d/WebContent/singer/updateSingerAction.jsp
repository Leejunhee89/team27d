<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%	request.setCharacterEncoding("euc-kr"); %>
<%@ page import="service.SingerDao"%>
<%@ page import="service.Singer"%>
<!DOCTYPE html>
<%
	Singer singer = new Singer();
	singer.setSingerId(Integer.parseInt(request.getParameter("singer_id")));
	singer.setSingerName(request.getParameter("singer_name"));
	singer.setSingerAge(Integer.parseInt(request.getParameter("singer_age")));
	
	SingerDao singerdao = new SingerDao();	
	singerdao.updateSinger(singer);
	response.sendRedirect(request.getContextPath() + "/list/singerList.jsp");
%>