<%@ tag pageEncoding="Big5" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag import="java.util.Date,java.lang.reflect.Field" %>
<%
	System.out.println("className: " + getParent().getClass().getName());
	Field field = this.getParent().getClass().getDeclaredField("children");
%>
<jsp:doBody/>