package com.defaultmethods;

public class CustomerImpl implements Customer, Transaction {
	
	public void populate() {
		//...
		
	}
	
	public void printInfo() {
		Customer.super.printInfo();
	}
	
	public static void main(String a[]) {
		CustomerImpl impl = new CustomerImpl();
		impl.printInfo();
	}

}
