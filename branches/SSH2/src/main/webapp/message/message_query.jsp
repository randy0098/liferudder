<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.crazyit.org/mytaglib" prefix="mytag"%>	
<%@ taglib prefix="JSPBook" tagdir="/WEB-INF/tags/" %>
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
/*border:1px solid red;*/

table{
	width:100%;
	border:#a6c9e2 solid 1px;
	border-collapse:collapse;/*表格的边框合并为一个单一的边框*/
}

table caption{
	text-align:left;
	padding-left:5px;
}

.query_table {
	height: 20%;
}

.result_table th,.result_table td{
	border:#a6c9e2 solid 1px;
}

.result_table th,.pager{
	text-align:center;
	background-color:#e3f1fc;
	color:#217bc0;
}

.pager_navigator{
	width:60%;
	float:left;
	text-align:right;
}

.pager_display{
	width:40%;
	float:right;
	text-align:right;
	margin-top:4px;/*垂直居中显示*/
}

</style>

<script type="text/javascript">
//分页跳转
function paging(action) {
	var url = "message_query?action=";
	// 首页
	if (action == "goToFirst") {
		url = url + "goToFirst";
	}
	// 尾页
	else if (action == "goToLast") {
		url = url + "goToLast";
	}
	// 上一页
	else if (action == "back") {
		url = url + "back&currentPageIndex=" + ${page != null ? page.currentPageIndex : 0};
	}
	// 下一页
	else if (action == "next") {
		url = url + "next&currentPageIndex=" + ${page != null ? page.currentPageIndex : 0};
	}
	// 转到第几页
	else if (action == "go") {
		var pageIndex = document.getElementById("pageIndex").value;
		if (isNaN(parseInt(pageIndex)) == true) {
			alert("请输入正确的页数！");
			return;
		} else {
			url = url + "go&currentPageIndex=" + pageIndex;
		}
	}
	f1.action = url;
	f1.submit();
}

$(function() {
	$('#goToFirst').button({text:false,icons:{primary:'ui-icon-seek-first'}});
	$('#goToLast').button({text:false,icons:{primary:'ui-icon-seek-end'}});
	$('#back').button({text:false,icons:{primary:'ui-icon-seek-prev'}});
	$('#next').button({text:false,icons:{primary:'ui-icon-seek-next'}});
	$('#go').button();
	$(':submit').button();
	$(':reset').button();
	
	//控制按钮显示
	var currentPageIndex = ${page!=null?page.currentPageIndex:0};
	var lastPageIndex = ${page!=null?page.totalPage:0};
	//页面初始化时禁用所有按钮
	if(currentPageIndex == 0){
		$('#goToFirst').button('disable');
		$('#goToLast').button('disable');
		$('#back').button('disable');
		$('#next').button('disable');
		$('#go').button('disable');
		$('#pageIndex').attr("disabled",true);
	}
	//在首页时
	else if(currentPageIndex == 1){
		$('#goToFirst').button('disable');
		$('#goToLast').button('enable');
		$('#back').button('disable');
		$('#next').button('enable');
		$('#pageIndex').attr("disabled",false);
	}
	//在尾页时
	else if(currentPageIndex == lastPageIndex){
		$('#goToFirst').button('enable');
		$('#goToLast').button('disable');
		$('#back').button('enable');
		$('#next').button('disable');
		$('#pageIndex').attr("disabled",false);
	}
	else{
		$('#goToFirst').button('enable');
		$('#goToLast').button('enable');
		$('#back').button('enable');
		$('#next').button('enable');
		$('#pageIndex').attr("disabled",false);
	}
	
	$("#result_table").resizableColumns({store:store});
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
				<td colspan="4" class="center">
					<input type="submit" value="查询">
					<input type="reset" value="重填">
				</td>
			</tr>
		</table>
		
		<div style="margin-top:20px">
			<a href="message/message_insert.jsp" style="float: right">增加</a>
<!-- 			
			<table id="result_table" class="result_table">
				<caption class="ui-widget-header">短信记录列表</caption>
				<tr><th data-resizable-column-id="Id">Id</th><th data-resizable-column-id="Sender">Sender</th><th data-resizable-column-id="Receiver">Receiver</th><th data-resizable-column-id="Content">Content</th><th data-resizable-column-id="Msg_time">Msg_time</th><th>操作</th></tr>
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
				<tr class="pager">
					<td colspan="6">
						<div class="pager_navigator">
							<button type="button" id="goToFirst" onclick="paging('goToFirst')">首页</button>
							<button type="button" id="back" onclick="paging('back')">上一页</button>
							<button type="button" id="next" onclick="paging('next')">下一页</button>
							<button type="button" id="goToLast" onclick="paging('goToLast')">尾页</button>
							转到第<input type="text" id="pageIndex" size="1" maxlength="3"/>页<button type="button" id="go" onclick="paging('go')" style="height:28px;width:46px">go</button>
						</div>
						<div class="pager_display">每页显示${page.pageRecordNum}条&nbsp第${page.currentPageIndex}/${page.totalPage}页</div>
					</td>
				</tr>
			</table>
 -->			
			<mytag:grid >
				<mytag:cell caption="Id" property="id"/>
				<mytag:cell caption="Sender" property="sender"/>
				<mytag:cell caption="Receiver" property="receiver"/>
			</mytag:grid>	
			<JSPBook:Parent>	
				<JSPBook:Child></JSPBook:Child>
			</JSPBook:Parent>
		</div>
	</form>
</BODY>
</body>
</html>