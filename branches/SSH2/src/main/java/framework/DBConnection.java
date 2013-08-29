package framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import framework.FWConstants.DataBaseType;

public class DBConnection
{
	private static String driver = "org.hsqldb.jdbcDriver";
	private static String url = "jdbc:hsqldb:hsql://localhost/lifeRudder2;ifexists=true";
	private static String user = "sa";
	private static String password = "";
	
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
		else if(driver.contains("hsqldb")){
			dbType = DataBaseType.HSQLDB;
		}
		return dbType;
	}
	
}
