package com.marlabs.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementDemo {

	public static void procedureCallExample() {
		Connection connection = null;
		CallableStatement cstStatement = null;
		try {
			connection = DBUtil.getConnection();
			cstStatement = connection.prepareCall("{call getSal(?,?)}");
			cstStatement.setInt(1, 5001);
			cstStatement.registerOutParameter(2, Types.DOUBLE);
			cstStatement.execute();
			System.out.println("Result Is:" + cstStatement.getDouble(2));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cstStatement != null) {
					cstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void functionCallExample() {
		Connection connection = null;
		CallableStatement cstStatement = null;
		try {
			connection = DBUtil.getConnection();
			cstStatement = connection.prepareCall("{?=call getAvg(?,?)}");
			cstStatement.registerOutParameter(1, Types.DOUBLE);
			cstStatement.setInt(2, 5001);
			cstStatement.setInt(3, 5002);
			cstStatement.execute();
			System.out
					.println("Average Salary Is:" + cstStatement.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cstStatement != null) {
					cstStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		procedureCallExample();
		functionCallExample();
	}
}
