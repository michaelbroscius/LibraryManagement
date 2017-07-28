package com.anthony.librarymanagement.dao;

import java.util.List;

import com.anthony.librarymanagement.entity.Role;

public interface RoleDAO {
	List<Role> getRoles();
	Role getRole(Integer id);

}
