<!-- team27d [��ο�] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "service.Comedian" %>
<!DOCTYPE html>

<%
	/*updateComedianForm���� ���� ������ Comedian��ü ���� �����Ѵ�.
	 *ComedianDao��ü �� updateComedian�޼ҵ带 comedian�� �Ű������� �Ͽ� �����Ѵ�.
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