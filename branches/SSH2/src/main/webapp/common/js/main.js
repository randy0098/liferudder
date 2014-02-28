//删除时进行确认
function deleteCheck() {
	return confirm("确定删除此记录？");
}

function goBack() {
	history.go(-1);
}

//分页跳转
function paging(p,action,currentPageIndex) {
	//取form的Action用于翻页
	var form = $(p).parents("form");
	var formAction = form.attr("action");
	var url = formAction+"?action=";
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
		url = url + "back&currentPageIndex=" + currentPageIndex;
	}
	// 下一页
	else if (action == "next") {
		url = url + "next&currentPageIndex=" + currentPageIndex;
	}
	// 转到第几页
	else if (action == "go") {
		//取要翻到的页数
		var pageIndex = $(p).prev().val();
		if (isNaN(parseInt(pageIndex)) == true) {
			alert("请输入正确的页数！");
			return;
		} else {
			url = url + "go&currentPageIndex=" + pageIndex;
		}
	}
	form.attr("action",url);
	form.submit();
}



$(function() {
	//调用页面初始化的方法
	var initMethods = $("#initMethods").val();
	if(initMethods!=null&&initMethods!=""&&typeof(initMethods)!="undefined"){
		var initMethodsArray = initMethods.split(",");
		for(var i=0; i<initMethodsArray.length; i++){
			eval(initMethodsArray[i]);
		}
	}
	
	$("button[name='goToFirst']").button({text:false,icons:{primary:'ui-icon-seek-first'}});
	$("button[name='goToLast']").button({text:false,icons:{primary:'ui-icon-seek-end'}});
	$("button[name='back']").button({text:false,icons:{primary:'ui-icon-seek-prev'}});
	$("button[name='next']").button({text:false,icons:{primary:'ui-icon-seek-next'}});
	$("button[name='go']").button();
	$(':submit').button();
	$(':reset').button();
	
	//控制按钮显示
	var currentPageIndex = $("#currentPageIndex").val();
	var lastPageIndex = $("#lastPageIndex").val();
	//页面初始化时禁用所有按钮
	if(currentPageIndex == 0){
		$("button[name='goToFirst']").button('disable');
		$("button[name='goToLast']").button('disable');
		$("button[name='back']").button('disable');
		$("button[name='next']").button('disable');
		$("button[name='go']").button('disable');
		$("input[name='pageIndex']").attr("disabled",true);
	}
	//在首页时
	else if(currentPageIndex == 1){
		$("button[name='goToFirst']").button('disable');
		$("button[name='goToLast']").button('enable');
		$("button[name='back']").button('disable');
		$("button[name='next']").button('enable');
		$("input[name='pageIndex']").attr("disabled",false);
	}
	//在尾页时
	else if(currentPageIndex == lastPageIndex){
		$("button[name='goToFirst']").button('enable');
		$("button[name='goToLast']").button('disable');
		$("button[name='back']").button('enable');
		$("button[name='next']").button('disable');
		$("input[name='pageIndex']").attr("disabled",false);
	}
	else{
		$("button[name='goToFirst']").button('enable');
		$("button[name='goToLast']").button('enable');
		$("button[name='back']").button('enable');
		$("button[name='next']").button('enable');
		$("input[name='pageIndex']").attr("disabled",false);
	}
	$("table").resizableColumns({store:store});
	
	$("button[name='insert']").button();
	$("button[name='update']").button();
	$("button[name='delete']").button();
})

function alertMsg(message,modal) {
	if(modal==null){
		modal = true;
	}
	parent.$("<div>" + message + "</div>").dialog({
		position : "center",
		modal : modal,
		resize : false,
		width : "auto",
		height : "auto",
		buttons : {
			Ok : function() {
				parent.$(this).dialog("close");
			}
		}
	});
}

function confirmMsg(message,callback,modal) {
	if(modal==null){
		modal = true;
	}
	parent.$("<div>" + message + "</div>").dialog({
		position : "center",
		modal : modal,
		resize : false,
		width : "auto",
		height : "auto",
		buttons : {
			确定 : function() {
				callback.call();
				parent.$(this).dialog("close");
			},
			取消 : function() {
				parent.$(this).dialog("close");
			}
		}
	});
}

function newPage(pageURL,id,modal,width,height) {
	if(modal==null){
		modal = true;
	}
	if(width==null){
		width = 1000;
	}
	if(height==null){
		height = 800;
	}
	parent.$("<div id='"+id+"' style='border-style:none'><iframe src='"+pageURL+"' frameborder='0' scrolling='no' width='"+width+"' height='"+height+"'/></div>").dialog({
		position : "center",
		modal : modal,
		resize : false,
		width : "auto",
		height : "auto"
	});
}

function closePage(id){
	parent.$("#"+id).dialog("destroy");
}