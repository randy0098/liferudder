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
	private ArrayList cells = new ArrayList();
	private ArrayList buttons = new ArrayList();
	
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

	public ArrayList getCells() {
		return cells;
	}

	public void setCells(ArrayList cells) {
		this.cells = cells;
	}

	public ArrayList getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList buttons) {
		this.buttons = buttons;
	}

/*
		<table id="result_table" class="result_table">
			<button type="button" name="delete" onclick="deleteCheck()" class="page_function_button">删除</button>
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
		</table>
*/
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null); 
		JspWriter writer = getJspContext().getOut();
		writer.println("<table id='result_table' class='result_table'" + this.createDynamicAttributes() +">");
		//生成按钮
		writer.println(createButtons());
		writer.println("<caption class='ui-widget-header'>短信记录列表</caption>");
		//生成表头
		writer.println(createTH());
		//生成表格内容
		try {
			writer.println(createCell());
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//生成翻页底部
		writer.println(createPager());
		writer.println("</table>");
	}
	
	//生成按钮
	public String createButtons(){
		String result="";
		for(int i=0; i<buttons.size(); i++){
			Button button = (Button)buttons.get(i);
			result = result + "<button type='button' name='"+button.getName()+"' onclick="+button.getOnclick()+" class='page_function_button' "+button.createDynamicAttributes()+">"+button.getCaption()+"</button>";
		}
		return result;
	}
	
	//生成表头
	public String createTH(){
		String result="<tr><th data-resizable-column-id='checkbox'></th>";
		for(int i=0; i<cells.size(); i++){
			Cell cell = (Cell) cells.get(i);
			result = result + "<th data-resizable-column-id='" + cell.getCaption() + "' " + cell.createDynamicAttributes()+">" + cell.getCaption() + "</th>";
		}
		result = result+"</tr>";
		return result;
	}
	
	//生成表格内容
	public String createCell() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		String result="";
		HibernatePage page = (HibernatePage) getJspContext().findAttribute(property);
		ArrayList records = page.getRecords();
		for(int i=0; i<records.size(); i++){
			result = result + "<tr>";
			String propertyValue = "";
			//取id值生成checkbox
			Field idField = records.get(i).getClass().getDeclaredField(keys);
			idField.setAccessible(true);
			String idValue = String.valueOf(idField.get(records.get(i)));
			result = result + "<td><input type='checkbox' name='checkbox' value='"+idValue+"'></td>";
			for(int j=0; j<cells.size(); j++){
				//生成cell域
				Cell cell = (Cell)cells.get(j);
				String property = cell.getProperty();
				Field cellField = records.get(i).getClass().getDeclaredField(property);
				cellField.setAccessible(true);
				propertyValue = String.valueOf(cellField.get(records.get(i)));
				result = result + "<td>"+propertyValue+"</td>";
			}
			result = result+"</tr>";
		}
		return result;
	}
	
	//生成翻页底部
	public String createPager(){
		HibernatePage page = (HibernatePage) getJspContext().findAttribute("page");
		String result = "<tr class='pager'>";
		int colspan = cells.size()+1;
		result = result + "<td colspan='"+colspan+"'>";
		result = result + "<div class='pager_navigator'>";
		result = result + "<button type='button' name='goToFirst' onclick=\"paging(this,'goToFirst')\" style='width:25px;height:25px'>首页</button>";
		result = result + "<button type='button' name='back' onclick=\"paging(this,'back',"+page.getCurrentPageIndex()+")\" style='width:25px;height:25px' >上一页</button>";
		result = result + "<button type='button' name='next' onclick=\"paging(this,'next',"+page.getCurrentPageIndex()+")\" style='width:25px;height:25px' >下一页</button>";
		result = result + "<button type='button' name='goToLast' onclick=\"paging(this,'goToLast')\" style='width:25px;height:25px' >尾页</button>";
		result = result + "转到第<input type='text' name='pageIndex' size='1' maxlength='3'/>页<button type='button' name='go' onclick=\"paging(this,'go')\" style='height:30px;width:40px'>go</button>";
		result = result + "</div>";
		result = result + "<div class='pager_display'>每页显示"+page.getPageRecordNum()+"条&nbsp第"+page.getCurrentPageIndex()+"/"+page.getTotalPage()+"页</div>";
		result = result + "<input type='hidden' id='currentPageIndex' value="+page.getCurrentPageIndex()+">";
		result = result + "<input type='hidden' id='lastPageIndex' value="+page.getTotalPage()+">";
		result = result + "</td>";
		result = result + "</tr>";
		return result;
	}
	
	
}
