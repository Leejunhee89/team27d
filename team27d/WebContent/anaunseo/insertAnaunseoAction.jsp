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
	System.out.println("===== insertAnaunseoAction.jsp =====");
	
	String anaunseoName = request.getParameter("anaunseo_name");
	int anaunseoAge = Integer.parseInt(request.getParameter("anaunseo_age"));
	
	Anaunseo anaunseo = new Anaunseo();
	anaunseo.setAnaunseoName(anaunseoName);
	anaunseo.setAnaunseoAge(anaunseoAge);
	System.out.println("setted anaunseo : " + anaunseo);
	
	AnaunseoDao anaunseoDao = new AnaunseoDao();
	anaunseoDao.insertAnaunseo(anaunseo);
		
	response.sendRedirect(request.getContextPath() + "/anaunseo/anaunseoList.jsp");
%>