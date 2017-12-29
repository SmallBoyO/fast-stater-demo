package com.zhanghe.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zhanghe.demo.mapper.UserMapper;
import com.zhanghe.demo.model.User;
import com.zhanghe.demo.service.UserService;
import com.zhanghe.demo.vo.UserListVO;
import com.zhanghe.fast.starter.util.PageUtil;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getUserList( UserListVO user ) {
		Wrapper<User> wrapper = new EntityWrapper<User>();
		if(user.getUserName()!=null){
			wrapper.eq(User.USERNAME, user.getUserName());
		}
		if(user.getName()!=null){
			wrapper.eq(User.NAME, user.getName());
		}
		if(user.getStatus()!=null){
			wrapper.eq(User.STATUS, user.getStatus());
		}
		return userMapper.selectList(wrapper);
	}

	public PageUtil<User> getUserListByPage( UserListVO user ,PageUtil<User> page ) {
		Wrapper<User> wrapper = new EntityWrapper<User>();
		if(user.getUserName()!=null){
			wrapper.eq(User.USERNAME, user.getUserName());
		}
		if(user.getName()!=null){
			wrapper.eq(User.NAME, user.getName());
		}
		if(user.getStatus()!=null){
			wrapper.eq(User.STATUS, user.getStatus());
		}
		page.setResult(userMapper.selectPage(page.toPage(), wrapper));
		page.setTotal();
		return page;
	}

	public void inserUser(User user){
		userMapper.insert(user);
	}
	
	
	public void test(){
		System.out.println(userMapper.CountUser());
		System.out.println(userMapper.CountUser());
		System.out.println(userMapper.CountUser());
	}
}
