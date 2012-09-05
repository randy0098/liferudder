/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseVO implements Serializable,Cloneable
{
	/**
	 * serialVersionUID
	 * long
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * clone方法
	 *
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	/**
	 * 
	 * 用于将数据库记录封装成TO对象
	 *
	 * @param rs
	 * @throws SQLException 
	 */
	
	public abstract BaseVO buildTO(ResultSet rs) throws SQLException;
	
	//for Hibernate's PO
//	public abstract String toString();
//	public abstract boolean equals(Object o);
//	public abstract int hashCode();
}
