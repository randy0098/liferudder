<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/header.jsp"%> 	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
</head>
<body>
	<form action="login.do?method=login" method="post">
		用户名：<input name="name"><br /> 
		密码：<input type="password" name="password"><br/> 
		<input type="submit" value="提交">
		<input type="reset" value="重置">
	</form>
</body>
</html>