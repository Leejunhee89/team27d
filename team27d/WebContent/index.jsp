<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table> 
		   <tr>   
		      <td>���� : team27d</td><br>
		   </tr>
		   <tr>
		      <td>���� :������ ����: actor,actoress CRUD</td>
		   </tr>
		   <tr>
		      <td>���� :���Ḳ ����: anaunseo CRUD</td>
		   </tr>
		   <tr>
		      <td>���� :��ο� ����: comedian CRUD</td>
		   </tr>
		   <tr>
		      <td>���� :����ȭ ����: rapper CRUD</td>
		   </tr>
		   <tr>
		      <td>���� :������ ����: singer CRUD</td>
		   </tr>
		</table>
   

   <ul>
      <li><a href="<%= request.getContextPath() %>/actorList.jsp">actor list</a></li> 
      <li><a href="<%= request.getContextPath() %>/actressList.jsp">actoress list</a></li> 
      <li><a href="<%= request.getContextPath() %>/announcerList.jsp">anaunseo list</a></li> 
      <li><a href="<%= request.getContextPath() %>/comedianList.jsp">comedian list</a></li>
      <li><a href="<%= request.getContextPath() %>/rapperList.jsp">rapper list</a></li>
      <li><a href="<%= request.getContextPath() %>/singerList.jsp">singer list</a></li>
   </ul>   

</body>
</html>