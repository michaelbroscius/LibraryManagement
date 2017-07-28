package com.anthony.librarymanagement.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anthony.librarymanagement.dao.RoleDAO;
import com.anthony.librarymanagement.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Role> getRoles() {
		@SuppressWarnings("unchecked")
		TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("from Role");
		return query.getResultList();
	}

	@Override
	public Role getRole(Integer id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("from Role where id=:id");
		query.setParameter("id", id);
		Role role = query.getSingleResult();

		return role;
	}

}
