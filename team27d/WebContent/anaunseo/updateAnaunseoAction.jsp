<!-- team27d [ÀÌÃá¸²] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");
	System.out.println("===== updateAnaunseoAction.jsp =====");
	
	Anaunseo anaunseo = new Anaunseo();
	anaunseo.setAnaunseoId(Integer.parseInt(request.getParameter("anaunseo_id")));
	anaunseo.setAnaunseoName(request.getParameter("anaunseo_name"));
	anaunseo.setAnaunseoAge(Integer.parseInt(request.getParameter("anaunseo_age")));
	System.out.println("setted anaunseo : " + anaunseo);
	
	AnaunseoDao anaunseoDao = new AnaunseoDao();
	anaunseoDao.updateAnaunseo(anaunseo);
	
	response.sendRedirect(request.getContextPath() + "/anaunseo/anaunseoList.jsp");
%>