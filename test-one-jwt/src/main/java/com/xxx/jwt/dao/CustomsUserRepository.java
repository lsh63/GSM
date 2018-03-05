package com.xxx.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xxx.jwt.dto.User;

/**
 * Created by stephan on 20.03.16.
 */
public interface CustomsUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
}
