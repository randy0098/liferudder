/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
		ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		System.out.println("-----------------------------------");
		StringBuffer URL = httpRequest.getRequestURL();
		System.out.println("URL:" + URL);
		String queryString = httpRequest.getQueryString();
		System.out.println("queryString:" + queryString);
		String Referer = httpRequest.getHeader("Referer");
		System.out.println("Referer:" + Referer);
		System.out.println("-----------------------------------");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
