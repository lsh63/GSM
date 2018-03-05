package com.xxx.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.dao.UserDao;
import com.xxx.jwt.dto.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	public List<User> findAllUser(){
		List<User> ulist = userdao.findAll();
		return ulist;	
	}

}
