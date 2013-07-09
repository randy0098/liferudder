/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of Hewlett-Packard Co.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013 All rights reserved. =============================
 */

package action.ognlConvert;

import com.opensymphony.xwork2.Action;

import domain.User;



public class LoginAction implements Action
{

	private User user;
	private String tip;
	
	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getTip()
	{
		return tip;
	}

	public void setTip(String tip)
	{
		this.tip = tip;
	}

	public String execute(){
		if(user.getName().equalsIgnoreCase("ecs")&&
			 user.getPass().equalsIgnoreCase("vpc")){
			setTip("转换成功");
			return SUCCESS;
		}
		else{
			setTip("转换失败");
			return ERROR;
		}
		
	}
	
}
