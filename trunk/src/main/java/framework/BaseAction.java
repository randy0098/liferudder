/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import org.springframework.web.struts.DispatchActionSupport;

public class BaseAction extends DispatchActionSupport {
	/**
	 * get Spring bean instance with beanName
	 * 
	 * @param beanName beanName in Spring container
	 * @return return bean instance in Spring container
	 */
	public Object getBean(String beanName) {
		return getWebApplicationContext().getBean(beanName);
	}
}
