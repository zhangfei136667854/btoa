package com.situ.btoa.role.service;

import java.util.List;

import com.situ.btoa.commons.LayuiResult;
import com.situ.btoa.role.domain.Role;

public interface RoleService {

	Long doPost(Role role);

	Role doGet(String roleCode);

	LayuiResult findRoleByPage(Integer page, Integer limit, Role role);

	Role findByRoleName(String roleName);

	Role getByRoleRowId(Long rowId);

	Long doUpdate(Role role);

	Long doDelete(Long rowId);
	List<Role> findAllRole();
	

}
