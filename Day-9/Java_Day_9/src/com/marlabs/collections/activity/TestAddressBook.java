package com.marlabs.collections.activity;

/**
 * @author srinivasa.challa
 *
 */
public class TestAddressBook {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("I Am From Main Method");
		SingleAddress singleAddress = new SingleAddress(" Challa", "Srinivas",
				"XyzStreet", "Mysore", "KA", 570023);
		SingleAddress singleAddress1 = new SingleAddress("Challa",
				"Srinivasa Reddy", "ABCStreet", "Mysore", "KA", 570023);
		// SingleAddress singleAddress2 = null;
		AddressBook addressBook = new AddressBookImpl();
		try {
			addressBook.addAddressEntry(singleAddress);
			addressBook.addAddressEntry(singleAddress1);
			// addressBook.addAddressEntry(singleAddress2);
			addressBook.listAddressEntrys();
			addressBook.removeAddressEntry("Srinivasa Reddy");
			// addressBook.removeAddressEntry(null);
			addressBook.listAddressEntrys();
		} catch (DuplicateAddressException e) {
			System.err.println("Error Message From Main Method:"
					+ e.getMessage());
		} catch (NullPointerException e) {
			System.err.println("Error Message From Main Method:"
					+ e.getMessage());
		}
		System.out.println("End Of Main Method");
	}

}
