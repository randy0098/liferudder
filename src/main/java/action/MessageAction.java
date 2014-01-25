package action;

import vo.MessageVO;
import bo.MessageBO;

import com.opensymphony.xwork2.ModelDriven;

import framework.BaseAction;
import framework.HibernatePage;

public class MessageAction extends BaseAction implements ModelDriven{
	/**
	 * serialVersionUID
	 * long
	 */
	private static final long serialVersionUID = 1L;
	private String mintime;
	private String maxtime;
	private String action;
	private String currentPageIndex;
	private HibernatePage page;
	private MessageBO messageBO;
	private MessageVO messageVO = new MessageVO();

	@Override
	public MessageVO getModel() {
		return messageVO;
	}
	
	public MessageVO getMessageVO() {
		return messageVO;
	}

	public void setMessageVO(MessageVO messageVO) {
		this.messageVO = messageVO;
	}

	public HibernatePage getPage() {
		return page;
	}

	public void setPage(HibernatePage page) {
		this.page = page;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCurrentPageIndex() {
		return currentPageIndex;
	}

	public void setCurrentPageIndex(String currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	public MessageBO getMessageBO() {
		return messageBO;
	}

	public void setMessageBO(MessageBO messageBO) {
		this.messageBO = messageBO;
	}

	public String getMintime() {
		return mintime;
	}

	public void setMintime(String mintime) {
		this.mintime = mintime;
	}

	public String getMaxtime() {
		return maxtime;
	}

	public void setMaxtime(String maxtime) {
		this.maxtime = maxtime;
	}

	/**
	 * 
	 * 短信记录查询
	 * 
	 */
	public String message_query(){
		String sender = messageVO.getSender();
		String receiver = messageVO.getReceiver();
		String sql = " FROM MessageVO WHERE 1=1 ";
		if (sender != null && sender.equalsIgnoreCase("") == false) {
			sql = sql + " AND sender = '" + sender + "' ";
		}
		if (receiver != null && receiver.equalsIgnoreCase("") == false) {
			sql = sql + " AND receiver LIKE '%" + receiver + "%' ";
		}
		if (mintime != null && mintime.equalsIgnoreCase("") == false) {
			sql = sql + " AND msg_time >= '" + mintime + "' ";
		}
		if (maxtime != null && maxtime.equalsIgnoreCase("") == false) {
			sql = sql + " AND msg_time <= '" + maxtime + "' ";
		}
		page.setQuerySql(sql);
		page.setCountSql("SELECT COUNT(ID) " + sql);
		page.setPageRecordNum(2);
		page.paging(action, currentPageIndex);	
		return "query_success";
	}
	
	/**
	 * 
	 * 短信记录新增
	 * 
	 */
	public String message_insert(){
		messageVO.setMsg_time("20111226");
		messageBO.insertMessage(messageVO);
		return "insert_success";
	}

	/**
	 * 
	 * 查询单条短信记录信息
	 * 
	 */
	public String message_selectOne(){
		messageVO = messageBO.getMessageInfo(messageVO.getId());
		return "selectOne_success";
	}

	/**
	 * 
	 * 保存单条短信记录信息
	 * 
	 */
	public String message_update(){
		messageVO.setMsg_time("20111227");
		messageBO.updateMessage(messageVO);
		return "update_success";
	}

	/**
	 * 
	 * 删除单条短信记录信息
	 * 
	 */
	public String message_delete(){
		messageBO.deleteMessage(messageVO.getId());
		return "delete_success";
	}

}
