/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package action;

import bo.MessageBO;
import framework.BaseAction;

public class MessageAction extends BaseAction {
	public MessageBO messageBO;

	public MessageBO getMessageBo() {
		return messageBO;
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
//	public ActionForward message_query(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//		HttpServletResponse httpservletresponse) throws Exception {
//		Page page = PageFactory.getPage();
//		setQuerySql(request, page);
//		page.setWrapper(new Wrapper<MessageVO>() {
//			@Override
//			public MessageVO wrapRecord(ResultSet rs) throws SQLException {
//				MessageVO messageVO = new MessageVO();
//				messageVO.setId(rs.getInt("ID"));
//				messageVO.setSender(rs.getString("SENDER"));
//				messageVO.setReceiver(rs.getString("RECEIVER"));
//				messageVO.setContent(rs.getString("CONTENT"));
//				messageVO.setMsg_time(rs.getString("MSG_TIME"));
//				return messageVO;
//			}
//		});
//		page.setPageRecordNum(1);
//		page.paging(request);
//		request.setAttribute("page", page);
//		ActionForward forward = mapping.findForward("query_success");
//		return forward;
//	}

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

//	public ActionForward message_insert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//		HttpServletResponse httpservletresponse) throws Exception {
//		MessageVO message = new MessageVO();
//		DynaActionForm messageForm = (DynaActionForm)form;
//		BeanUtils.copyProperties(message, messageForm);
//		message.setMsg_time("20111226");
//		getMessageBo().insertMessage(message);
//		ActionForward forward = mapping.findForward("insert_success");
//		return forward;
//	}

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

//	public ActionForward message_selectOne(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//		HttpServletResponse httpservletresponse) throws Exception {
//		HttpSession session = request.getSession(false);
//		System.out.println("username:" + session.getAttribute("username"));
//		MessageVO messageVO = getMessageBo().getMessageInfo(Integer.parseInt(request.getParameter("id")));
//		request.setAttribute("messageVO", messageVO);
//		ActionForward forward = mapping.findForward("selectOne_success");
//		return forward;
//	}

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

//	public ActionForward message_update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//		HttpServletResponse httpservletresponse) throws Exception {
//		MessageVO message = new MessageVO();
//		DynaActionForm messageForm = (DynaActionForm)form;
//		BeanUtils.copyProperties(message, messageForm);
//		message.setMsg_time("20111227");
//		getMessageBo().updateMessage(message);
//		ActionForward forward = mapping.findForward("update_success");
//		return forward;
//	}

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

//	public ActionForward message_delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//		HttpServletResponse httpservletresponse) throws Exception {
//		getMessageBo().deleteMessage(Integer.parseInt(request.getParameter("id")));
//		ActionForward forward = mapping.findForward("delete_success");
//		return forward;
//	}

	/**
	 * 
	 * 具体查询逻辑
	 * 
	 * @param request
	 * @param page
	 */
//	public void setQuerySql(HttpServletRequest request, Page page) {
//		String sender = request.getParameter("sender");
//		String receiver = request.getParameter("receiver");
//		String mintime = request.getParameter("mintime");
//		String maxtime = request.getParameter("maxtime");
//		String sqlPrefix = " SELECT * ";
//		String sql = " FROM devfw_message WHERE 1=1 ";
//		if (sender != null && sender.equalsIgnoreCase("") == false) {
//			sql = sql + " AND sender = '" + sender + "' ";
//		}
//		if (receiver != null && receiver.equalsIgnoreCase("") == false) {
//			sql = sql + " AND receiver LIKE '%" + receiver + "%' ";
//		}
//		if (mintime != null && mintime.equalsIgnoreCase("") == false) {
//			sql = sql + " AND msg_time >= '" + mintime + "' ";
//		}
//		if (maxtime != null && maxtime.equalsIgnoreCase("") == false) {
//			sql = sql + " AND msg_time <= '" + maxtime + "' ";
//		}
//		page.setQuerySql(sqlPrefix + sql);
//		page.setCountSql("SELECT COUNT(ID) " + sql);
//	}
}
