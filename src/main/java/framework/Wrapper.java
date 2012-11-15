/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package framework;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Wrapper<T> {
	T wrapRecord(ResultSet rs) throws SQLException;
}
