<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>类型转换的错误处理</title>
	<s:head/>
</head>
<body>
<s:fielderror />
<h3>类型转换的错误处理</h3>
<s:form action="loginAction" validate="true">
	<s:textfield name="username" key="user"/>
	<s:textfield name="password" key="pass"/>
	<s:submit key="login"/>
</s:form>
</body>
</html>
