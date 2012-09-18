<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- use errorPage attribute for error handling-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- main page use it??? -->
<%
	String path = request.getContextPath();
	//get project whole address, if your project's name is MyApp, so the whole address is http://localhost:8080/MyApp/.
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
	System.out.println("basePath:"+basePath);
%>

<!-- jquery -->
<script type="text/javascript" src="plugins/jquery-1.7.2/dev/jquery-1.7.2.js"></script>

<!-- jquery ui -->
<script src="plugins/jquery-ui-1.8.22/dev/jquery-ui-1.8.22.custom.js"></script>

<!-- jquery ui:datepicker -->
<script src="plugins/jquery-ui-1.8.22/dev/i18n/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>

<!-- jquery ui theme: redmond -->
<link rel="stylesheet" href="themes/dev/redmond/jquery-ui-1.8.22.custom.css">

<!-- jquery.jqGrid -->
<script src="plugins/jquery.jqGrid-4.4.0/i18n/grid.locale-cn.js" type="text/javascript"></script>
<script src="plugins/jquery.jqGrid-4.4.0/js/jquery.jqGrid.src.js" type="text/javascript"></script>
<script src="plugins/jquery.jqGrid-4.4.0/plugins/ui.multiselect.js" type="text/javascript"></script>
<script src="plugins/jquery.jqGrid-4.4.0/plugins/jquery.tablednd.js" type="text/javascript"></script>
<script src="plugins/jquery.jqGrid-4.4.0/plugins/jquery.contextmenu.js" type="text/javascript"></script>

<!-- jquery.layout-->
<SCRIPT type="text/javascript" src="plugins/jquery-layout-1.3.0-rc30.6/dev/jquery.layout-latest.js"></SCRIPT>