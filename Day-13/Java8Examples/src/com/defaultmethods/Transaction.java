package com.defaultmethods;

public interface Transaction {
	
	default void printInfo() {
		System.out.println("From Transaction...");
	}

}
