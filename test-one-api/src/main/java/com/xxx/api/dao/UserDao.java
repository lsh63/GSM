package com.xxx.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xxx.jwt.dto.User;

//import com.xxx.dto.user.User;

public interface UserDao extends JpaRepository<User, Long> {

}
