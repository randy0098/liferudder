<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/header.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="common/js/include.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><decorator:title default="lifeRudder" /></title>
<decorator:head />
<style type="text/css">
html,body{
	height:100%;
}
</style>
</head>
<body>
	<div class="container-fluid" style="height:100%">
		<div class="navbar navbar-default navbar-static-top" role="navigation" style="height:10%;">
			<div class="col-lg-12" style="border:solid 1px red;height:100%">
				<%@ include file="/common/jsp/logo.jsp"%>
			</div>
		</div>
		<div class="row-fluid" style="height:90%">
			<div class="col-lg-2" style="border:solid 1px green;height:100%">
				<%@ include file="/common/jsp/menu_left.jsp"%>
			</div>
			<div class="col-lg-10" style="border:solid 1px blue;height:100%">
				<decorator:body />
			</div>
		</div>
	</div>
</body>
</html>