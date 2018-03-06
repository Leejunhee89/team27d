<!-- team27d [이춘림] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateAnaunseoFrom.jsp</title>
		<script>
			$(document).ready(function(){
				$("#updateButton").click(function(){
					// 타입 테스트 
					console.log("-------------------------");
					console.log("$('#anaunseoName').val() : " + jQuery.type($("#anaunseoName").val()));
					console.log("$('#anaunseoAge').val() : " + jQuery.type($("#anaunseoAge").val()));
					
					//2자 미만 이름 입력 막기 
					if($("#anaunseoName").val().length < 2){
						$("#helper").text("이름을 2자 이상 입력하세요.");
						return ;
					
					}else if(isNaN($("#anaunseoAge").val()) || $("#anaunseoAge").val() === ""){
						$("#helper").text("나이를 입력하세요.");
						return ;
					}else{
						$("#helper").text("");
						$("#updateForm").submit();
					}
				});
			});
		</script>
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
				request.setCharacterEncoding("euc-kr");
				System.out.println("===== updateAnaunseoFrom.jsp =====");
				
				int anaunseoId = Integer.parseInt(request.getParameter("anaunseoId"));
				System.out.println("anaunseoId : " + anaunseoId);
				
				AnaunseoDao anaunseoDao = new AnaunseoDao();
				Anaunseo anaunseo = anaunseoDao.updateAnaunseoOne(anaunseoId);
			%>
			<form id = "updateForm" method = "post" action = "<%= request.getContextPath() %>/anaunseo/updateAnaunseoAction.jsp" enctype = "application/x-www-form-urlencoded">
				<tbody>
					<tr>
						<td>아이디</td>
						<td><input type = "text" name = "anaunseo_id" value = "<%= anaunseo.getAnaunseoId() %>" readonly></td>	
					</tr>
					<tr>
						<td id = "anaunseoName">이름</td>
						<td><input type = "text" name = "anaunseo_name" value = "<%= anaunseo.getAnaunseoName() %>"></td>
					</tr>
					<tr>
						<td id = "anaunseoAge">나이</td>
						<td><input type = "text" name = "anaunseo_age" value = "<%= anaunseo.getAnaunseoAge() %>"></td>
					</tr>
					<tr>
						<td colspan = "2">
							<button id = "updateButton" type = "button">수정버튼</button>
							<!-- <input type = "submit" value = "수정버튼"> -->
						</td>
					</tr>
				</tbody>
			</form>
		</table>
		<span id = "helper"></span>
	</body>
</html>
	
