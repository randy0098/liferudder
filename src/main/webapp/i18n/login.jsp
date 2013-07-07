<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%> 
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title><s:text name="loginPage"/></title>  
    </head>  
      
    <body>  
        <form action="loginTest" method="post">  
           <s:textfield name="username" key="user"></s:textfield>
           <s:textfield name="password" key="pass"></s:textfield>
           <s:submit key="login"></s:submit>
        </form>  
    </body>  
</html>  