package vo;

import framework.BaseVO;


public class MessageVO extends BaseVO
{
	private static final long serialVersionUID = 1L;
	//struts会自动进行String到int的类型转换
	private int id;
	private String ids;
	private String sender;
	private String receiver;
	private String content;
	private String msg_time;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSender()
    {
    	return sender;
    }
	public void setSender(String sender)
    {
    	this.sender = sender;
    }
	public String getReceiver()
    {
    	return receiver;
    }
	public void setReceiver(String receiver)
    {
    	this.receiver = receiver;
    }
	public String getContent()
    {
    	return content;
    }
	public void setContent(String content)
    {
    	this.content = content;
    }
	public String getMsg_time()
    {
    	return msg_time;
    }
	public void setMsg_time(String msg_time)
    {
    	this.msg_time = msg_time;
    }
	
}
