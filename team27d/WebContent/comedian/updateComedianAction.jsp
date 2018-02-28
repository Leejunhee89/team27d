<!-- team27d [방민영] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "service.Comedian" %>
<!DOCTYPE html>

<%
	/*updateComedianForm에서 받은 값들을 Comedian객체 내에 세팅한다.
	 *ComedianDao객체 내 updateComedian메소드를 comedian을 매개변수로 하여 실행한다.
	 */
	request.setCharacterEncoding("euc-kr");
	Comedian comedian = new Comedian();
	comedian.setComedianId(Integer.parseInt(request.getParameter("id")));
	comedian.setComedianName(request.getParameter("name"));
	comedian.setComedianAge(Integer.parseInt(request.getParameter("age")));
	
	ComedianDao comedianDao = new ComedianDao();
	comedianDao.updateComedian(comedian);
		
	response.sendRedirect(request.getContextPath()+"/comedian/comedianList.jsp");
%>