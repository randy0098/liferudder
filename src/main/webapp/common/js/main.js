//删除时进行确认
function deleteCheck() {
	return confirm("确定删除此记录？");
}

// 分页跳转
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
		url = url + "back&currentPageIndex=" + $
		{
			page != null ? page.currentPageIndex : 0
		}
		;
	}
	// 下一页
	else if (action == "next") {
		url = url + "next&currentPageIndex=" + $
		{
			page != null ? page.currentPageIndex : 0
		}
		;
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

function goBack() {
	history.go(-1);
}