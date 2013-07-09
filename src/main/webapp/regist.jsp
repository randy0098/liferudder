<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>注册页面</title>  
    </head>  
    <body>
       <h2>请输入你的注册信息</h2>
       <s:fielderror/>
       <s:form action="register" method="post">
          <s:textfield name="name" label="用户名"></s:textfield>
          <s:textfield name="pass" label="密码"></s:textfield>
          <s:textfield name="age" label="年龄"></s:textfield>
          <s:textfield name="birth" label="生日"></s:textfield>
          <s:submit value="注册"></s:submit>
       </s:form>
    </body>  
</html>  