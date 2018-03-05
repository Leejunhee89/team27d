<!-- team27d [이춘림] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>insertAnnouncerForm.jsp</title>
		<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#insertButtion").click(function(){
					/* 2자 미만 이름 입력 막기 */
					/*
					if($("#anaunseoName").val().length < 2){
						$("#helper").text("이름을 2자 이상 입력하세요.");
						//return ;
					}else {
						$("#helper").text("");
					}
					*/
					 	
					/* if( isNaN($("anaunseoAge").val()) ){
						$("#helper").text("문자.");
					}else{
						$("#helper").text("숫자");
					} */
					
					if(typeof $("anaunseoAge").val() === 'number' && isFinite($("anaunseoAge").val())){
						$("#helper").text("숫자");
					}/* else{
						$("#helper").text("문자");
					} */
					
				});
			});
		</script>
	</head>
	<body>
		<%
			System.out.println("===== insertAnnouncerForm.jsp =====");
		%>
		<h3>아나운서 등록</h3>
		<hr>
		<form id = "announcerForm" method = "post" action = "<%= request.getContextPath() %>/anaunseo/insertAnnouncerAction.jsp" enctype = "application/x-www-form-urlencoded">
			<table border = "1">
				<thead>
					<tr>
						<th>속성</th>
						<th>입력란</th>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<td>이름</td>
						<td><input id = "anaunseoName" type = "text" name = "anaunseo_name"></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input id = "anaunseoAge" type = "text" name = "anaunseo_age"></td>
					</tr>
					<tr>
						<td colspan = "2">
							<button id = "insertButtion" type = "button">등록버튼</button>
						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<span id = "helper"></span>
			</div>
		</form>
	</body>
</html>




















