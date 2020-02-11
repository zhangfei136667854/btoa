package com.situ.btoa.user.service;

import java.util.List;

import com.situ.btoa.base.FieldParam;
import com.situ.btoa.commons.LayuiResult;
import com.situ.btoa.user.domain.User;

public interface UserService {
	Long saveUser(User user, Integer userKind);

	void initAdminData();

	List<User> findAllUser();

	String checkUserCode(FieldParam fieldParam);

	Long addUser(User user);

	Integer doUserLock(Long rowId, Integer isLock);
	
	Integer getCount();

	Long doDelete(Long rowId);

	User doGet(Long rowId);

	Long doUpdata(User user);

	Object checkByUserCode(String userCode);

	LayuiResult findUserByPage(Integer page, Integer limit, User user);
}
