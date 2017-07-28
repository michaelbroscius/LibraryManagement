package com.anthony.librarymanagement.service.impl;

import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anthony.librarymanagement.dao.RoleDAO;
import com.anthony.librarymanagement.dao.UserDAO;
import com.anthony.librarymanagement.dto.UserDto;
import com.anthony.librarymanagement.entity.User;
import com.anthony.librarymanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private RoleDAO roleDao;

	@Transactional
	@Override
	public void add(User user) {
		userDao.add(user);

	}

	@Transactional(readOnly = true)
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Transactional(readOnly = true)
	@Override
	public UserDto getUser(String id) {
		User user = userDao.getUser(Long.parseLong(id));
		UserDto userDto = UserDto.getUserDtoFromUser(user);
		return userDto;
	}

	@Transactional(readOnly = true)
	@Override
	public UserDto validateUser(String email, String password) {

		if (email == null || password == null || email.equals("") || password.equals("")) {
			return null;
		}
		UserDto userDto = null;
		try {
			User user = userDao.validateUser(email, password);
			if (user == null) {
				return null;
			}

			userDto = UserDto.getUserDtoFromUser(user);

		} catch (NonUniqueResultException e) {
			System.err.println("More than one user with e-mail " + email + ".");
			return null;
		}

		return userDto;
	}

	@Transactional
	@Override
	public void add(UserDto userDto) {
		System.out.println("Inside add userdto");
		User user = new User();
		if (userDto.getId() != null)
			user.setId(userDto.getId());

		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());

		user.setRole(roleDao.getRole(Integer.parseInt(userDto.getRole())));

		userDao.add(user);
	}

	@Override
	public User getUser(Long id) {
		
		return userDao.getUser(id);
	}

}
