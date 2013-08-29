/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;


public class MySQLPage extends Page
{
	
	/**
	 * 
	 * 创建查询语句
	 *
	 */
	public void createSelectSql(){
		String resultSql = this.querySql + " LIMIT " + --this.startRecordIndex + "," + this.pageRecordNum;
		System.out.println("createdQuerySql:" + resultSql);
		this.createdQuerySql = resultSql;
	}


	public static void main(String[] args) throws SQLException, CloneNotSupportedException, IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException
	{
		// TODO Auto-generated method stub
		MySQLPage page = new MySQLPage();
		page.setQuerySql("SELECT * FROM devfw_message WHERE 1=1 AND id = 8");
		page.setCountSql("SELECT COUNT(ID) AS n FROM devfw_message");
		page.setPageRecordNum(1);
		page.setCurrentPageIndex(1);
//		page.setTOClassName("vo.MessageVO");
		page.createPage();
		System.out.println(page.getRecords().size());
		System.out.println(page.getRecordNum());
	}
	
	
}
