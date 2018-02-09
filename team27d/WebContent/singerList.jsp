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

<!-- SingerDao의 주소가 할당된 singerdao를 선언. Singer의 배열을 list로 선언 list를 통해 SingerDao.java 안의 selectSingerList()메서드 호출
	SingerDao 페이지 import > SingerDao.java를 singerList.jsp에서 사용하기 위해. (SingerDao.java의 주소를 담고 있는 객체참조변수 singerdao를 생성하기 위해)
	ArrayList 페이지 import > 
  -->

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
		<%
			}
		%>
	</table> 
</body>
</html>