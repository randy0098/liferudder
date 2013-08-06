/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package dao;

import java.util.List;

import vo.MessageVO;
import framework.BaseDAO;

public interface MessageDAO extends BaseDAO{
	
//	public List<MessageVO> getMessageList();
//	
//	public void insertMessage(MessageVO message);
//	
//	public MessageVO getMessageInfo(int id);
//	
//	public void updateMessage(MessageVO message);
//	
//	public void deleteMessage(int id);
	
	public MessageVO get(Integer id);
	
	public Integer save(MessageVO message);
	
	public void update(MessageVO message);
	
	public void delete(MessageVO message);
	
	public void delete(Integer id);
	
	public List<MessageVO> findAll();
}
