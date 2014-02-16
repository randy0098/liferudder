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