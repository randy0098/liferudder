/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO {
	public List getObjects(Class clazz);
	public Object getObject(Class clazz , Serializable id);
	public void saveObject(Object obj);
	public void removeObject(Class clazz , Serializable id);
}
