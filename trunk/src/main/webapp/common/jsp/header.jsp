<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）: 
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	System.out.println("basePath:"+basePath);
%>
<html>
<head>
<!-- base需要放到head中 -->
<!-- 页面上所有相对路径不再相对于浏览器路径，而是全部相对于basePath！ -->
<base href="<%=basePath%>">
</head>
<link rel="stylesheet" href="themes/redmond/jquery.ui.all.css">
<script type="text/javascript" src="common/jquery-1.7.2.js"></script>
<script src="common/ui/jquery-ui-1.8.22.custom.js"></script>
<!-- <link rel="stylesheet" href="themes/global.css"> -->