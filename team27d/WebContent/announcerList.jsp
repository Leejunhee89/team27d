<!-- team27d [이춘림] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>아나운서 리스트</h1>
<%
	request.setCharacterEncoding("euc-kr");
	AnaunseoDao anaDao = new AnaunseoDao();
	ArrayList<Anaunseo> list = anaDao.selectActorList();
%>
	<a href = "<%= request.getContextPath() %>/index.jsp">홈</a> &nbsp;
	<a href = "<%= request.getContextPath() %>/insertAnnouncerForm.jsp">아나운서 등록</a><br/>
	<table border = "1">
		<thead>
			<tr>
				<th>
					아나운서 ID
				</th>
				<th>
					아나운서 NAME
				</th>
				<th>
					아나운서 AGE
				</th>
				<th>
					수정
				</th>
				<th>
					삭제
				</th>
			</tr>
		<thead>
		<tbody>
		<%
			for(Anaunseo anaunseo : list){
		%>
				<tr>
					<td>
						<%= anaunseo.getAnaunseoId() %>
					</td>
					<td>
						<%= anaunseo.getAnaunseoName() %>
					</td>
					<td>
						<%= anaunseo.getAnaunseoAge() %>
					</td>
					<td>
						<a href = "<%= request.getContextPath() %>/updateAnaunseoFrom.jsp?anaunseoId=<%= anaunseo.getAnaunseoId() %>">수정</a>
					</td>
					<td>
						<a href = "<%= request.getContextPath() %>/deleteAnaunseoAction.jsp?anaunseoId=<%= anaunseo.getAnaunseoId() %>">삭제</a>
					</td>
				</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>