<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="common/js/include.js"></script>
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

body {
  padding-top: 240px;
  padding-bottom: 40px;
  background-color: #eee;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  <%-- 横向居中对齐 --%>
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  font-size: 16px;
  height: auto;
  padding: 10px;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
<link href="common/css/login.less" type="text/css" rel="stylesheet/less">
</head>
<body>
<!-- 
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
 -->	
 
	<div class="container">
      <form class="form-signin" action="login" role="form" method="post">
        <h2 class="form-signin-heading">请输入用户名和密码</h2>
        <input type="text" name="username" class="form-control" placeholder="用户名" required autofocus>
        <input type="password" name="password" class="form-control" placeholder="密码" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
      </form>
    </div>
</body>
</html>