<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ include file="/common/jsp/header.jsp"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- place base in head area -->
<!-- all relative URLs in page are no longer base on browser, but are all base on basePath! -->
<base href="<%=basePath%>">
<script type="text/javascript" src="common/js/include.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增短信信息</title>
</head>
<style type="text/css"> 
/*
	label.error	
	{
	    color: red;
	    padding-left: 20px;
	}
	input.error
	{
    	border: red;
	}
*/

.myform {
	width:800px;
	margin:30px auto;
	text-align:left;
	border:#a6c9e2 solid 1px;
}

label {
	width:120px;
	float:left;
	text-align:right;
	font-weight:bold;
	color:#217bc0;
}
	
input {
	margin-left: 80px;
	width:400px;
}	

textarea {
	margin-left: 80px;
	width:400px;
}

button {
	height:40px;
	width:45px;
	margin-left:40px;
}

</style>

<script type="text/javascript">
	$(document).ready(function() {
/*		
		$("#form1").validate({
			rules : {
				sender : {
					required : true
				},
				receiver : {
					required : true
				},
				content : {
					required : true
				}
			},
			messages : {
				sender : {
					required : "发送者名称不能为空",
				},
				receiver : {
					required : "接收者名称不能为空",
				},
				content : {
					required : "发送者名称不能为空",
				},
			}
		});
*/
		
		$('#save').button();
		$('#back').button();
	});
	
	function saveAndClose(){
		form1.submit();
		$("#initMethods").val("closePage('addPage')");
	}
</script>
<body>
	<form id="form1" action="message_insert" method="post" target="mainFrame">
		<div class="myform">
			<div class="ui-widget-header">新增短信信息</div>
			<div class="myform_content">
				<p>
					<label for="sender">发送者：</label> 
					<input type="text" id="sender" name="sender"> 
				</p>
				<p>
					<label for="receiver">接收者：</label> 
					<input type="text" id="receiver" name="receiver"> 
				</p>
				<p>
					<label for="content">内容：</label>
					<textarea rows="3" cols="30" id="content" name="content"></textarea>
				</p>
				<p class="center">
					<button type="submit" id="save" onclick="saveAndClose()" style="width:110px">保存并关闭</button>
					<button type="button" id="back" onclick="closePage('addPage')">返回</button>
				<p>
				<input type="hidden" name="id"> 
				<input type="hidden" name="msg_time">
			</div>
		</div>
		<input type="hidden" id="initMethods" name="initMethods">	
	</form>
</body>
</html>

