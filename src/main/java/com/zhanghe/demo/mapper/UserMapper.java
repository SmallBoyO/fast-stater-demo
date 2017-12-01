package com.zhanghe.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhanghe.demo.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
	
	@Select("select count(*) from user")
	public Integer CountUser();
		
}
