package com.anthony.librarymanagement.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anthony.librarymanagement.dto.UserDto;
import com.anthony.librarymanagement.entity.Role;
import com.anthony.librarymanagement.entity.User;
import com.anthony.librarymanagement.service.RoleService;
import com.anthony.librarymanagement.service.UserService;

@RestController
public class UserAuthenticationService {
	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@RequestMapping(value = "/rest/authenticate", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Role> getRole(@RequestBody User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		Role role = new Role();
		ResponseEntity<Role> responseEntityRole;
		UserDto userDto = userService.validateUser(email, password);
		if (userDto == null) {
			responseEntityRole = new ResponseEntity<Role>(role, HttpStatus.NO_CONTENT);
		} else {
			role = roleService.getRole(Integer.parseInt((userDto.getRole())));
			responseEntityRole = new ResponseEntity<Role>(role, HttpStatus.OK);
		}
		return responseEntityRole;
	}
}
