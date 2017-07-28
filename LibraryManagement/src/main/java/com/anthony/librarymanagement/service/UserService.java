package com.anthony.librarymanagement.service;

import java.util.List;

import com.anthony.librarymanagement.dto.UserDto;
import com.anthony.librarymanagement.entity.User;



public interface UserService {
	void add(User user);
	void add(UserDto user);
	List<User> getUsers();
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @return UserDto for User with email and password if valid, otherwise null
	 */
	public UserDto validateUser(String email, String password);
	
	public UserDto getUser(String id);
	
	
	public User getUser(Long id);

}
