package com.marlabs.threadexamples;

class ThreadDemo extends Thread {
	private String name;

	public ThreadDemo(String name) {
		this.name = name;
		this.setName(this.name);
	}

	@Override
	public void run() {
		SingletonExample instance = SingletonExample.getInstance();
		System.out.println("ThreadName:" + Thread.currentThread().getName()
				+ ":" + instance);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**
 * @author srinivasa.challa
 *
 */
public class MultiThreadedSingleton {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadDemo threadDemo = new ThreadDemo("Child-1");
		ThreadDemo threadDemo1 = new ThreadDemo("Child-2");
		ThreadDemo threadDemo2 = new ThreadDemo("Child-3");
		ThreadDemo threadDemo3 = new ThreadDemo("Child-4");
		ThreadDemo threadDemo4 = new ThreadDemo("Child-5");
		threadDemo.start();
		threadDemo1.start();
		threadDemo2.start();
		threadDemo3.start();
		threadDemo4.start();
	}
}
