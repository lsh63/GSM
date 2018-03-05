package com.xxx.app.user.web;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.api.service.UserServiceImpl;
import com.xxx.jwt.dto.User;
import com.xxx.jwt.service.impl.JwtUserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders="Authorization")//跨域设置
@RestController
@RequestMapping(value="user")
public class UserRestController {

	@Autowired
	UserServiceImpl userServiceImpl;
	@Autowired
	JwtUserDetailsServiceImpl jwtUserDetailsServiceImpl;

	/*
	 * 注册
	 * http://127.0.0.1:8080/user/create
	 * */
	@RequestMapping(value="create",method=RequestMethod.POST)
	public Map<String, Object> CreateUser(
			@RequestParam(value="username", required=true)/*后台控制器获取参数*/ String username,
			@RequestParam(value="password", required=true) String password,
			@RequestParam(value="firstname", required=false) String firstname,
			@RequestParam(value="lastname", required=false) String lastname,
			@RequestParam(value="email", required=false) String email) throws AuthenticationException {
		Map<String, Object> map = new HashMap<String, Object>();
		//确保用户名不为空，不能用username == null；
		if(username == ""||username == null) {
			map.put("data", 101);
		}
		//确保密码不为空
		if(password == "") {
			map.put("data",102);
		}
		//确保邮箱格式正确
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean e = email.matches(EMAIL_REGEX);
		if(!e) {
			map.put("data", 103);
		}
		//确保用户名唯一
		if(userServiceImpl.findUserByUsername(username) != null){
			map.put("data", 104);
		}
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());//密码加密加盐，备注：密码匹配BCrypt.checkpw(candidate, hashed)
		String imgurl = "/images/defaultUserImg.jpg";
		User user = new User(username, hashed, firstname, lastname, email, true, new Timestamp(new Date().getTime()),imgurl);
		user = userServiceImpl.saveUser(user);
		if(user != null) {
			map.put("data", 200);
		}else {
			map.put("data", 500);
		}
		return map;
	}

	/*
	 * 查询所有用户
	 * http://127.0.0.1:8080/user/alluser
	 * */
	@RequestMapping(value="alluser",method=RequestMethod.GET,
			produces = {"application/JSON"}//指定映射类型,结合@ResponseBody注解用请求的媒体类型来产生对象
			)
	@ResponseBody
	public List<User> findAllUser(){
		List<User> alluser = userServiceImpl.findAllUser();
		return alluser;	
	}

	/*
	 * 关键词搜索用户
	 * http://127.0.0.1:8080/user/keyuser
	 * */
	@RequestMapping(value="keyuser",method=RequestMethod.GET, produces = {"application/JSON"})
	@ResponseBody
	public List<User> findUserByKey(
			@RequestParam(value="key") String key){
		List<User> keyuser = userServiceImpl.findUserByKey(key);
		return keyuser;
	}



}
