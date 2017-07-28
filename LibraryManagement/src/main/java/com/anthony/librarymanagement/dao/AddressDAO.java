package com.anthony.librarymanagement.dao;

import java.util.List;

import com.anthony.librarymanagement.entity.Address;

public interface AddressDAO {
	public void add(Address address);

	public List<Address> getAddresses();

	public Address getAddress(Long id);
}