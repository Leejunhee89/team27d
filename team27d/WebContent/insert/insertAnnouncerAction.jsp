<!-- team27d [ÀÌÃá¸²] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "service.Anaunseo" %>
<%@ page import = "service.AnaunseoDao" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");
	String anaunseo_name = request.getParameter("anaunseo_name");
	int anaunseo_age = Integer.parseInt(request.getParameter("anaunseo_age"));
	
	Anaunseo anaunseo = new Anaunseo();
	anaunseo.setAnaunseoName(anaunseo_name);
	anaunseo.setAnaunseoAge(anaunseo_age);
	
	AnaunseoDao anaunseoDao = new AnaunseoDao();
	anaunseoDao.insertAnaunseo(anaunseo);
		
	response.sendRedirect(request.getContextPath() + "/announcerList.jsp");
%>