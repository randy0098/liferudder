/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of Hewlett-Packard Co.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013 All rights reserved. =============================
 */

package exception;

public class MyException extends Exception
{

	/**
	 * serialVersionUID
	 * long
	 */
	private static final long serialVersionUID = -6672702507525718955L;

	public MyException(){
		
	}
	
	public MyException(String msg){
		super(msg);
	}

}
