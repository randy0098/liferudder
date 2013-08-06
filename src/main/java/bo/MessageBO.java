package bo;

import vo.MessageVO;
import dao.impl.MessageDAOImpl;

public interface MessageBO {

	public MessageDAOImpl getMessageDAO();

	public void setMessageDAO(MessageDAOImpl messageDAO);

	public void insertMessage(MessageVO message);

	public MessageVO getMessageInfo(int id);

	public void updateMessage(MessageVO message);

	public void deleteMessage(int id);
}
