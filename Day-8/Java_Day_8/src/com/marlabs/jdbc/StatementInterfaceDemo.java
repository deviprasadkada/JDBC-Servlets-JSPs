package com.marlabs.jdbc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StatementInterfaceDemo {
	public static void main(String[] args) {
		System.out.println("***********************************************");
		System.out.println("1) Display Department Employee Details Module");
		System.out
				.println("2) Display Department Employee Details Module With RSMD");
		System.out.println("3) DataBaseMetaData Interface Info");
		System.out.println("4) Register Employee Module");
		System.out.println("5) Batch-Updates Module");
		System.out.println("***********************************************");
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter The Choice");
			int choice = scanner.nextInt();
			StatementAPIExample statementAPIExample = new StatementAPIExample();
			switch (choice) {
			case 1:
				System.out.println("Enter departmentNumber ");
				int departmentNumber = scanner.nextInt();
				statementAPIExample.getEmployeeDetails(departmentNumber);
				break;
			case 2:
				System.out.println("Enter departmentNumber ");
				departmentNumber = scanner.nextInt();
				statementAPIExample.getEmployeeDetailsByRsmd(departmentNumber);
				break;
			case 3:
				statementAPIExample.dataBaseMetaDataInformation();
				break;
			case 4:
				System.out.println("Enter Employee Number");
				int empNumber = scanner.nextInt();
				System.out.println("Enter Employee Name");
				String empName = scanner.next();
				System.out.println("Enter Employee Salary");
				double empSalary = scanner.nextDouble();
				System.out.println("Enter Department Number");
				departmentNumber = scanner.nextInt();
				boolean registrationFlag = statementAPIExample
						.registerEmployee(empNumber, empName, empSalary,
								departmentNumber);
				if (registrationFlag) {
					System.out.println("Registered Successfully");
				}
				break;
			case 5:
				statementAPIExample.batchUpdatesExample();
				break;
			default:
				System.err.println("Please Enter Correct Choice");
				break;
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}
}
