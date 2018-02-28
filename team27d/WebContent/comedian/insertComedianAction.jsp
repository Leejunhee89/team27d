<!-- team27d [방민영] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "service.Comedian" %>
<!DOCTYPE html>

<%
	/*insertComedianForm.jsp에서 reqest.getParameter를 통해 입력받은 값을 가져온 후 Comedian객체 내 세팅한다.
	 *ComedianDao클래스 내 insertComedian메소드를 comedian을 매개변수로하여 실행한다.
	 */
	Comedian comedian = new Comedian();
	comedian.setComedianName(request.getParameter("name"));
	comedian.setComedianAge(Integer.parseInt(request.getParameter("age")));

	ComedianDao comediandao = new ComedianDao();
	comediandao.insertComedian(comedian);
	
	response.sendRedirect(request.getContextPath()+"/comedian/comedianList.jsp");
%>