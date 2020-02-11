package com.situ.btoa.role.service;

import com.situ.btoa.role.domain.Role;

public interface RoleService {

	Long doPost(Role role);

	Role doGet(String roleCode);
	

}
