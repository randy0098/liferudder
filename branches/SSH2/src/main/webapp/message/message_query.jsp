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
		$("[name='mintime']").datepicker();
		$("[name='maxtime']").datepicker();
/*		
		//test jqgrid
		jQuery("#list4").jqGrid({
			datatype: "local",
			height: 250,
		   	colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
		   	colModel:[
		   		{name:'id',index:'id', width:60, sorttype:"int"},
		   		{name:'invdate',index:'invdate', width:90, sorttype:"date"},
		   		{name:'name',index:'name', width:100},
		   		{name:'amount',index:'amount', width:80, align:"right",sorttype:"float"},
		   		{name:'tax',index:'tax', width:80, align:"right",sorttype:"float"},		
		   		{name:'total',index:'total', width:80,align:"right",sorttype:"float"},		
		   		{name:'note',index:'note', width:150, sortable:false}		
		   	],
		   	multiselect: true,
		   	caption: "Manipulating Array Data"
		});
		var mydata = [
				{id:"1",invdate:"2007-10-01",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"2",invdate:"2007-10-02",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"3",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
				{id:"4",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"5",invdate:"2007-10-05",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"6",invdate:"2007-09-06",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
				{id:"7",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"8",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"9",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"}
				];
		for(var i=0;i<=mydata.length;i++)
			jQuery("#list4").jqGrid('addRowData',i+1,mydata[i]);
*/		
	});
</script>
</head>
<body>
		<form action="message_query" name="f1" method="post">
		<table width="85%">
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
		<table border="1" width="85%">
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
					<a href="" onclick="paging('goToFirst');return false">首页</a>
					<a href="" onclick="paging('goToLast');return false">尾页</a>
					<a href="" onclick="paging('back');return false">上一页</a>
					<a href="" onclick="paging('next');return false">下一页</a>
					转到第<input type="text" id="pageIndex" onkeypress="return event.keyCode>=48&&event.keyCode<=57" onpaste="return !clipboardData.getData('text').match(/\D/)" ondragenter="return false" style="ime-mode:Disabled">页
					<input type="button" value="go" onclick="paging('go')">
					每页显示${page.pageRecordNum}条
					第${page.currentPageIndex}/${page.totalPage}页			
				</td>
			</tr>
		</table>
		<table id="list4"></table>
	</form>
</BODY>
</body>
</html>
