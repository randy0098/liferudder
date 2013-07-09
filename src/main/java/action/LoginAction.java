/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of Hewlett-Packard Co.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013 All rights reserved. =============================
 */

package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import exception.MyException;



public class LoginAction implements Action
{
	private String username;

	private String password;
	
	private String tip;

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

	public String getTip()
	{
		return tip;
	}

	public void setTip(String tip)
	{
		this.tip = tip;
	}

	@Override
	public String execute()throws Exception
	{
		if(this.getUsername().equalsIgnoreCase("user")){
			throw new MyException("自定义异常");
		}
		if(getUsername().equalsIgnoreCase("sql")){
			throw new java.sql.SQLException("用户名不能为SQL");
		}
		if(getUsername().equalsIgnoreCase("ecs") && getPassword().equalsIgnoreCase("vpc")){
			ActionContext.getContext().getSession().put("user", getUsername());
			this.setTip("成功");
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}

}
