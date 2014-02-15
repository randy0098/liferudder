function includeJS(src){
	document.write("<script type='text/javascript' src='"+src+"'></script>");
}

function includeCSS(src){
	document.write("<link rel='stylesheet' href='"+src+"'>");
}

//jquery
//includeJS("plugins/jquery-1.10.2/dev/jquery-1.10.2.js");
includeJS("plugins/jquery-ui-1.10.4/js/jquery-1.10.2.js");

//bootstrap
//includeJS("plugins/bootstrap-3.0.3/dev/bootstrap-3.0.3.js");
//includeCSS("plugins/bootstrap-3.0.3/dev/bootstrap-3.0.3.css");
//includeCSS("plugins/bootstrap-3.0.3/dev/bootstrap-theme-3.0.3.js");

//less
//includeJS("plugins/less-1.5.0/runtime/less-1.5.0.min.js");

//jquery ui
includeCSS("plugins/jquery-ui-1.10.4/css/redmond/jquery-ui-1.10.4.custom.css");
includeJS("plugins/jquery-ui-1.10.4/js/jquery-ui-1.10.4.custom.js");

//json2
//includeJS("plugins/json2.js");

/*
//jquery ui
includeJS("plugins/jquery-ui-1.8.22/dev/jquery-ui-1.8.22.custom.js");

//jquery ui:datepicker
includeJS("plugins/jquery-ui-1.8.22/dev/i18n/jquery.ui.datepicker-zh-CN.js");

//jquery ui theme: redmond
includeCSS("themes/dev/redmond/jquery-ui-1.8.22.custom.css");

//jquery.jqGrid
includeJS("plugins/jquery.jqGrid-4.4.0/i18n/grid.locale-cn.js");
includeJS("plugins/jquery.jqGrid-4.4.0/js/jquery.jqGrid.src.js");
includeJS("plugins/jquery.jqGrid-4.4.0/plugins/ui.multiselect.js");
includeJS("plugins/jquery.jqGrid-4.4.0/plugins/jquery.tablednd.js");
includeJS("plugins/jquery.jqGrid-4.4.0/plugins/jquery.contextmenu.js");
includeCSS("plugins/jquery.jqGrid-4.4.0/css/ui.jqgrid.css");

//jquery.layout
includeJS("plugins/jquery-layout-1.3.0-rc30.6/dev/jquery.layout-latest.js");
*/

//jquery.validation
includeJS("plugins/jquery-validation-1.10.0/dev/jquery.validate.js");

//页面全局样式
includeCSS("common/css/main.css");

//table列拖动
includeJS("plugins/resizableColumns/js/jquery.resizableColumns.js");
includeJS("plugins/resizableColumns/js/store.js");
includeCSS("plugins/resizableColumns/css/jquery.resizableColumns.css");

//全局js
includeJS("common/js/main.js");