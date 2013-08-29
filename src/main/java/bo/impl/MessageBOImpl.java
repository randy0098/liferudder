package bo.impl;

import vo.MessageVO;
import bo.MessageBO;
import dao.impl.MessageDAOImpl;
import framework.BaseBOImpl;

public class MessageBOImpl extends BaseBOImpl implements MessageBO{
	public MessageDAOImpl messageDAO;

	public MessageDAOImpl getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAOImpl messageDAO) {
		this.messageDAO = messageDAO;
	}

	public void insertMessage(MessageVO message) {
		messageDAO.save(message);
	}

	public MessageVO getMessageInfo(int id) {
		return messageDAO.get(id);
	}

	public void updateMessage(MessageVO message) {
		messageDAO.update(message);
	}

	public void deleteMessage(int id) {
		messageDAO.delete(id);
	}
}
