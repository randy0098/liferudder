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
<style type="text/css"> 
	li{
	    list-style:none;      /*去掉li前的点*/
	    margin-left:20px;     /*调整距离*/
	}
</style>
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
				<ul style="border: 1;width: 100%;margin: 0;padding: 0">
					<a href="" onclick="return false">菜单1</a>
					<li><a href="" id="message.do?method=message_query" onclick="return false">子菜单1</a></li>
					<li>子菜单2</li>
				</ul>
				<ul style="border: 1;width: 100%;margin: 0;padding: 0">
					<a href="" onclick="return false">菜单2</a>
					<li>子菜单3</li>
					<li>子菜单4</li>
				</ul>
			</div>
			<IFRAME id="content" class="ui-layout-center" height="600" frameBorder="0" width="100%" name="mainFrame" scrolling="no"></IFRAME>
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
	
	$(document).ready(function(){
	    var as=$("ul>a");
	    as.click(function(){
	       //这里需要找到ul中的li，然后让li显示出来
	        var aNode=$(this);
	        var lis=aNode.nextAll("li");
	        //toggle()方法，改变显示状态
	        lis.toggle();
	    });
	    
	    //display iframe content dynamically
	    $("li>a").click(function(){
	       $("#content").attr("src",$(this).attr("id"));
	    });
	});
</script>