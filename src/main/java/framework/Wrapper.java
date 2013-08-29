package framework;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Wrapper<T> {
	T wrapRecord(ResultSet rs) throws SQLException;
}
