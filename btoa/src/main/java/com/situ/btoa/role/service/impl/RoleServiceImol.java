package com.situ.btoa.role.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.btoa.commons.LayuiResult;
import com.situ.btoa.role.dao.RoleDao;
import com.situ.btoa.role.domain.Role;
import com.situ.btoa.role.service.RoleService;
import com.situ.btoa.syscount.util.SysCountUtils;
import com.situ.btoa.user.service.impl.UserServiceImpl;
import com.situ.btoa.util.DAOUtils;
@Service
public class RoleServiceImol implements Serializable ,RoleService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Log LOG = LogFactory.getLog(RoleServiceImol.class);

	@Autowired
	private RoleDao roleDao ;
	@Autowired
	private SysCountUtils sysCountUtils;

	@Override
	public Long doPost(Role role) {
		role.setRoleCode(sysCountUtils.buildRoleCode());
		role.setActiveFlag(1);
		role.setCreateBy("sys");
		role.setCreateDate(new Date());
		return roleDao.save(role);
	}

	@Override
	public Role doGet(String roleCode) {
		// TODO Auto-generated method stub
		return roleDao.getByRoleCode(roleCode);
	}

	@Override
	public LayuiResult findRoleByPage(Integer page, Integer limit, Role role) {
		// TODO Auto-generated method stub
		//通过反射机制将类的实例中的""重新赋值为null,方便MyBatis中多条件查询SQL语句的拼写
				Role searchParam = DAOUtils.buildSearchParam(role);
				//查询出符合条件的一共有多少条记录。
				Integer dataCount = roleDao.getCount(searchParam);
				//根据分页的请求信息查询出数量列表。
				List<Role> roleList = roleDao.findByPage(DAOUtils.buildPagination(page, limit), searchParam);
				return new LayuiResult("", roleList, 0, dataCount);
	}
	@PostConstruct
	public void initMethod() {
		LOG.debug("当role实例生成调用的方法"+1);
	}

	@Override
	public Role findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleDao.findByName(roleName);
	}

	@Override
	public Role getByRoleRowId(Long rowId) {
		// TODO Auto-generated method stub
		return roleDao.getByRowId(rowId);
	}

	@Override
	public Long doUpdate(Role role) {
		// TODO Auto-generated method stub
		return roleDao.update(role);
	}

	@Override
	public Long doDelete(Long rowId) {
		// TODO Auto-generated method stub
		return roleDao.delete(rowId);
	}

	@Override
	public List<Role> findAllRole() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	

}
