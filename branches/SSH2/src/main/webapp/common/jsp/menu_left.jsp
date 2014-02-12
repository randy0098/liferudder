<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
ul{

}

li{  
    list-style:none;      /*去掉li前的点*/  
    margin-left:20px;     /*调整距离*/  
    /*display:none;*/  
    margin:10px;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
/*		
		var as = $("ul>a");
		as.click(function(){
			//这里需要找到ul中的li，然后让li显示出来  
			var aNode = $(this);
			var lis = aNode.nextAll("li");
			//toggle()方法，改变显示状态  
			lis.toggle("slow");
		});
		
		$("li>a").click(function() {
			$("#content").load($(this).attr("id"));
		});
*/		
	});
	
</script>

<div >
	<ul>
		<a href="" onclick="return false">菜单1</a>
		<li><a href="#" id="JqueryWindow.html">子菜单1</a></li>
		<li>子菜单2</li>
	</ul>
	<ul>
		<a href="" onclick="return false">菜单2</a>
		<li>子菜单3</li>
		<li>子菜单4</li>
	</ul>
</div>
