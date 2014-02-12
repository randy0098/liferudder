<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ include file="/common/jsp/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- place base in head area -->
<!-- all relative URLs in page are no longer base on browser, but are all base on basePath! -->
<base href="<%=basePath%>">
<script type="text/javascript" src="common/js/include.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LifeRudder个人管理系统</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LifeRudder</title>
<style type="text/css">
	.container {
		width:1800px;
		height:1000px;
		border:solid 1px #a6c9e2;
	}
	.header {
		height:10%;
		border-bottom:solid 1px #a6c9e2;
	}
	
	.menu_left {
		height:88%;
		width:10%;
		float:left;
		border-right:solid 1px #a6c9e2;
	}
	
	.content_iframe {
		height:90%;
		width:89%;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="header">
			<%@ include file="/common/jsp/logo.jsp"%>
		</div>
		<div class="menu_left">
			<%@ include file="/common/jsp/menu_left.jsp"%>
		</div>
		<IFRAME id="" frameBorder="0" src="message_query" name="mainFrame" scrolling="no" class="content_iframe"></IFRAME>
	</div>
</body>
</html>