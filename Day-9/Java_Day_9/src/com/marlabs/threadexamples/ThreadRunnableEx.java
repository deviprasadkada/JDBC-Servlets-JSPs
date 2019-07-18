package com.marlabs.threadexamples;

class ThreadRunnableExample implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Printing From "
					+ Thread.currentThread().getName() + " , the value of i :"
					+ i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}

/**
 * @author srinivasa.challa
 *
 */
public class ThreadRunnableEx {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ThreadRunnableExample r1 = new ThreadRunnableExample();
		ThreadRunnableExample r2 = new ThreadRunnableExample();
		Thread t1 = new Thread(r1, "First");
		Thread t2 = new Thread(r2, "Second");
		t1.start();
		t2.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "::" + i);
			Thread.sleep(100);
		}
	}
}
