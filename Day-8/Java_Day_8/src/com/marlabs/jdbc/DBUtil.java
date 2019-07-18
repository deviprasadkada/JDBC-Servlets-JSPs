package com.marlabs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBUtil {
	private DBUtil() {

	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "System", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// LOG.fatal("message");
		} catch (SQLException e) {
			e.printStackTrace();
			// LOG.fatal("message");
		}
		return connection;
	}
}
