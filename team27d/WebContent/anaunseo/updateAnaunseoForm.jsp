<!-- team27d [���Ḳ] -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.AnaunseoDao" %>
<%@ page import = "service.Anaunseo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>updateAnaunseoFrom.jsp</title>
		<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
				$("#updateButton").click(function(){
					/* Ÿ�� �׽�Ʈ */
					console.log("-------------------------");
					console.log("$('#anaunseoName').val() : " + jQuery.type($("#anaunseoName").val()));
					console.log("$('#anaunseoAge').val() : " + jQuery.type($("#anaunseoAge").val()));
					
					/* 2�� �̸� �̸� �Է� ���� */
					if($("#anaunseoName").val().length < 2){
						$("#helper").text("�̸��� 2�� �̻� �Է��ϼ���.");
						return ;
					/* 
						isNaN(is Not a Number) : ���ڰ� �ƴ� ��� true �����Ѵ�.
						��, ���������� ���ڿ��̳� ���ڰ� ������ �ȵ����� ��� "���̸� �Է��ϼ���." ��� �޽����� ��Ÿ����.
						����, �����Է¶��� �������� ���ܵΰ� ��ư�� �����ٸ� "���̸� �Է��ϼ���." ��� �޽����� ��Ÿ���� �Ͽ���.
					*/
					}else if(isNaN($("#anaunseoAge").val()) || $("#anaunseoAge").val() === ""){
						$("#helper").text("���̸� �Է��ϼ���.");
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
					<th>�Ӽ�</th>
					<th>�Է¶�</th>
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
						<td>���̵�</td>
						<td><input id = "anaunseoId" type = "text" name = "anaunseo_id" value = "<%= anaunseo.getAnaunseoId() %>" readonly></td>	
					</tr>
					<tr>
						<td>�̸�</td>
						<td><input id = "anaunseoName" type = "text" name = "anaunseo_name" value = "<%= anaunseo.getAnaunseoName() %>"></td>
					</tr>
					<tr>
						<td >����</td>
						<td><input id = "anaunseoAge" type = "text" name = "anaunseo_age" value = "<%= anaunseo.getAnaunseoAge() %>"></td>
					</tr>
					<tr>
						<td colspan = "2">
							<button id = "updateButton" type = "button">������ư</button>
							<!-- <input type = "submit" value = "������ư"> -->
						</td>
					</tr>
				</tbody>
			</form>
		</table>
		<div>
			<span id = "helper"></span>
		</div>
	</body>
</html>
	