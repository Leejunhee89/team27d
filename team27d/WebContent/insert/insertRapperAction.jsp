<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.RapperDao" %>
<%@ page import = "service.Rapper" %>
<% 	request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<%	
	String rapper_name = request.getParameter("rapper_name");
	int rapper_age = Integer.parseInt(request.getParameter("rapper_age"));
	
	Rapper rapper = new Rapper();
	rapper.setRapperName(rapper_name);
	rapper.setRapperAge(rapper_age);
	
	RapperDao rapdao = new RapperDao();
	rapdao.insertRapper(rapper);
	
	response.sendRedirect(request.getContextPath()+"/list/rapperList.jsp");
%>