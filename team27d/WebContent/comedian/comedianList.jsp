<!-- team27d [방민영] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.Comedian" %>
<%@ page import = "service.ComedianDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Member" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>코미디언 리스트</h1>
		<%
			/*ComedianDao객체 내 selectComedianList메소드를 실행시켜 리턴값을 list에 담고,
			 *그 값들을 comedian에 담는다. =>Comedian객체 내 세팅이 이루어진다.
			 *그리고 Comedian객체에서 값을 getting하여 화면에 보여준다.
			 */
			request.setCharacterEncoding("euc-kr");
			ComedianDao comedianDao = new ComedianDao();
			ArrayList<Comedian> list = comedianDao.selectComedianList();
			Member member = (Member)session.getAttribute("loginMember");

		%>
		<a href = "<%= request.getContextPath() %>/index.jsp">홈</a> &nbsp;
		<% 
			//세션이 null값이 아니면(로그인이 되어있는 경우) 코메디언 등록이 보인다.
			if (session.getAttribute("loginMember") != null) {
		%>
				<a href = "<%= request.getContextPath() %>/comedian/insertComedianForm.jsp">코메디언 등록</a><br><br>
		 
		<% 
			}
		%>
		
		<table border = "1">
			<thead>
				<tr>
					<th>코미디언 ID</th>
					<th>코미디언 NAME</th>
					<th>코미디언 AGE</th>
				<%
					//세션이 null값이 아니면  수정, 삭제가 보인다.
					if(session.getAttribute("loginMember") !=null){
				%>
						<th>수정</th>
						<th>삭제</th>
				<%
					}
				%>
				</tr>
			</thead>
			<tbody>
				<%
					for(Comedian comedian : list) {
				%>
						<tr>
							<td><%=comedian.getComedianId()%></td>
							<td><%=comedian.getComedianName() %></td>
							<td><%=comedian.getComedianAge() %></td>
						<% 
							//세션이 null값이 아니면 수정, 삭제버튼이 보인다.
							if (session.getAttribute("loginMember")!= null)	{	
						%>	
								<td><a href="<%=request.getContextPath()%>/comedian/updateComedianForm.jsp?comedianId=<%=comedian.getComedianId()%>">수정</a></td>
								<td><a href="<%=request.getContextPath()%>/comedian/deleteComedianAction.jsp?comedianId=<%=comedian.getComedianId()%>">삭제</a></td>
						<%
							}
						%>
						</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</body>
</html>