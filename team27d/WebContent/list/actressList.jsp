<!-- team27d [이준희] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "service.ActressDao"  %>
<%@ page import = "service.Actress"  %>
<%@ page import = "java.util.ArrayList" %>
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
%>	
	<a href= "<%= request.getContextPath() %>/index.jsp">홈</a> &nbsp;
	<a href= "<%= request.getContextPath() %>/insert/insertActressForm.jsp">배우등록</a> <br><br>
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
			<td><a href="<%=request.getContextPath()%>/update/updateActressForm.jsp?actressId=<%=actress.getActressId() %>">수정</a></td>
			<td><a href="<%=request.getContextPath()%>/delete/deleteActressAction.jsp?actressId=<%=actress.getActressId() %>">삭제</a></td>
		</tr>
	</tbody>  
	<% 
	}
	%>
		
</table>
</body>
</html>