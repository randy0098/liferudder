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
<script type="text/javascript">
$(document).ready(function() {
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
			sender: {
				required: "发送者名称不能为空",
			},
			receiver: {
				required: "接收者名称不能为空",
			},
			content: {
				required: "发送者名称不能为空",
			},
		}
	});
});
</script>
<body>
	<form id="form1" action="message.do?method=message_insert" method="post">
		<table border="1" width="100%">
			<tr>
				<td width="30%">发送者：</td>
				<td width="70%"><input type="text" name="sender"></td>
			</tr>
			<tr>
				<td>接收者：</td>
				<td><input type="text" name="receiver"></td>
			</tr>	
			<tr>
				<td>内容：</td>
				<td><textarea rows="3" cols="30" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input type="submit" value="保存"></td>
			</tr>	
		</table>
		<input type="hidden" name="id">
		<input type="hidden" name="msg_time">	
	</form>
</body>
</html>

