<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<%@ page import = "sevice.SingerDao" %>

<% 
	
SingerDao singerdao = new SingerDao();
ArrayList<Singer> get_list = singerdao.selectSingerList();



%>
		

