<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<table border="1"> 
		   <tr>   
		      <td>���� : team27d</td><td>����</td>
		   </tr>
		   <tr>
		      <td>���� :������ ����: actor,actoress CRUD</td>
		      <td><img src="<%= request.getContextPath() %>/image/niche.jpg" width="100" height="150"> </td>
		   </tr>
		   <tr>
		      <td>���� :���Ḳ ����: anaunseo CRUD</td>
		      <td><img  src="<%= request.getContextPath() %>/image/tam.jpg" width="100" height="150"> </td>
		   </tr>
		   <tr>
		      <td>���� :��ο� ����: comedian CRUD</td>
		      <td><img  src="<%= request.getContextPath() %>/image/rabbit.jpg" width="100" height="150"> </td>
		   </tr>
		   <tr>
		      <td>���� :����ȭ ����: rapper CRUD</td>
		      <td><img  src="<%= request.getContextPath() %>/image/Yadon.jpg" width="100" height="150"> </td>
		   </tr>
		   <tr>
		      <td>���� :������ ����: singer CRUD</td>
		      <td><img  src="<%= request.getContextPath() %>/image/kong.JPG" width="100" height="150"> </td>
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