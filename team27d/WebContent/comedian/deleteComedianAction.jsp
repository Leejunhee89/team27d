<!-- team27d [��ο�] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao"%>
<%@ page import = "service.Comedian"%>

<!DOCTYPE html>

<%
	/*comedianList.jsp���� ���� comedianId���� �޾� int������ ��ȯ�� �� Comedian��ü ���� �����Ѵ�.
	 *ComedianDao��ü �� deleteComedian�޼ҵ带 comedian�� �Ű������� �����Ѵ�.
	 */
	Comedian comedian = new Comedian();
	comedian.setComedianId(Integer.parseInt(request.getParameter("comedianId")));
	
	ComedianDao comedianDao = new ComedianDao();
	comedianDao.deleteComedian(comedian);
	response.sendRedirect(request.getContextPath() + "/comedian/comedianList.jsp");
%>
 