package action;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ModelDriven;

import vo.MessageVO;
import bo.MessageBO;
import framework.BaseAction;
import framework.Page;
import framework.PageFactory;
import framework.Wrapper;

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
	private Page page;
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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
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
	 * @param mapping
	 * @param form
	 * @param request
	 * @param httpservletresponse
	 * @return
	 * @throws Exception 
	 */
	public String message_query() throws Exception{
		page = PageFactory.getPage();
		setQuerySql(page);
		page.setWrapper(new Wrapper<MessageVO>() {
			@Override
			public MessageVO wrapRecord(ResultSet rs) throws SQLException {
				MessageVO messageVO = new MessageVO();
				messageVO.setId(rs.getInt("ID"));
				messageVO.setSender(rs.getString("SENDER"));
				messageVO.setReceiver(rs.getString("RECEIVER"));
				messageVO.setContent(rs.getString("CONTENT"));
				messageVO.setMsg_time(rs.getString("MSG_TIME"));
				return messageVO;
			}
		});
		page.setPageRecordNum(1);
		page.pagingDefault(action, currentPageIndex);
		return "query_success";
	}

	/**
	 * 
	 * 短信记录新增
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param httpservletresponse
	 * @return
	 * @throws Exception
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
	 * @param mapping
	 * @param form
	 * @param request
	 * @param httpservletresponse
	 * @return
	 * @throws Exception
	 */
	public String message_selectOne(){
		messageVO = messageBO.getMessageInfo(messageVO.getId());
		return "selectOne_success";
	}

	/**
	 * 
	 * 保存单条短信记录信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param httpservletresponse
	 * @return
	 * @throws Exception
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
	 * @param mapping
	 * @param form
	 * @param request
	 * @param httpservletresponse
	 * @return
	 * @throws Exception
	 */
	public String message_delete(){
		messageBO.deleteMessage(messageVO.getId());
		return "delete_success";
	}

	/**
	 * 
	 * 具体查询逻辑
	 * 
	 * @param request
	 * @param page
	 */
	public void setQuerySql(Page page) {
		String sender = messageVO.getSender();
		String receiver = messageVO.getReceiver();
		
		String sqlPrefix = " SELECT * ";
		String sql = " FROM liferudder2_message WHERE 1=1 ";
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
		page.setQuerySql(sqlPrefix + sql);
		page.setCountSql("SELECT COUNT(ID) " + sql);
	}

}
