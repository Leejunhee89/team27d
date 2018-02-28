<!-- team27d [방민영] -->

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
					<th>속성</th>
					<th>입력란</th>
				</tr>
			</thead>
			<%
				/*comedianList에서 보내준 comedianId값을 받아 int형으로 변환한 뒤 변수 id에 담는다.
				 *ComedianDao클래스 내의 updateComedianOne메소드를 id를 매개변수로 하여 실행한 후 리턴값을 comedian에 담는다.
				 *화면에 뿌려질 내용(dbid, dbname, dbage)을 Comedian객체에서 getting한다.
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
						<td>아이디</td>
						<td><input type="text" name="id" value="<%=dbid%>" readonly></td>	
					</tr>	
					<tr>
						<td>이름 </td>
						<td><input type="text" name="name" value="<%=dbname%>"></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input type="text" name="age" value="<%=dbage%>"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="등록버튼"></td>
					</tr>
				</tbody>
				</table>
			</form>
		</table>
	</body>
</html>
	
