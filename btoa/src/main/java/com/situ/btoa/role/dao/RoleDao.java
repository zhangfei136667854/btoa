package com.situ.btoa.role.dao;

import org.springframework.stereotype.Repository;


import com.situ.btoa.role.domain.Role;
@Repository
public interface RoleDao  {

	Role getByRoleCode(String roleCode);
	Long save(Role role);

}
