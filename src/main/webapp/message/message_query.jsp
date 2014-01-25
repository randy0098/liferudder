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
	height: 100%;
	/*border:1px solid orange*/
}

table{
	width: 100%;
	border:#a6c9e2 solid 1px;
}

table caption{
	text-align:left;
	padding-left:5px;
}

button {
	height:25px;
	width:25px;
}

.query_table {
	height: 20%;
	/*border:1px solid green*/
}

.result_table th,.result_table td{
	border:#a6c9e2 solid 1px;
}

.result_table th,.pager{
	text-align:center;
	background-color:#e3f1fc;
	color:#217bc0;
}


</style>

<script type="text/javascript">
	//删除时进行确认
	function deleteCheck(){
		return confirm("确定删除此记录？");
	}
	
	//分页跳转
	function paging(action){
		var url = "message_query?action=";
		//首页
		if(action == "goToFirst"){
			url = url + "goToFirst";
		}
		//尾页
		else if(action == "goToLast"){
			url = url + "goToLast";
		}
		//上一页
		else if(action == "back"){
			url = url + "back&currentPageIndex="+${page.currentPageIndex};
		}
		//下一页
		else if(action == "next"){
			url = url + "next&currentPageIndex="+${page.currentPageIndex};
		}
		//转到第几页
		else if(action == "go"){
			var pageIndex = document.getElementById("pageIndex").value;
			if(isNaN(parseInt(pageIndex)) == true){
				alert("请输入正确的页数！");
				return;
			}else{
				url = url + "go&currentPageIndex="+pageIndex;
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
		<table class="result_table">
			<caption class="ui-widget-header">短信记录列表</caption>
			<tr><th>Id</th><th>Sender</th><th>Receiver</th><th>Content</th><th>Msg_time</th><th>操作</th></tr>
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
				<td colspan="6" >
					<div style="width:60%;float:left;text-align:right">
						<button id="goToFirst" onclick="paging('goToFirst')">首页</button>
						<button id="back" onclick="paging('back')">上一页</button>
						<button id="next" onclick="paging('next')">下一页</button>
						<button id="goToLast" onclick="paging('goToLast')">尾页</button>
						转到第<input type="text" id="pageIndex"/>页<button id="go" onclick="paging('go')" style="height:28px;width:46px">go</button>
					</div>
					<div style="width:40%;float:right;text-align:right;">每页显示${page.pageRecordNum}条&nbsp第${page.currentPageIndex}/${page.totalPage}页</div>
				</td>
			</tr>
		</table>
	</form>
</BODY>
</body>
</html>
