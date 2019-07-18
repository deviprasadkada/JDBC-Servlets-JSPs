package com.threads;

import java.util.Date;

public class SingleThread implements Runnable {
	SingleThread() {
		Thread t1 = new Thread(this);
		t1.start();
	}

	@Override
	public void run() {
		for (int i = 5; i > 0; i--) {
			System.out.println(i + ":" + new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new SingleThread();
	}

}
