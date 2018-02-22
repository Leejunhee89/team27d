<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.RapperDao" %>
<!DOCTYPE html>
<%	
	int rapperId = Integer.parseInt(request.getParameter("rapperId"));	
	RapperDao rapdao = new RapperDao();
	rapdao.deleteRapper(rapperId);	
	response.sendRedirect(request.getContextPath() + "/list/rapperList.jsp");
%>
