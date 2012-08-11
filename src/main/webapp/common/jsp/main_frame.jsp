<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/header.jsp"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LifeRudder个人管理系统</title>
</head>
<script type="text/javascript">
	$(document).ready(function () {
		
	});
</script>
<body>
 	<div class="ui-layout-north">
		<DIV class="header-footer ui-state-default ui-corner-all" style="text-align: center;">
			欢迎使用LifeRudder个人管理系统
		</DIV>
	</div>
	<div id="tabs_div" class="ui-layout-center">
		<UL style="-moz-border-radius-bottomleft: 0; -moz-border-radius-bottomright: 0;">
			<LI><A href="#tab_1"><SPAN>Tab 1</SPAN></A></LI>
			<LI><A href="#tab_2"><SPAN>Tab 2</SPAN></A></LI>
			<LI><A href="#tab_3"><SPAN>Tab 2</SPAN></A></LI>
		</UL>
		<DIV id="tab_1" style="border: 1;height: 100%; width: 100%;padding: 0;margin: 0">
			<div class="ui-layout-west">
				功能菜单
			</div>
			<IFRAME class="ui-layout-center" height="600" src="message/message_query.jsp" frameBorder="0" width="100%" name="mainFrame" scrolling="no"></IFRAME>
		</DIV>
		<DIV id="tab_2">2</DIV>
		<DIV id="tab_3">3</DIV>
	</div>
</BODY>
</body>
</html>
<script type="text/javascript">
	$('body').layout({ applyDefaultStyles: true });
	$("#tabs_div").tabs();
	$('#tab_1').layout({ applyDefaultStyles: true });
</script>