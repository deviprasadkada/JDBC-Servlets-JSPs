package com.marlabs.collections.activity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author srinivasa.challa
 *
 */
public class AddressBookImpl implements AddressBook {
	private Set<SingleAddress> addressBook; // HAS A RELATION

	/**
	 * 
	 */
	public AddressBookImpl() {
		addressBook = new HashSet<SingleAddress>();
	}

	@Override
	public boolean addAddressEntry(final SingleAddress singleAddress)
			throws DuplicateAddressException, NullPointerException {
		final String METHOD_NAME = "addAddressEntry";
		System.out.println("Method Invoked:" + METHOD_NAME + ":"
				+ singleAddress);
		boolean additionFlag = false;
		if (singleAddress == null) {
			throw new NullPointerException(
					"Dont Pass Null Reference For Address");
		}
		additionFlag = addressBook.add(singleAddress); // boolean
		if (!additionFlag) {
			throw new DuplicateAddressException("Duplicate Address Found");
		}
		System.out.println("Response From The Method:" + METHOD_NAME + ":"
				+ additionFlag);
		return additionFlag;
	}

	@Override
	public boolean removeAddressEntry(final String firstName)
			throws NullPointerException {
		final String METHOD_NAME = "removeAddressEntry";
		System.out.println("Method Invoked:" + METHOD_NAME + ":" + firstName);
		boolean removeFlag = false;
		if (firstName == null) {
			throw new NullPointerException("Dont Pass Null For First Name");
		}
		Iterator<SingleAddress> iterator = addressBook.iterator();
		while (iterator.hasNext()) {
			SingleAddress singleAddress = iterator.next();
			if (firstName.equals(singleAddress.getFirstName())) {
				iterator.remove();
				removeFlag = true;
			}
		}
		System.out.println("Response From The Method:" + METHOD_NAME + ":"
				+ removeFlag);
		return removeFlag;
	}

	@Override
	public void listAddressEntrys() {
		System.out
				.println("******************************************************");
		for (SingleAddress singleAddress : addressBook) {
			System.out.println(singleAddress);
		}
		System.out
				.println("******************************************************");
	}
}
