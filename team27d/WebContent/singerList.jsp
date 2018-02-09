<!-- team27d[나윤주] -->
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

<!-- SingerDao의 주소가 할당된 singerdao변수를 선언. Singer의 배열을 list로 선언 list를 통해 SingerDao.java 안의 selectSingerList()메서드 호출  -->

<html>
<body>
	<table>
		<tr>
		<th>id</th><th>name</th><th>age</th>
		</tr> 
		
		<%
			for(Singer sin : list){
		%>
		<tr>
		<td><%=sin.getSingerId()%></td><td><%=sin.getSingerName()%></td><td><%=sin.getSingerAge()%></td>
		</tr>
		<!-- for절을 이용해 Singer list를 호출 -->
		<%
			}
		%>
	</table> 
</body>
</html>