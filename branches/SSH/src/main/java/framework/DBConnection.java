/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import framework.FWConstants.DataBaseType;

public class DBConnection
{
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/lifeRudder";
	private static String user = "root";
	private static String password = "root";
	
	/**
	 * 
	 * 获得数据库连接
	 * 
	 */
	public static Connection getConnection(){
		Connection conn = null;
        try
        {
	        Class.forName(driver);
	        conn = DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException e)
        {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
        catch (SQLException e)
        {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
		return conn;
	}
	
	public static DataBaseType getConnectionDBType(){
		DataBaseType dbType = DataBaseType.UNDEFINE;
		if(driver.contains("oracle")){
			dbType = DataBaseType.ORACLE;
		}
		else if(driver.contains("mysql")){
			dbType = DataBaseType.MYSQL;
		}
		return dbType;
	}
	
}
