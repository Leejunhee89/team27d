<!-- team27d [��ο�] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "service.Comedian" %>
<!DOCTYPE html>

<%
	/*ComedianŬ������ ���� ���ο� ��ü�� ������ �� �ּҸ� comedian�� ��´�.
	 *insertComedianForm.jsp���� reqest.getParameter�� ���� �Է¹��� ���� ������ �� Comedian��ü �� �����Ѵ�.
	 *ComedianDaoŬ������ ���� ���ο� ��ü�� ������ �� �ּҸ� comedianDao�� ��´�.
	 *ComedianDaoŬ���� �� insertComedian�޼ҵ带 comedian�� �Ű��������Ͽ� �����Ѵ�.
	 */
	Comedian comedian = new Comedian();
	comedian.setComedianName(request.getParameter("name"));
	comedian.setComedianAge(Integer.parseInt(request.getParameter("age")));

	ComedianDao comediandao = new ComedianDao();
	comediandao.insertComedian(comedian);
	
	response.sendRedirect(request.getContextPath()+"/list/comedianList.jsp");
%>