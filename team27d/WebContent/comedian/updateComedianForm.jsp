<!-- team27d [��ο�] -->

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateAnaunseoFrom.jsp</title>
	</head>
	<body>
		<table border = "1">
			<thead>
				<tr>
					<th>�Ӽ�</th>
					<th>�Է¶�</th>
				</tr>
			</thead>
			<%
				/*comedianList���� ������ comedianId���� �޾� int������ ��ȯ�� �� ���� id�� ��´�.
				 *ComedianDaoŬ���� ���� updateComedianOne�޼ҵ带 id�� �Ű������� �Ͽ� ������ �� ���ϰ��� comedian�� ��´�.
				 *ȭ�鿡 �ѷ��� ����(dbid, dbname, dbage)�� Comedian��ü���� getting�Ѵ�.
				 */
				request.setCharacterEncoding("euc-kr");
				
				Comedian comedian = new Comedian();
				int id = Integer.parseInt(request.getParameter("comedianId"));
				
				ComedianDao comedianDao = new ComedianDao();
				comedian = comedianDao.updateComedianOne(id);
				
				int dbid = comedian.getComedianId();
				String dbname = comedian.getComedianName();
				int dbage = comedian.getComedianAge();
			%>
			<form action="<%=request.getContextPath() %>/comedian/updateComedianAction.jsp" method="post">
				<tbody>		
					<tr>
						<td>���̵�</td>
						<td><input type="text" name="id" value="<%=dbid%>" readonly></td>	
					</tr>	
					<tr>
						<td>�̸� </td>
						<td><input type="text" name="name" value="<%=dbname%>"></td>
					</tr>
					<tr>
						<td>����</td>
						<td><input type="text" name="age" value="<%=dbage%>"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="��Ϲ�ư"></td>
					</tr>
				</tbody>
				</table>
			</form>
		</table>
	</body>
</html>
	
