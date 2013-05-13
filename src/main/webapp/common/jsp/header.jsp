<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- use errorPage attribute for error handling-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- main page use it??? -->
<%
	String path = request.getContextPath();
	//get project whole address, if your project's name is MyApp, so the whole address is http://localhost:8080/MyApp/.
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	System.out.println("basePath:"+basePath);
%>
