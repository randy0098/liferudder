<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/header.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- place base in head area -->
<!-- all relative URLs in page are no longer base on browser, but are all base on basePath! -->
<base href="<%=basePath%>">
<script type="text/javascript" src="common/js/include.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="lifeRudder" /></title>
<decorator:head />
<style type="text/css">
	<%--body {height:100%}--%>
	.logo {border:solid 1px red; width:100%; height:150px}
	.menu_left {border:solid 1px green; width:10%; height:800px; float:left}
	.content {border:solid 1px brown; width:100%; height:800px;margin:0px;padding:0px;}
	.footer {border:solid 1px blue; width:100%; height:150px}
</style>
</head>
<body>
	<div class="logo"><%@ include file="/common/jsp/logo.jsp"%></div>
	<div class="menu_left"><%@ include file="/common/jsp/menu_left.jsp"%></div>
	<div class="content"><decorator:body /></div>
	<!--<div class="footer">footer</div>-->
</body>
</html>