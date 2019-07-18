package com.marlabs.jdbc;

public class PreparedStatementInterfaceDemo {
	public static void main(String[] args) {
		PreparedStatementAPIExample apiExample = new PreparedStatementAPIExample();

		boolean regFlag = apiExample
				.registerEmployee(2506, "AAA", 8500.34d, 10);
		System.out.println(regFlag);
		apiExample.displayEmployeesDetails(10);
	}
}
