/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import org.apache.struts.actions.DispatchAction;

import util.MySQLPage;

public class BaseAction extends DispatchAction
{
	public Page page = new MySQLPage();
}
