package com.marlabs.threadexamples;

class DeamonThreadEx extends Thread {

	public DeamonThreadEx(String name) {
		this.setName(name);
	}

	@Override
	public void run() {
		System.out.println("Run Method");
		System.out.println("Deamon Thread:" + Thread.currentThread().getName());
	}
}

/**
 * @author srinivasa.challa
 *
 */
public class ThreadExample {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = Thread.currentThread();
		System.out.println("Name of the Thread:" + t1.toString());
		t1.setName("java");
		System.out.println("Name after modified:" + t1);
		System.out.println("Status of the Thread1:" + t1.isAlive());// true
		Thread t2 = new Thread();
		System.out.println("Status of the Thread2:" + t2.isAlive()); // false
		System.out.println("Default Name of the  Thread2:" + t2.getName());
		System.out.println("MIN PRIORITY:" + Thread.MIN_PRIORITY);
		System.out.println("MAX PRIORITY:" + Thread.MAX_PRIORITY);
		System.out.println("NORM PRIORITY:" + Thread.NORM_PRIORITY);
		DeamonThreadEx threadEx = new DeamonThreadEx("Child1");
		threadEx.setDaemon(true);
		threadEx.start();
		System.out.println("DeamonThreadEx-Child1 isDaemon Thread:"
				+ threadEx.isDaemon());
		System.out.println("Status of the Deamon Thread-User Defined:"
				+ threadEx.isAlive());
		t2.setPriority(6);
		System.out.println(t2.getPriority());

	}
}
