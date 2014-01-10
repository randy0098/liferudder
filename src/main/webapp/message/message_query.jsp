<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/header.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- place base in head area -->
<!-- all relative URLs in page are no longer base on browser, but are all base on basePath! -->
<base href="<%=basePath%>">
<script type="text/javascript" src="common/js/include.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>短信记录查询</title>
<style type="text/css">
form {
	width: 100%;
	height: 100%;
	border:1px solid orange
}

.query_table {
	width: 100%;
	height: 20%;
	/*border:1px solid green*/
}

.result_table {
	width: 100%;
	/*border:1px solid red*/
}

</style>

<script type="text/javascript">

	$(function() {
		jQuery("#list2").jqGrid({
			url : 'http://localhost:8080/lifeRudder2/message_queryAjax',
			datatype : "json",
		    jsonReader : { 
				root: "records", 
				page: "currentPageIndex", 
				total: "totalPage", 
				records: "recordNum", 
				repeatitems: false,
				id: "id"
			},
			prmNames : {
				page : "pager1"
			},
			colNames : [ 'id', 'sender', 'receiver', 'content', 'msg_time' ],
			colModel : [ {
				name : 'id',
				index : 'id',
				width : 55
			}, {
				name : 'sender',
				index : 'sender',
				width : 90,
				editable : true,
				editoptions : {
					size : 20
				},
				editrules : {
					required : true
				}
			}, {
				name : 'receiver',
				index : 'receiver',
				width : 100
			}, {
				name : 'content',
				index : 'content',
				width : 80,
				align : "right"
			}, {
				name : 'msg_time',
				index : 'msg_time',
				width : 80,
				align : "right"
			} ],
			rowNum : 10,
			rowList : [ 10, 20, 30 ],
			pager : '#pager1',
			sortname : 'id',
			viewrecords : true,
			sortorder : "desc",
			caption : "JSON Example"
		});
		
		$("#button1").click(function(){
			jQuery("#list2").jqGrid('editGridRow', "new", {
				height : 280
			});
		});
	})
</script>
</head>
<body>
		<form action="message_query" name="f1" method="post">
		<table class="query_table">
			<tr>
				<td>sender：</td>
				<td>
					<input type="text" name="sender" value="${param.sender}">
					<input type="hidden" name="option" value="sender-eq">
				</td>
				<td>receiver：</td>
				<td>
					<input type="text" name="receiver" value="${param.receiver}">
					<input type="hidden" name="option" value="receiver-like">
				</td>
			</tr>
			<tr>
				<td>msg_time：</td>
				<td>
					<input type="text" name="mintime" value="${param.mintime}">至：<input type="text" name="maxtime" value="${param.maxtime}">
					<input type="hidden" name="option" value="mintime-ge">
					<input type="hidden" name="option" value="maxtime-le">
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: center" >
					<input type="submit" value="查询">
					<input type="reset" value="重填">
				</td>
			</tr>
		</table>
		
		<a href="message/message_insert.jsp" style="float: right">增加</a>
		<table class="result_table" border="1">
			<tr><th>id</th><th>sender</th><th>receiver</th><th>content</th><th>msg_time</th><th>操作</th></tr>
			<c:forEach var="message" items="${page.records}">
				<tr>
					<td>${message.id}</td>
					<td>${message.sender}</td>
					<td>${message.receiver}</td>
					<td>${message.content}</td>
					<td>${message.msg_time}</td>
					<td>
						<a href="message_selectOne?id=${message.id}"/>修改</a>
						<a href="message_delete?id=${message.id}" onclick="return confirm('确定删除此记录？')">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6">
				<!-- 
					<ul class="pager">
						<li><a href="#">上一页</a></li>
						<li><a href="#">下一页</a></li>
					</ul> 
				-->	
					<a href="" onclick="paging('goToFirst');return false">首页</a>
					<a href="" onclick="paging('goToLast');return false">尾页</a>
					<a href="" onclick="paging('back');return false">上一页</a>
					<a href="" onclick="paging('next');return false">下一页</a>
					转到第<input type="text" id="pageIndex"/>页
					<input type="button" value="go" onclick="paging('go')" class="btn btn-default btn-xs"/>
					每页显示${page.pageRecordNum}条
					第${page.currentPageIndex}/${page.totalPage}页			
				</td>
			</tr>
		</table>
	</form>
	<button id="button1">A button element</button>
	<table id="list2"></table>
	<div id="pager1"></div>
</BODY>
</body>
</html>
