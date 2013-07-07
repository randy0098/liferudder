/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of Hewlett-Packard Co.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013 All rights reserved. =============================
 */

package action;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -8534550171421612227L;

	private Logger logger = LoggerFactory.getLogger(UserAction.class);

	private String username;

	private String password;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * 跳转到登录页面 Description goes here.
	 * 
	 * @return
	 * 
	 * @since
	 */
	public String login_input()
	{
		logger.info("------------");
		return SUCCESS;
	}

	public String login()
	{
		logger.info("-------login-----");
		if (getUsername().equalsIgnoreCase("Liu") && getPassword().equalsIgnoreCase("Lin"))
		{
			ActionContext.getContext().getSession().put("user", getUsername());
			return SUCCESS;
		}
		else
		{
			return INPUT;
		}

	}
	
	public String execute() throws Exception{
		return null;
		
	}
}
