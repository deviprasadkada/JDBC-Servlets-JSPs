package com.defaultmethods;

public interface Customer {
	
	public void populate();
	
	default void printInfo() {
		System.out.println("ORIGINAL INFO");
	}
	
	default void process() {
		System.out.println("Processed!");
	}

}
