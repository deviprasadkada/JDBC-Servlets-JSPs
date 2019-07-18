package com.marlabs.collections.activity;

import java.io.Serializable;

/**
 * @author srinivasa.challa
 *
 */
@SuppressWarnings("serial")
public class SingleAddress implements Serializable {
	private String lastName;
	private String firstName;
	private String streetAddress;
	private String city;
	private String coutry;
	private long postalCode;

	/**
	 * @param lastName
	 * @param firstName
	 * @param streetAddress
	 * @param city
	 * @param coutry
	 * @param postalCode
	 */
	public SingleAddress(String lastName, String firstName,
			String streetAddress, String city, String coutry, long postalCode) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.coutry = coutry;
		this.postalCode = postalCode;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the coutry
	 */
	public String getCoutry() {
		return coutry;
	}

	/**
	 * @return the postalCode
	 */
	public long getPostalCode() {
		return postalCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SingleAddress)) {
			return false;
		}
		SingleAddress other = (SingleAddress) obj;
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SingleAddress [lastName=" + lastName + ", firstName="
				+ firstName + ", streetAddress=" + streetAddress + ", city="
				+ city + ", coutry=" + coutry + ", postalCode=" + postalCode
				+ "]";
	}

}
