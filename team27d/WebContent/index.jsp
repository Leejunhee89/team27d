<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
      <li><a href="<%= request.getContextPath() %>/#/#">actor list</a></li> 
      <li><a href="<%= request.getContextPath() %>/#/#">actoress list</a></li> 
      <li><a href="<%= request.getContextPath() %>/#/#">anaunseo list</a></li> 
      <li><a href="<%= request.getContextPath() %>/#/#">comedian list</a></li>
      <li><a href="<%= request.getContextPath() %>/#/#">rapper list</a></li>
      <li><a href="<%= request.getContextPath() %>/singerList.jsp">singer list</a></li>
   </ul>   
</body>
</html>