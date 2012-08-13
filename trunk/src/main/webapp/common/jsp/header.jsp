<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<!-- jquery -->
<script type="text/javascript" src="plugins/jquery-1.7.2/jquery-1.7.2.js"></script>
<!-- jquery ui -->
<script src="plugins/jquery-ui-1.8.22/jquery-ui-1.8.22.custom.min.js"></script>
<!-- jquery ui theme: redmond-->
<link rel="stylesheet" href="themes/redmond/jquery.ui.all.css">
<script src="plugins/jquery-ui-1.8.22/i18n/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>
<!-- <link rel="stylesheet" href="themes/global.css"> -->
<!-- jquery.jqGrid-->
<script src="plugins/jquery.jqGrid-4.4.0/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="plugins/jquery.jqGrid-4.4.0/js/jquery.jqGrid.src.js" type="text/javascript"></script>
<script src="plugins/jquery.jqGrid-4.4.0/plugins/ui.multiselect.js" type="text/javascript"></script>
<script src="plugins/jquery.jqGrid-4.4.0/plugins/jquery.tablednd.js" type="text/javascript"></script>
<script src="plugins/jquery.jqGrid-4.4.0/plugins/jquery.contextmenu.js" type="text/javascript"></script>
<!-- jquery.layout-->
<SCRIPT type="text/javascript" src="plugins/jquery-layout-1.3.0-rc30.6/jquery.layout-latest.min.js"></SCRIPT>