package com.situ.btoa.role.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.btoa.commons.Pagination;
import com.situ.btoa.role.domain.Role;
@Repository
public interface RoleDao  {

	Role getByRoleCode(String roleCode);
	Long save(Role role);
	Integer getCount(@Param("role")Role role);
	List<Role> findByPage(@Param("pagination") Pagination buildPagination, @Param("role") Role role);
	Role findByName(String roleName);
	Role getByRowId(Long rowId);
	Long update(Role role);
	Long delete(Long rowId);
	List<Role> findAll();

}
