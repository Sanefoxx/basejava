package com.sanefox.webapp.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SqlTransaction<T> {
    T execute(Connection connection) throws SQLException;
}
