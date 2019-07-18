package com.marlabs.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.marlabs.collections.activity.AddressBook;
import com.marlabs.collections.activity.AddressBookImpl;
import com.marlabs.collections.activity.DuplicateAddressException;
import com.marlabs.collections.activity.SingleAddress;

/**
 * @author srinivasa.challa
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressBookImplTest {
	private static AddressBook addressBook = null;

	/**
	 * 
	 */
	@BeforeClass
	public static void init() {
		System.out.println("From init Method");
		addressBook = new AddressBookImpl();
	}

	/**
	 * 
	 */
	@AfterClass
	public static void destroy() {
		System.out.println("From Destroy Method");
		addressBook = null;
	}

	/**
	 * 
	 */
	@Test
	public void testAddAddressEntry() {
		SingleAddress singleAddress = new SingleAddress(" Challa",
				"Srinivasa Reddy", "XyzStreet", "Mysore", "KA", 570023);
		try {
			boolean result = addressBook.addAddressEntry(singleAddress);
			// assertEquals(true, result);
			assertTrue(result);
		} catch (NullPointerException e) {
			fail();
		} catch (DuplicateAddressException e) {
			fail();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testAddAddressEntry1() {
		SingleAddress singleAddress = null;
		try {
			boolean result = addressBook.addAddressEntry(singleAddress);
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		} catch (DuplicateAddressException e) {
			fail();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testAddAddressEntry2() {
		SingleAddress singleAddress = new SingleAddress(" Challa",
				"Srinivasa Reddy", "XyzStreet", "Mysore", "KA", 570023);
		try {
			boolean result = addressBook.addAddressEntry(singleAddress);
		} catch (NullPointerException e) {
			fail();
		} catch (DuplicateAddressException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	@Test
	public void testRemoveAddress() {
		try {
			boolean result = addressBook.removeAddressEntry("Srinivasa Reddy");
			assertTrue(result);
		} catch (NullPointerException e) {
			fail();
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testRemoveAddress1() {
		try {
			boolean result = addressBook.removeAddressEntry(null);
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void testRemoveAddress2() {
		boolean result = addressBook.removeAddressEntry(null);
	}

	/**
	 * 
	 */
	@Test
	public void testRemoveAddress3() {
		try {
			boolean result = addressBook.removeAddressEntry("Srinivasa");
			assertFalse(result);
		} catch (NullPointerException e) {
			fail();
		}
	}

}
