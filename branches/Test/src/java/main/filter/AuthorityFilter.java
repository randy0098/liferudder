/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of Hewlett-Packard Co.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013 All rights reserved. =============================
 */

package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter
{

	private FilterConfig config;

	public void init(FilterConfig config)
		throws ServletException
	{
		this.config = config;
	}

	public void destroy()
	{
		this.config = null;

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException
	{
		String encoding = config.getInitParameter("encoding");
		String loginPage = config.getInitParameter("loginPage");

		request.setCharacterEncoding(encoding);
		HttpServletRequest requ = (HttpServletRequest)request;
		HttpSession session = requ.getSession(true);
		String requestPath = requ.getServletPath();
		if(session.getAttribute("user")==null && !requestPath.endsWith(loginPage)){
			//forward到登录页面
			request.setAttribute("tip", "您还没有登录");
			request.getRequestDispatcher(loginPage).forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
		  
	}

}
