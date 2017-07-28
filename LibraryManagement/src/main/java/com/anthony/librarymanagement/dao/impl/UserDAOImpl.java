package com.anthony.librarymanagement.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anthony.librarymanagement.dao.UserDAO;
import com.anthony.librarymanagement.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(User user) {
		/*
		 * Role role = new Role(); role.setName("My Role");
		 * sessionFactory.getCurrentSession().save(role); user.setRole(role);
		 */
		if (user.getId() == null)
			sessionFactory.getCurrentSession().save(user);
		else
			sessionFactory.getCurrentSession().merge(user);

	}

	@Override
	public List<User> getUsers() {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
		return query.getResultList();
	}

	@Override
	public User validateUser(String email, String password) throws NonUniqueResultException {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where email=:email");
		query.setParameter("email", email);
		User user;
		try {
			user = query.getSingleResult();
			System.out.println("For user " + user.getName() + ", role is " + user.getRole().getName());
			if (!user.getPassword().equals(password)) {
				user = null; // If user's password does not match password
								// parameter, we will return null
			}
			
		} catch (NoResultException noResultexcep) {
			/* no such user, so return null */
			return null;
		} catch (NonUniqueResultException e) {
			System.err.println("Tried to validate e-mail that matches more than one user.");
			throw (e);
		}
		return user;
	}

	@Override
	public User getUser(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where id=:id");
		query.setParameter("id", id);
		User user = query.getSingleResult();

		return user;
	}

}
