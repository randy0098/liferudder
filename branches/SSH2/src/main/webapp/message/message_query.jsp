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
/*border:1px solid red;*/

.query_table {
	height: 20%;
}

</style>

<script type="text/javascript">
 function insertRecord(){
	 newPage("message/message_insert.jsp","addPage",{test:"123"});
 }
 
 function updateRecord(){
	 var boxes = $("input:checked");
	 var size = boxes.size();
	 if(size == 0){
		 alertMsg("请选中一条记录信息进行修改！");
	 }else if(size > 1){
		 alertMsg("只能选择一条记录信息进行修改！");
	 }else if(size == 1){
		 //location.href = "message_selectOne?id="+boxes.val();
		 newPage("message_selectOne?id="+boxes.val(),"updatePage",{test:"456"});
	 }
 }
 
 function deleteCheck(){
	 var boxes = $("input:checked");
	 var size = boxes.size();
	 if(size == 0){
		 alertMsg("请选中一条记录信息进行删除！");
	 }else{
		 confirmMsg("确定删除此记录？",deleteRecord);
	 }
 }
 
function deleteRecord(){
	var boxes = $("input:checked");
	var ids = "";
	boxes.each(
		function(){
			ids = ids + "," + $(this).val();
		} 
	);
	location.href = "message_deleteAll?ids="+ids;
}

</script>
</head>
<body>
	<form action="message_query" name="f1" method="post">
		<input type="hidden" id="initMethods" value="${initMethods}">
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
		
		<!--
			<table class="grid_table">
				<button type="button" name="delete" onclick="deleteCheck()" class="grid_button">删除</button>
				<button type="button" name="update" onclick="updateRecord()" class="grid_button">修改</button>
				<button type="button" name="insert" onclick="insertRecord()" class="grid_button">增加</button>
				<caption class="ui-widget-header">短信记录列表</caption>
				<tr><th data-resizable-column-id="checkbox"></th><th data-resizable-column-id="Id">Id</th><th data-resizable-column-id="Sender">Sender</th><th data-resizable-column-id="Receiver">Receiver</th><th data-resizable-column-id="Content">Content</th><th data-resizable-column-id="Msg_time">Msg_time</th></tr>
				<c:forEach var="message" items="${page.records}">
					<tr onclick="selectCheckbox(this)" onmouseover="mouseOverCheckbox(this)" onmouseout="mouseOutCheckbox(this)">
						<td><input type="checkbox" name="grid_checkbox" value=${message.id}></td>
						<td>${message.id}</td>
						<td>${message.sender}</td>
						<td>${message.receiver}</td>
						<td>${message.content}</td>
						<td>${message.msg_time}</td>
					</tr>
				</c:forEach>
				<tr class="pager">
					<td colspan="7">
						<div class="pager_navigator">
							<button type="button" name="goToFirst" onclick="paging(this,'goToFirst')" style="width:25px;height:25px">首页</button>
							<button type="button" name="back" onclick="paging(this,'back',${page.currentPageIndex})" style="width:25px;height:25px">上一页</button>
							<button type="button" name="next" onclick="paging(this,'next',${page.currentPageIndex})" style="width:25px;height:25px">下一页</button>
							<button type="button" name="goToLast" onclick="paging(this,'goToLast')" style="width:25px;height:25px">尾页</button>
							转到第<input type="text" name="pageIndex" size="1" maxlength="3"/>页<button type="button" name="go" onclick="paging(this,'go')" style="height:30px;width:40px">go</button>
						</div>
						<div class="pager_display">每页显示${page.pageRecordNum}条&nbsp第${page.currentPageIndex}/${page.totalPage}页</div>
						<input type="hidden" id="currentPageIndex" value="${page.currentPageIndex}">
						<input type="hidden" id="lastPageIndex" value="${page.totalPage}">
					</td>
				</tr>
			
		-->
			<t:grid property="page" keys="id" caption="短信记录列表">
				<t:button caption="删除" name="delete" onclick="deleteCheck()"/>
				<t:button caption="修改" name="update" onclick="updateRecord()"/>
				<t:button caption="增加" name="insert" onclick="insertRecord()"/>
				<t:cell caption="Id" property="id"/>
				<t:cell caption="Sender" property="sender"/>
				<t:cell caption="Receiver" property="receiver"/>
				<t:cell caption="Content" property="content"/>
			</t:grid>
	</form>
</BODY>
</body>
</html>
