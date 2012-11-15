/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import java.io.Serializable;

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
	
	//for Hibernate's PO
//	public abstract String toString();
//	public abstract boolean equals(Object o);
//	public abstract int hashCode();
}
