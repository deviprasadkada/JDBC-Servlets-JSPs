package com.marlabs.threadexamples;

class ThreadEx extends Thread {
	private String name;

	public ThreadEx(String name) {
		this.name = name;
		System.out.println(this.name);
		this.setName(name);
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("From Thread:"
					+ Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * @author srinivasa.challa
 *
 */
public class ThreadExample1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("I Am From Main Method");
		Thread mainThread = Thread.currentThread();
		mainThread.setName("Main Thread");
		System.out.println("Execution Status Of Main Thread:"
				+ mainThread.isAlive()); // true

		ThreadEx threadEx = new ThreadEx("Child-1");
		ThreadEx threadEx1 = new ThreadEx("Child-2");
		ThreadEx threadEx2 = new ThreadEx("Child-3");
		System.out.println("Execution Status Of Child Thread:"
				+ threadEx.isAlive()); // false
		threadEx.setDaemon(true);

		/*
		 * threadEx.run(); threadEx1.run(); threadEx2.run();
		 */

		threadEx.start();
		threadEx1.start();
		threadEx2.start();

		mainThread.setPriority(10);
		threadEx.setPriority(9);
		threadEx1.setPriority(7);

		System.out.println("Execution Status Of Child Thread:"
				+ threadEx.isAlive()); // true

		for (int i = 10; i >= 0; i--) {
			System.out.println("From Thread:"
					+ Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		System.out.println("isDeamon Thread:" + threadEx.isDaemon());
		System.out.println("Execution Status Of Child Thread At The End:"
				+ threadEx.isAlive());
		System.out.println("End Of Main Method");
	}
}
