package com.marlabs.threadexamples;

/**
 * @author srinivasa.challa
 *
 */
public class SingletonExample {
	private static SingletonExample singletonObject = null;

	private SingletonExample() {
		// Some Message
	}

	// synchronized-Allows only one thread to access this method at a point of
	// time
	/**
	 * @return singletonObject
	 */
	public synchronized static SingletonExample getInstance() {
		if (singletonObject == null) {
			System.out.println("I Am From if condition");
			singletonObject = new SingletonExample();
			singletonObject.loadUserDetails();
		}
		return singletonObject;
	}

	/**
	 * 
	 */
	private void loadUserDetails() {
		// JDBC
		System.out.println("User Name:" + "Admin" + "\t" + "PassWord:"
				+ "Admin@123");
		System.out.println("User Name:" + "Admin1" + "\t" + "PassWord:"
				+ "Admin@12");
		System.out.println("User Name:" + "Admin2" + "\t" + "PassWord:"
				+ "Admin");
	}
}
