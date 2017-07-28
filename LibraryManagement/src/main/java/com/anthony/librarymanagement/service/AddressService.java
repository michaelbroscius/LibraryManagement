package com.anthony.librarymanagement.service;

import java.util.List;

import com.anthony.librarymanagement.entity.Address;

public interface AddressService {
	void add(Address address);
	
	List<Address> getAddresses();
	public Address getAddress(String id);
}
