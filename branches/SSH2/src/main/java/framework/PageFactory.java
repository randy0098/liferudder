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
