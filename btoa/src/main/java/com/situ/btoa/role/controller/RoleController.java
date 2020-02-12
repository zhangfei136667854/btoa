package com.situ.btoa.role.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.situ.btoa.commons.LayuiResult;
import com.situ.btoa.role.domain.Role;
import com.situ.btoa.role.service.RoleService;
import com.situ.btoa.user.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/role")
public class RoleController {
	private static final Log LOG = LogFactory.getLog(RoleController.class);

	@Autowired
	private RoleService roleService;

	@PostMapping
	public Long doPost(Role role) {
		return roleService.doPost(role);
	}

	@GetMapping("/checkRoleCode")
	public Integer doGet(String roleCode) {
		int num = 1;
		Role role = roleService.doGet(roleCode);
		if (role != null) {
			num = 0;
		}

		return num;
	}
	@GetMapping("/index")
	public ModelAndView goRoleIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("role/role_index");
		return modelAndView;
	}
	@GetMapping("/{page}/{limit}")
	public LayuiResult findRoleByPage(@PathVariable Integer page, @PathVariable Integer limit, Role role) {
		return roleService.findRoleByPage(page, limit, role);
	}
	@GetMapping("/goadd")
	public ModelAndView goRoleList(ModelAndView modelAndView) {
		modelAndView.setViewName("role/role_add_edit");
		return modelAndView ;
	}
	@GetMapping("/checkname")
	public Integer goCheckByRoleName(String roleName) {
		 
			Role role=	roleService.findByRoleName(roleName);
			//1表示不可用 0 表示可用
			return role!=null?1:0;
	}
	@GetMapping("/{rowId}")
	public Role doGet(@PathVariable("rowId") Long rowId) {
		return roleService.getByRoleRowId(rowId);
	}
@PutMapping
public Long doUpdate(Role role) {
	return roleService.doUpdate(role);
}
@DeleteMapping("/{rowId}")
public Long doDelete(@PathVariable("rowId")Long rowId) {
	return roleService.doDelete(rowId);
}

}
