package tag;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import framework.HibernatePage;

public class MyGridTag extends SimpleTagSupport {
	private ArrayList children = new ArrayList();
	
	public ArrayList getChildren() {
		return children;
	}

	public void setChildren(ArrayList children) {
		this.children = children;
	}

	public void doTag() throws JspException, IOException {
		System.out.println("MyGridTag:start");
		getJspBody().invoke(null); 
		System.out.println("size:" + children.size());
		System.out.println("MyGridTag:end");
		JspWriter writer = getJspContext().getOut();
		/*
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
		*/
		writer.println("<table id='result_table' class='result_table'>");
		writer.println("<caption class='ui-widget-header'>短信记录列表</caption>");
		writer.println(createTH());
//		writer.println("<c:forEach var='message' items='${page.records}'>");
//		writer.println("<tr>");
//		writer.println("<td>${message.id}</td>");
//		writer.println("<td>${message.sender}</td>");
//		writer.println("<td>");
//		writer.println("<a href='message_selectOne?id=${message.id}'/>修改</a>");
//		writer.println("<a href='message_delete?id=${message.id}' onclick='return confirm('确定删除此记录？')'>删除</a>");
//		writer.println("</td>");
//		writer.println("</c:forEach>");
		try {
			writer.println(createCell());
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		writer.println("<tr class='pager'>");
//		writer.println("<td colspan='6'>");
//		writer.println("<div class='pager_navigator'>");
//		writer.println("<button type='button' id='goToFirst' onclick='paging('goToFirst')'>首页</button>");
//		writer.println("<button type='button' id='back' onclick='paging('back')'>上一页</button>");
//		writer.println("<button type='button' id='next' onclick='paging('next')'>下一页</button>");
//		writer.println("<button type='button' id='goToLast' onclick='paging('goToLast')'>尾页</button>");
//		writer.println("转到第<input type='text' id='pageIndex' size='1' maxlength='3'/>页<button type='button' id='go' onclick='paging('go')' style='height:28px;width:46px'>go</button>");
//		writer.println("</div>");
//		writer.println("<div class='pager_display'>每页显示${page.pageRecordNum}条&nbsp第${page.currentPageIndex}/${page.totalPage}页</div>");
//		writer.println("</td>");
//		writer.println("</tr>");
		writer.println(createPager());
		writer.println("</table>");
	}
	
	public String createTH(){
		String result="<tr>";
		for(int i=0; i<children.size(); i++){
			MyCellTag child = (MyCellTag) children.get(i);
			result = result + "<th data-resizable-column-id='" + child.getCaption() + "'>" + child.getCaption() + "</th>";
		}
		result = result+"<th>操作</th></tr>";
		return result;
	}
	
	public String createCell() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		String result="";
		HibernatePage page = (HibernatePage) getJspContext().findAttribute("page");
		ArrayList records = page.getRecords();
		for(int i=0; i<records.size(); i++){
			result = result + "<tr>";
			String propertyValue = "";
			String id="";
			for(int j=0; j<children.size(); j++){
				MyCellTag myCellTag = (MyCellTag)children.get(j);
				String property = myCellTag.getProperty();
				Field field1 = records.get(i).getClass().getDeclaredField(property);
				field1.setAccessible(true);
				propertyValue = String.valueOf(field1.get(records.get(i)));
				result = result + "<td>"+propertyValue+"</td>";
				if(property.equalsIgnoreCase("id")){
					id = propertyValue;
				}
			}
			result = result + "<td>";
			result = result + "<a href='message_selectOne?id="+id+"'/>修改</a>";
			result = result + "<a href='message_delete?id="+id+"' onclick=\"return confirm('确定删除此记录？')\">删除</a>";
			result = result + "</td>";
			result = result+"</tr>";
		}
		System.out.println("result:"+result);
		return result;
	}
	
	public String createPager(){
		HibernatePage page = (HibernatePage) getJspContext().findAttribute("page");
		String result = "<tr class='pager'>";
		result = result + "<td colspan='"+children.size()+1+"'>";
		result = result + "<div class='pager_navigator'>";
		result = result + "<button type='button' id='goToFirst' onclick=\"paging('goToFirst')\">首页</button>";
		result = result + "<button type='button' id='back' onclick=\"paging('back')\">上一页</button>";
		result = result + "<button type='button' id='next' onclick=\"paging('next')\">下一页</button>";
		result = result + "<button type='button' id='goToLast' onclick=\"paging('goToLast')\">尾页</button>";
		result = result + "转到第<input type='text' id='pageIndex' size='1' maxlength='3'/>页<button type='button' id='go' onclick=\"paging('go')\" style='height:28px;width:46px'>go</button>";
		result = result + "</div>";
		result = result + "<div class='pager_display'>每页显示"+page.getPageRecordNum()+"条&nbsp第"+page.getCurrentPageIndex()+"/"+page.getTotalPage()+"页</div>";
		result = result + "</td>";
		result = result + "</tr>";
		return result;
	}
}
