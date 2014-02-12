<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LifeRudder</title>
<style type="text/css">
	.container {
		width:1800px;
		height:1000px;
	}
	.header {
		height:10%;
		border:solid 1px yellow;
	}
	
	.menu_left {
		border:solid 1px blue;
		height:90%;
		width:10%;
		float:left;
	}
	
	.content_iframe {
		border:solid 1px red;
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
		<IFRAME id="" frameBorder="1" src="message_query" name="mainFrame" scrolling="no" class="content_iframe"></IFRAME>
	</div>
</body>
</html>