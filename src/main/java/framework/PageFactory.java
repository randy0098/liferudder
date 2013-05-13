/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import framework.FWConstants.DataBaseType;


public class PageFactory {
	
	public static Page getPage(){
		Page page = null;
		DataBaseType dbType = DBConnection.getConnectionDBType();
		if(dbType == DataBaseType.ORACLE){
			page = new OraclePage();
		}
		else if(dbType == DataBaseType.MYSQL){
			page = new MySQLPage();
		}
		else if(dbType == DataBaseType.HSQLDB){
			page = new HSQLDBPage();
		}
		return page;
	}
}
