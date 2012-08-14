/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package bo;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import menus.MenuReader;
import menus.Module;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import framework.BaseAction;

public class LoginAction extends BaseAction
{
	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	        HttpServletResponse httpservletresponse)
	    throws Exception
	{
		String name = request.getParameter("name");
		System.out.println("name:"+name);
		String password = request.getParameter("password");
		ActionForward actionForward = null;
		if((name!=null&&name.equalsIgnoreCase("1")==true)&&(password!=null&&password.equalsIgnoreCase("1")==true)){
			actionForward = mapping.findForward("success");
		}else{
			actionForward = mapping.findForward("fail");
		}
		
		List<Module> modules = MenuReader.read();
		request.setAttribute("modules", modules);
		
		//设置用户session
		System.out.println("login session start:"+new Date());
		HttpSession session = request.getSession();
		session.setAttribute("username", name);
		session.setMaxInactiveInterval(120);
		System.out.println("login session end"+new Date());
		return actionForward;
	}
}
