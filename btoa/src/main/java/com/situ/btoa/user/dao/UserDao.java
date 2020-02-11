package com.situ.btoa.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.btoa.base.BaseDao;
import com.situ.btoa.commons.Pagination;
import com.situ.btoa.user.domain.User;

@Repository
public interface UserDao extends BaseDao<User> {
	/**
	 * 根据用户账号和密码查询实例
	 * 
	 * @param userCode
	 * @param userPass
	 * @return
	 */
	User findByCodeAndPass(@Param("userCode") String userCode, @Param("userPass") String userPass);

	User findByCodeAndRowId(@Param("userCode") String userCode, @Param("rowId") Long rowId);

	User findByCode(String userCode);

	void update4Lock(@Param("rowId")Long rowId, @Param("isLock")Integer isLock);
	
	void updatePass(@Param("userCode") String userCode, @Param("userPass") String userPass);

	Integer count();

	List<User> findByPage(@Param("pagination") Pagination buildPagination,@Param("user") User user1);
}
