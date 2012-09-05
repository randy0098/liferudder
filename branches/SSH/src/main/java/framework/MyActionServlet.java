/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionServlet;

public class MyActionServlet extends ActionServlet {
	protected void process(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException,
		javax.servlet.ServletException {
		//fix Chinese messy code issue
		request.setCharacterEncoding("UTF-8");
		super.process(request, response);
	}
}
