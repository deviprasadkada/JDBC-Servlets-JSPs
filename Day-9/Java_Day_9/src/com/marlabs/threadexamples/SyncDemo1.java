package com.marlabs.threadexamples;

class Account {
	private int bal = 0; // instance variable - Not thread safe

	/*
	 * // Synchronized Method Level public synchronized void deposit(int amt) {
	 * // public void deposit(int amt) { bal = bal + amt;
	 * System.out.println("Entered:" + Thread.currentThread().getName());
	 * System.out.println("Current Balance=" + bal);
	 * System.out.println("Exited:" + Thread.currentThread().getName()); }
	 */

	public void deposit(int amt) {
		System.out.println("Entered Into deposit Method");
		synchronized (this) {
			System.out.println("Entered:" + Thread.currentThread().getName());
			bal = bal + amt;
			System.out.println("Current Balance=" + bal);
			System.out.println("Exited:" + Thread.currentThread().getName());
		}
		System.out.println("End of deposit Method");
	}

	public int getBal() {
		return bal;
	}
}

class Customer extends Thread {
	private Account ac; // HAS A Relation

	public Customer(Account ac) {
		this.ac = ac;
	}

	@Override
	public void run() {
		ac.deposit(1000);
	}
}

/**
 * @author srinivasa.challa
 *
 */
public class SyncDemo1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account ac = new Account();
		Customer cu[] = new Customer[5];
		for (int i = 0; i < 5; i++) {
			cu[i] = new Customer(ac);
		}
		for (int i = 0; i < 5; i++) {
			cu[i].start();
		}
		try {
			for (int i = 0; i < 5; i++) {
				cu[i].join();
			}
		} catch (InterruptedException ie) {
			System.out.println("Problem in Thread execution");
		}
		System.out.println("Total Bal=" + ac.getBal());

	}
}
