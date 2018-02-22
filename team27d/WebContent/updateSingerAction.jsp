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
	String send_id = request.getParameter("send_id");
	int singer_id = Integer.parseInt(send_id);
	String singer_name = request.getParameter("singer_name");
	String send_age = request.getParameter("singer_age");
	int singer_age = Integer.parseInt(send_age);

	SingerDao singerdao = new SingerDao();
	Singer singer = new Singer();

	singer.setSingerId(singer_id);
	singer.setSingerName(singer_name);
	singer.setSingerAge(singer_age);

	singerdao.updateSinger(singer);
	response.sendRedirect(request.getContextPath() + "/singerList.jsp");
%>