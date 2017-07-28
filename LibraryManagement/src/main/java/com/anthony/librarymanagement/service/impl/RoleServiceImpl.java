package com.anthony.librarymanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anthony.librarymanagement.dao.RoleDAO;
import com.anthony.librarymanagement.entity.Role;
import com.anthony.librarymanagement.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDAO roleDao;

	@Transactional(readOnly = true)
	@Override
	public Map<String, String> getRoles() {
		List<Role> roles = roleDao.getRoles();
		Map<String, String> roleMap = new HashMap<String,String>();
		for(Role role:roles){
			roleMap.put(Integer.toString(role.getId()), role.getName());
			System.out.println(role.getName()+" / "+role.getId());
		}
		return roleMap;	
	}

	@Transactional(readOnly = true)
	@Override
	public Role getRole(Integer id) {
		Role role = roleDao.getRole(id);
		return role;
	}

}
