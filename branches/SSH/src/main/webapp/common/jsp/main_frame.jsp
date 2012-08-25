<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ include file="/common/jsp/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- place base in head area -->
<!-- all relative URLs in page are no longer base on browser, but are all base on basePath! -->
<base href="<%=basePath%>">
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
		<!-- generate modules-->
		<UL style="-moz-border-radius-bottomleft: 0; -moz-border-radius-bottomright: 0;">
			<c:forEach var="module" items="${modules}" varStatus="status">
				<LI><A href="#tab_${status.index}" ><SPAN>${module.name}</SPAN></A></LI>
			</c:forEach>
		</UL>
		<!-- generate menus -->
		<c:forEach var="module" items="${modules}" varStatus="status">
			<DIV id="tab_${status.index}" style="border: 1;height: 100%; width: 100%;padding: 0;margin: 0">
				<div class="ui-layout-west">
					<!-- generate menu -->
					<c:forEach var="menus" items="${module.menus}">
						<ul style="border: 1;width: 100%;margin: 0;padding: 0">
							<a href="" onclick="return false">${menus.name}</a>
							<c:forEach var="menu" items="${menus.menu}">
								<li><a href="" index="${status.index}" id="${menu.href}" onclick="return false">${menu.name}</a></li>
							</c:forEach>
						</ul>
					</c:forEach>
				</div>
				<IFRAME id="content_${status.index}" class="ui-layout-center" height="600" frameBorder="0" width="100%" name="mainFrame" scrolling="no"></IFRAME>
			</DIV>
		</c:forEach>
	</div>
</BODY>
</body>
</html>
<script type="text/javascript">
	$('body').layout({ applyDefaultStyles: true });
	var tabs = $("[id^='tab_']");
	for(var i=0; i<tabs.length; i++){
		$('#tab_'+i).layout({ applyDefaultStyles: true });
	}
	$("#tabs_div").tabs();
	
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
	       var index = $(this).attr("index");
	       $("#content_"+index).attr("src",$(this).attr("id"));
	    });
	});
</script>