/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of Hewlett-Packard Co.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013 All rights reserved. =============================
 */

package action.ajax;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.Action;

/**
 * 使用stream类型的Result实现Ajax Description goes here.
 * 
 * @since
 */
public class LoginAction implements Action
{

	private String user;

	private String pass;

	private InputStream inputStream;

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public InputStream getInputStream()
	{
		return inputStream;
	}

	public void setInputStream(InputStream inputStream)
	{
		this.inputStream = inputStream;
	}

	@Override
	public String execute()
		throws Exception
	{
		inputStream = user.equals("www") && pass.equals("wwww")
		    ? new ByteArrayInputStream("恭喜你, 登录成功!".getBytes("UTF-8"))
		    : new ByteArrayInputStream("对不起用户名密码不对!".getBytes("UTF-8"));
		return SUCCESS;
	}

}
