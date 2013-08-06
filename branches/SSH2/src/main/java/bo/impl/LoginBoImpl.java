/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package bo.impl;

public class LoginBoImpl {
	public boolean valid(String name, String password) {
		boolean result = false;
		if ((name != null && name.equalsIgnoreCase("1") == true)
			&& (password != null && password.equalsIgnoreCase("1") == true)) {
			result = true;
		}
		return result;
	}
}
