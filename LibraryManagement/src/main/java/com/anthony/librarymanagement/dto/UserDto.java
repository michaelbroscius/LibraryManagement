package com.anthony.librarymanagement.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.anthony.librarymanagement.entity.User;

public class UserDto {

	private Long id;

	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	private String name;

	@Email(message = "{user.email.invalid}")
	private String email;

	private String password;

	private String role;

	/**
	 * 
	 * @param user
	 * @return UserDto from user
	 */
	public static UserDto getUserDtoFromUser(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setRole(Integer.toString(user.getRole().getId()));
		userDto.setPassword(user.getPassword());

		return userDto;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
