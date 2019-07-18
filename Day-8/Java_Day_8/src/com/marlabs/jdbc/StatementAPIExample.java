package com.marlabs.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class StatementAPIExample {
	public void getEmployeeDetails(final int departmentNumber) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			final String SELECT_QUERY = "SELECT * FROM emp WHERE dno="
					+ departmentNumber;
			resultSet = statement.executeQuery(SELECT_QUERY);
			System.out.println("********************************************");
			System.out.print("ENO" + "\t");
			System.out.print("ENAME" + "\t");
			System.out.print("EJOB" + "\t");
			System.out.print("MGR" + "\t");
			System.out.print("DOJ" + "\t");
			System.out.print("Basic" + "\t");
			System.out.print("Comm" + "\t");
			System.out.print("DNO");
			System.out.println("********************************************");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + "\t");
				System.out.print(resultSet.getString(2) + "\t");
				System.out.print(resultSet.getString(3) + "\t");
				System.out.print(resultSet.getInt(4) + "\t");
				System.out.print(resultSet.getDate(5) + "\t");
				System.out.print(resultSet.getDouble(6) + "\t");
				System.out.print(resultSet.getDouble(7) + "\t");
				System.out.print(resultSet.getInt("DNO"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace(); // not good practice
				// throw new SQLException(e);
				// LOG.fatal(e.getMessage()); // Do Log The Message - Best
				// Practice To Follow
			}
		}
	}

	public void getEmployeeDetailsByRsmd(final int departmentNumber) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			final String SELECT_QUERY = "SELECT * FROM emp WHERE dno="
					+ departmentNumber;
			resultSet = statement.executeQuery(SELECT_QUERY);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			System.out.println("Number Of Columns:" + columnCount);
			System.out.println("********************************************");
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			System.out.println();
			System.out.println("********************************************");
			while (resultSet.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(resultSet.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace(); // not good practice
				// throw new SQLException(e);
				// LOG.fatal(e.getMessage()); // Do Log The Message - Best
				// Practice To Follow
			}
		}
	}

	public void dataBaseMetaDataInformation() {
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			DatabaseMetaData dbmd = connection.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverMinorVersion());
			System.out.println(dbmd.getDriverMajorVersion());
			System.out.println(dbmd.getSQLKeywords());
			System.out.println(dbmd.getStringFunctions());
			System.out.println(dbmd.getNumericFunctions());
			System.out.println(dbmd.getSystemFunctions());
			System.out.println(dbmd.supportsBatchUpdates());
			System.out.println(dbmd.supportsStoredProcedures());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace(); // not good practice
				// throw new SQLException(e);
				// LOG.fatal(e.getMessage()); // Do Log The Message - Best
				// Practice To Follow
			}
		}
	}

	public boolean registerEmployee(int empNumber, String empName,
			double empSal, int empDno) {
		boolean registrationFlag = false;
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DBUtil.getConnection(); // By Default JDBC Connection
													// In Auto Commit Nature
			statement = connection.createStatement();
			// insert into emp2 values(111,'aaa',9000,20);
			final String INSERT_QUERY = "INSERT INTO emp2 VALUES(" + empNumber
					+ ",'" + empName + "'," + empSal + "," + empDno + ")";
			int updateCount = statement.executeUpdate(INSERT_QUERY);
			if (updateCount > 0) {
				registrationFlag = true;
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			// JDBC 4.0 API Sub Classes For SQLException Introduced - JDK 1.6
			// VERSION
			// e.printStackTrace();
			System.err.println("Employee ID Already Existed");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return registrationFlag;
	}

	public void batchUpdatesExample() {
		System.out.println("From Batch Updates Example Method");
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			// By Default JDBC Connection is in Auto Commit Mode
			connection.setAutoCommit(false);
			String insertQuery = "INSERT INTO emp2 VALUES(119,'DFGH',7890.45,20)";
			String updateQuery = "UPDATE emp2 SET basic=basic+1000 WHERE dno=10";
			String deleteQuery = "DELETE FROM emp2 WHERE dno=30";
			statement.addBatch(updateQuery);
			statement.addBatch(insertQuery);
			statement.addBatch(deleteQuery);
			int updateCount[] = statement.executeBatch();
			for (int i = 0; i < updateCount.length; i++) {
				System.out.println("Records Updated Count :" + "Query Number:"
						+ i + ":" + updateCount[i]);
			}
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
