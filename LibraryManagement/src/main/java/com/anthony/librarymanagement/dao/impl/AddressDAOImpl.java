package com.anthony.librarymanagement.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anthony.librarymanagement.dao.AddressDAO;
import com.anthony.librarymanagement.entity.Address;

@Repository
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Address address) {
		if(address.getId()==null)
		sessionFactory.getCurrentSession().save(address);
		else
			sessionFactory.getCurrentSession().merge(address);
	}

	@Override
	public List<Address> getAddresses() {
		@SuppressWarnings("unchecked")
		TypedQuery<Address> query = sessionFactory.getCurrentSession().createQuery("from Address");
		return query.getResultList();
	}

	@Override
	public Address getAddress(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Address> query = sessionFactory.getCurrentSession().createQuery("from User where id=:id");
		query.setParameter("id", id);
		Address address = query.getSingleResult();

			return address;
	}
}
