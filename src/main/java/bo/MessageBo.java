/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package bo;

import vo.MessageVO;
import dao.impl.MessageDAOImpl;

public class MessageBo {
	public MessageDAOImpl messageDAO;
	
	public MessageDAOImpl getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAOImpl messageDAO) {
		this.messageDAO = messageDAO;
	}

	
	public void insertMessage(MessageVO message){
		messageDAO.insertMessage(message);
	}
	
	public MessageVO getMessageInfo(int id){
		return messageDAO.getMessageInfo(id);
	}
	
	public void updateMessage(MessageVO message){
		messageDAO.updateMessage(message);
	}
	
	public void deleteMessage(int id){
		messageDAO.getMessageInfo(id);
	}
}
