package com.anthony.librarymanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anthony.librarymanagement.dao.AddressDAO;
import com.anthony.librarymanagement.entity.Address;
import com.anthony.librarymanagement.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO addressDao;

	@Transactional
	@Override
	public void add(Address address) {
		addressDao.add(address);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Address> getAddresses() {
		return addressDao.getAddresses();
	}

	@Transactional(readOnly = true)
	@Override
	public Address getAddress(String id) {
		Address address = addressDao.getAddress(Long.parseLong(id));

		return address;
	}
}
