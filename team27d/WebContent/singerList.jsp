<!-- team27d[������] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
<!DOCTYPE html>
<%@ page import = "service.SingerDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Singer" %>

<% 		
		SingerDao singerdao = new SingerDao();
		ArrayList<Singer> list = singerdao.selectSingerList();			
%>

<!-- SingerDao�� �ּҰ� �Ҵ�� singerdao������ ����. Singer�� �迭�� list�� ���� list�� ���� SingerDao.java ���� selectSingerList()�޼��� ȣ��  -->

<html>
<body>
	<table border="1">
		<tr>
		<th>���̵�</th>
		<th>�̸�</th>
		<th>����</th>
		</tr> 
		
		<%
			for(Singer sin : list){
		%>
		<tr>
		<td><%=sin.getSingerId()%></td>
		<td><%=sin.getSingerName()%></td>
		<td><%=sin.getSingerAge()%></td>
		</tr>
		<!-- for���� �̿��� Singer list�� ȣ�� -->
		<%
			}
		%>
	</table> 
</body>
</html>