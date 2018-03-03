package com.xxx.sup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xxx.dto.user.User;

public interface UserDao extends JpaRepository<User, Long> {

}
