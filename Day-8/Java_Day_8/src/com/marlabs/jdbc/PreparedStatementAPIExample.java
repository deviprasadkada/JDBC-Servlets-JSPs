package com.marlabs.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class PreparedStatementAPIExample {

	public boolean registerEmployee(int empNumber, String empName,
			double empSal, int empDno) {
		boolean registrationFlag = false;
		Connection connection = null;
		PreparedStatement pstStatement = null;
		try {
			connection = DBUtil.getConnection();
			// insert into emp2 values(111,'aaa',9000,20);
			final String INSERT_QUERY = "INSERT INTO emp2 VALUES(?,?,?,?)";
			pstStatement = connection.prepareStatement(INSERT_QUERY);
			pstStatement.setInt(1, empNumber);
			pstStatement.setString(2, empName);
			pstStatement.setDouble(3, empSal);
			pstStatement.setInt(4, empDno);

			int updateCount = pstStatement.executeUpdate();
			if (updateCount > 0) {
				registrationFlag = true;
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			// JDBC 4.0 Sub Classes For SQLException Introduced
			e.printStackTrace();
			System.out.println("Employee ID Already Existed");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstStatement != null) {
					pstStatement.close();
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

	public void displayEmployeesDetails(int dno) {
		Connection connection = null;
		PreparedStatement pstStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConnection();
			final String SELECT_QUERY = "SELECT * FROM emp2 WHERE dno=?";
			pstStatement = connection.prepareStatement(SELECT_QUERY);
			pstStatement.setInt(1, dno);
			resultSet = pstStatement.executeQuery();
			System.out.println("**********************************");
			System.out.print("ENO" + "\t");
			System.out.print("Name" + "\t");
			System.out.print("Salary" + "\t");
			System.out.print("DNO" + "\t");
			System.out.println();
			System.out.println("**********************************");
			while (resultSet.next()) { // boolean
				System.out.print(resultSet.getInt("ENO") + "\t");
				System.out.print(resultSet.getString(2) + "\t");
				System.out.print(resultSet.getDouble(3) + "\t");
				System.out.print(resultSet.getInt(4) + "\t");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (pstStatement != null) {
					pstStatement.close();
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
