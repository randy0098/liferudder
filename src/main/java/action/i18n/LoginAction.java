/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of Hewlett-Packard Co.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013 All rights reserved. =============================
 */

package action.i18n;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
	/**
	 * serialVersionUID
	 * long
	 */
	private static final long serialVersionUID = 5356713006661367525L;

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

	public String execute()
	{
		ActionContext ctx = ActionContext.getContext();
		if(getUsername().equals("test")
			&&getPassword().equals("test"))
		{
			ctx.getSession().put("user", getUsername());
			ctx.put("tip", getText("succTip", new String[]{getUsername()}));
			return SUCCESS;
		}
		else
		{
			ctx.put("tip", getText("failTip", new String[]{getUsername()}));
			return ERROR;
		}

	}
}
