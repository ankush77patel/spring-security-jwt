package com.hellojwt.springJWTSecurity.service;

import org.springframework.stereotype.Service;

import com.hellojwt.springJWTSecurity.model.User;

@Service
public interface CustomUserService {
	User findUserByUserName(String userName);
}
