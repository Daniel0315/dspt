package com.neuedu.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetObject {
    Object getByResultSet(ResultSet resultSet) throws SQLException;
}
