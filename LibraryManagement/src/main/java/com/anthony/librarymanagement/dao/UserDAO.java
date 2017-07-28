package com.anthony.librarymanagement.dao;

import java.util.List;

import javax.persistence.NonUniqueResultException;

import com.anthony.librarymanagement.entity.User;

public interface UserDAO {

	void add(User user);

	List<User> getUsers();

	/**
	 * 
	 * @param email
	 * @param password
	 * @return User that matches email and password if they are valid, otherwise
	 *         returns null
	 * @throws NonUniqueResultException
	 *             if there is more than one user with given email
	 */
	User validateUser(String email, String password) throws NonUniqueResultException;

	public User getUser(Long id);

}
