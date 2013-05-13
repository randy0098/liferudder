/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package vo;

import framework.BaseVO;


public class MessageVO extends BaseVO
{
	/**
	 * serialVersionUID
	 * long
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String sender;
	private String receiver;
	private String content;
	private String msg_time;
	
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
