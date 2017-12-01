package com.zhanghe.demo.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhanghe.demo.model.User;
import com.zhanghe.demo.service.UserService;
import com.zhanghe.demo.vo.InsertUserVO;
import com.zhanghe.demo.vo.UserListVO;
import com.zhanghe.demo.vo.demoVO;
import com.zhanghe.fast.starter.util.PageUtil;
import com.zhanghe.fast.starter.util.ReturnValue;
import com.zhanghe.fast.starter.vo.PageVO;

@Controller
public class DemoController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="hello",method=RequestMethod.GET)
	@ResponseBody
	public String helloworld(){
		return "helloworold";
	}
	
	@RequestMapping(value="helloworldhtml",method=RequestMethod.GET)
	public String helloworldhtml(){
		return "helloworld";
	}
	
	@RequestMapping(value="jsonresult",method=RequestMethod.GET)
	@ResponseBody
	public String jsonresult(){
		ReturnValue<User> result = new ReturnValue<User>(1, "访问成功!");
		User user = new User();
		user.setId(1L);
		user.setName("test");
		result.setObj(user);
		return result.toJson();
	}
	
	@RequestMapping(value="userlist",method=RequestMethod.GET)
	@ResponseBody
	public String listUser(UserListVO userListVO){
		ReturnValue<User> result = new ReturnValue<User>(1, "");
		List<User> resultlist = userService.getUserList(userListVO);
		result.setResult(resultlist);
		return result.toJson();
	}
	
	@RequestMapping(value="userlistbypage",method=RequestMethod.GET)
	@ResponseBody
	public String listUserBypage(UserListVO userListVO,PageVO<User> pagevo){
		ReturnValue<User> result = new ReturnValue<User>(1, "");
		PageUtil<User> res = userService.getUserListByPage(userListVO, pagevo.toPageUtil());
		result.setPage(res);
		return result.toJson();
	}
	
	@RequestMapping(value="validate",method=RequestMethod.GET)
	@ResponseBody
	public String validate(@Valid demoVO vo,BindingResult result){
		return new ReturnValue<User>(1, "").toJson(); 
	}
	
	@RequestMapping(value="insertuser",method=RequestMethod.GET)
	@ResponseBody
	public String inertUser(@Valid InsertUserVO insertvo,BindingResult result) throws IllegalAccessException, InvocationTargetException{
		User user = new User();
		BeanUtils.copyProperties(user, insertvo);
		userService.inserUser(user);
		return new ReturnValue<User>(1, "").toJson(); 
	}
}
