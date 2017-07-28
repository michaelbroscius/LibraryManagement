package com.anthony.librarymanagement.service;

import java.util.Map;

import com.anthony.librarymanagement.entity.Role;

public interface RoleService {
	
	Map<String,String> getRoles();
	
	Role getRole(Integer id);

}
