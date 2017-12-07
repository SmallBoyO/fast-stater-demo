package com.zhanghe.demo.service;

import java.util.List;

import com.zhanghe.demo.model.User;
import com.zhanghe.demo.vo.UserListVO;
import com.zhanghe.fast.starter.util.PageUtil;

public interface UserService {

	public List<User> getUserList(UserListVO user);
	
	public PageUtil<User> getUserListByPage(UserListVO user,PageUtil<User> page);
	
	public void inserUser(User user);
	
	public void test();
}
