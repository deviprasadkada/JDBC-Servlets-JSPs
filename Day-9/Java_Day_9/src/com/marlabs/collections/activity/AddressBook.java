package com.marlabs.collections.activity;

/**
 * @author srinivasa.challa
 *
 */
public interface AddressBook {

	/**
	 * @param singleAddress
	 * @return additionFlag
	 * @throws DuplicateAddressException
	 * @throws NullPointerException
	 */
	public abstract boolean addAddressEntry(final SingleAddress singleAddress)
			throws DuplicateAddressException, NullPointerException;

	/**
	 * @param firstName
	 * @return removeFlag
	 * @throws NullPointerException
	 */
	public abstract boolean removeAddressEntry(final String firstName)
			throws NullPointerException;

	/**
	 * 
	 */
	public abstract void listAddressEntrys();
}
