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

.page_function_button{
	float:right;
	height:36px;
	width:46px;
}
</style>

<script type="text/javascript">
/*
//获取浏览器显示区域的高度 
alert($(window).height()); 
//获取浏览器显示区域的宽度 
alert($(window).width()); 

//获取页面的文档高度 
alert($(document.body).height()); 
//获取页面的文档宽度 
alert($(document.body).width()); 
*/

//alert($(window).height()); //浏览器当前窗口可视区域高度 
//alert($(document).height()); //浏览器当前窗口文档的高度 
//alert($(document.body).height());//浏览器当前窗口文档body的高度 
//alert($(document.body).outerHeight(true));//浏览器当前窗口文档body的总高度 包括border padding margin 
//alert($(window).width()); //浏览器当前窗口可视区域宽度 
//alert($(document).width());//浏览器当前窗口文档对象宽度 
//alert($(document.body).width());//浏览器当前窗口文档body的高度 
//alert($(document.body).outerWidth(true));//浏览器当前窗口文档body的总宽度 包括border padding margin 

 function insertRecord(){
	 //location.href = "message/message_insert.jsp";
	 newPage("<iframe id='editFrame' src='message/message_insert.jsp'  target='_parent' frameborder='0' scrolling='no' width='1000px' height='800px'/>");
 }
 
 function updateRecord(){
	 var boxes = $("input:checked");
	 var size = boxes.size();
	 if(size == 0){
		 alertMsg("请选中一条记录信息进行修改！");
/*		 
		 alert("请选中一条记录信息进行修改！");
		 $("<div>请选中一条记录信息进行修改！</div>").dialog({
			  position: [$(window).width()/2-$(window).height()*0.2,150],
		      modal: true,
		      resize: false,
		      width: "auto",
		      buttons: {
		        Ok: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		 });
*/		 
	 }else if(size > 1){
		 alertMsg("只能选择一条记录信息进行修改！");
	 }else if(size == 1){
		 location.href = "message_selectOne?id="+boxes.val();
	 }
 }
 
 function deleteRecord(){
	 var boxes = $("input:checked");
	 var size = boxes.size();
	 if(size == 0){
		 alertMsg("请选中一条记录信息进行删除！");
	 }else{
		 var result = confirm('确定删除此记录？')
		 var ids = "";
		 if(result == true){
			 boxes.each(
				 function(){
					 ids = ids + "," + $(this).val();
				 } 
			 );
			 location.href = "message_deleteAll?ids="+ids;
		 }
	 }
 }
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
			<table id="result_table" class="result_table">
				<button type="button" name="delete" onclick="deleteRecord()" class="page_function_button">删除</button>
				<button type="button" name="update" onclick="updateRecord()" class="page_function_button">修改</button>
				<button type="button" name="insert" onclick="insertRecord()" class="page_function_button">增加</button>
				<caption class="ui-widget-header">短信记录列表</caption>
				<tr><th data-resizable-column-id="checkbox"></th><th data-resizable-column-id="Id">Id</th><th data-resizable-column-id="Sender">Sender</th><th data-resizable-column-id="Receiver">Receiver</th><th data-resizable-column-id="Content">Content</th><th data-resizable-column-id="Msg_time">Msg_time</th></tr>
				<c:forEach var="message" items="${page.records}">
					<tr>
						<td><input type="checkbox" name="checkbox" value=${message.id}></td>
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
							<button type="button" name="goToFirst" onclick="paging(this,'goToFirst')">首页</button>
							<button type="button" name="back" onclick="paging(this,'back',${page.currentPageIndex})">上一页</button>
							<button type="button" name="next" onclick="paging(this,'next',${page.currentPageIndex})">下一页</button>
							<button type="button" name="goToLast" onclick="paging(this,'goToLast')">尾页</button>
							转到第<input type="text" name="pageIndex" size="1" maxlength="3"/>页<button type="button" name="go" onclick="paging(this,'go')" style="height:28px;width:46px">go</button>
						</div>
						<div class="pager_display">每页显示${page.pageRecordNum}条&nbsp第${page.currentPageIndex}/${page.totalPage}页</div>
						<input type="hidden" id="currentPageIndex" value="${page.currentPageIndex}">
						<input type="hidden" id="lastPageIndex" value="${page.totalPage}">
					</td>
				</tr>
			</table>
<!-- 			
			<t:grid property="page" keys="id">
				<t:cell caption="Id" property="id"/>
				<t:cell caption="Sender" property="sender"/>
				<t:cell caption="Receiver" property="receiver"/>
			</t:grid>
-->			
		</div>
	</form>
</BODY>
</body>
</html>
