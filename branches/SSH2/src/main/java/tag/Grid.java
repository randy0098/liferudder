package tag;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import framework.HibernatePage;

public class Grid extends BaseTag {
	private String property;
	private String keys;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	private ArrayList children = new ArrayList();
	
	public ArrayList getChildren() {
		return children;
	}

	public void setChildren(ArrayList children) {
		this.children = children;
	}

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
	
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null); 
		JspWriter writer = getJspContext().getOut();
		writer.println("<table id='result_table' class='result_table'>");
		writer.println("<caption class='ui-widget-header'>短信记录列表</caption>");
		//生成表头
		writer.println(createTH());
		//生成表格内容
		writer.println(createCell());
		//生成翻页底部
		writer.println(createPager());
		writer.println("</table>");
	}
	
	//生成表头
	public String createTH(){
		String result="<tr>";
		for(int i=0; i<children.size(); i++){
			Cell child = (Cell) children.get(i);
			result = result + "<th data-resizable-column-id='" + child.getCaption() + "'>" + child.getCaption() + "</th>";
		}
		result = result+"<th>操作</th></tr>";
		return result;
	}
	
	//生成表格内容
	public String createCell(){
		String result="";
		HibernatePage page = (HibernatePage) getJspContext().findAttribute(property);
		ArrayList records = page.getRecords();
		for(int i=0; i<records.size(); i++){
			result = result + "<tr>";
			String propertyValue = "";
			String id="";
			for(int j=0; j<children.size(); j++){
				Cell cell = (Cell)children.get(j);
				String property = cell.getProperty();
				Field field1;
				try {
					field1 = records.get(i).getClass().getDeclaredField(property);
					field1.setAccessible(true);
					propertyValue = String.valueOf(field1.get(records.get(i)));
				} catch (NoSuchFieldException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				result = result + "<td>"+propertyValue+"</td>";
				if(property.equalsIgnoreCase(keys)){
					id = propertyValue;
				}
			}
			result = result + "<td>";
			result = result + "<a href='message_selectOne?id="+id+"'/>修改</a>";
			result = result + "<a href='message_delete?id="+id+"' onclick=\"return confirm('确定删除此记录？')\">删除</a>";
			result = result + "</td>";
			result = result+"</tr>";
		}
		return result;
	}
	
	//生成翻页底部
	public String createPager(){
		HibernatePage page = (HibernatePage) getJspContext().findAttribute("page");
		String result = "<tr class='pager'>";
		result = result + "<td colspan='"+children.size()+1+"'>";
		result = result + "<div class='pager_navigator'>";
		result = result + "<button type='button' name='goToFirst' onclick=\"paging('goToFirst')\">首页</button>";
		result = result + "<button type='button' name='back' onclick=\"paging('back')\">上一页</button>";
		result = result + "<button type='button' name='next' onclick=\"paging('next')\">下一页</button>";
		result = result + "<button type='button' name='goToLast' onclick=\"paging('goToLast')\">尾页</button>";
		result = result + "转到第<input type='text' name='pageIndex' size='1' maxlength='3'/>页<button type='button' name='go' onclick=\"paging('go')\" style='height:28px;width:46px'>go</button>";
		result = result + "</div>";
		result = result + "<div class='pager_display'>每页显示"+page.getPageRecordNum()+"条&nbsp第"+page.getCurrentPageIndex()+"/"+page.getTotalPage()+"页</div>";
		result = result + "</td>";
		result = result + "</tr>";
		return result;
	}
}
