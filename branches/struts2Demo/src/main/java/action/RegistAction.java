/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of Hewlett-Packard Co.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013 All rights reserved. =============================
 */

package action;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport
{
    Logger logger = LoggerFactory.getLogger(RegistAction.class);
	
	private String name;

	private String pass;

	private String age;

	private Date birth;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public Date getBirth()
	{
		return birth;
	}

	public void setBirth(Date birth)
	{
		this.birth = birth;
	}
	
	public String regist()
	{
		logger.info("-------regist start-------");
		return SUCCESS;
	}

	/*public void validate()
	{
		logger.info("-------validate start-------");
		
		if (!name.contains("xx"))
		{
			addFieldError("user", "您的用户名必须包含xx！");
		}
	}

	public void validateRegist()
	{
		logger.info("-------validateRegist start-------");
		
		if (!name.contains(".123"))
		{
			addFieldError("user", "您的用户名必须包含.123！");
		}
	}*/
	
}
