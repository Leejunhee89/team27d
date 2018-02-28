<!-- team27d [방민영] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao"%>
<%@ page import = "service.Comedian"%>

<!DOCTYPE html>

<%
	/*comedianList.jsp에서 보낸 comedianId값을 받아 int형으로 변환한 뒤 Comedian객체 내에 세팅한다.
	 *ComedianDao객체 내 deleteComedian메소드를 comedian을 매개변수로 실행한다.
	 */
	Comedian comedian = new Comedian();
	comedian.setComedianId(Integer.parseInt(request.getParameter("comedianId")));
	
	ComedianDao comedianDao = new ComedianDao();
	comedianDao.deleteComedian(comedian);
	response.sendRedirect(request.getContextPath() + "/comedian/comedianList.jsp");
%>
 