<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title><s:text name="loginPage" /></title>
<style type="text/css">
<%--
.align-center {
	margin: 0 auto;
	width: 500px;
	height: 500px;
	text-align: center;
	position: absolute;
	left: 50%;
	top: 50%;
	margin: -150px 0 0 -250px;
	/*border: 1px solid;
	border-color: blue;*/
}
body {font-size:1.5em}
--%>
</style>
<link href="common/css/login.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="align-center">
		<s:form action="login" theme="simple" method="post">
			<table width="500px" height="250px" border="1" rules="none">
				<tr>
					<td width="30%">用户名：</td>
					<td><s:textfield name="username" style="width:90%;height:30px;font-size:1em"/></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><s:password name="password" style="width:90%;height:30px;font-size:1em"/></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit key="login" style="width:80px;height:40px;font-size:1em"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:reset key="reset" style="width:80px;height:40px;font-size:1em"/>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>