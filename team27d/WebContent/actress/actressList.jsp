<!-- team27d [이준희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "service.ActressDao"  %>
<%@ page import = "service.Actress"  %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Member" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
	<h1>여배우 리스트</h1>
<% 
	ActressDao ado = new ActressDao();
	ArrayList<Actress> list = ado.selectActress();
	Member member = (Member)session.getAttribute("loginMember");
%>	
	<a href= "<%= request.getContextPath() %>/index.jsp">홈</a> &nbsp;
<% 
	if (member != null) {
%>	
	<a href= "<%= request.getContextPath() %>/actress/insertActressForm.jsp">배우등록</a> <br><br>
<%
	}
%>	
	
	<table border ="1">
	<thead>
		<tr>	
			<th>여배우 ID</th>	
			<th>여배우 NAME</th> 
			<th>여배우 AGE</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>	
	
	<%
		for(Actress actress : list) {
	%>	
	<tbody>	
		<tr>
			<td><%= actress.getActressId() %></td>
			<td><%= actress.getActressName() %></td>
			<td><%= actress.getActressAge() %></td>
	<%
		if (member != null) {
	%>		
			<td><a href="<%=request.getContextPath()%>/actress/updateActressForm.jsp?actressId=<%=actress.getActressId() %>">수정</a></td>
			<td><a href="<%=request.getContextPath()%>/actress/deleteActressAction.jsp?actressId=<%=actress.getActressId() %>">삭제</a></td>
	<%
		}
	%>	
		</tr>		
	</tbody>  
	<% 
	}
	%>
		
</table>
</body>
</html>