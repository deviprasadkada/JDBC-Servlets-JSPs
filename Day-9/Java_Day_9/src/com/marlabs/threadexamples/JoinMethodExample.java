package com.marlabs.threadexamples;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Th extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println("Thread Th:");
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Th1 extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 10; i > 0; i--) {
				System.out.println("Thread Th1:");
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Th2 extends Thread {
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("Enter the Base Value:");
			float base = Float.parseFloat(br.readLine());
			System.out.println("Enter the Height Value:");
			float height = Float.parseFloat(br.readLine());
			double area = 0.5 * base * height;

			System.out.println("Area is:" + area);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

/**
 * @author srinivasa.challa
 *
 */
public class JoinMethodExample {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("I AM From Main Method");
		Th thread1 = new Th();
		Th1 thread2 = new Th1();
		Th2 thread3 = new Th2();
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread3.start();
		try {
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End Of Main Method");

	}
}
