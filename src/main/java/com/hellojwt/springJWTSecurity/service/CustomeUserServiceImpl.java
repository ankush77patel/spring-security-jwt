package com.hellojwt.springJWTSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellojwt.springJWTSecurity.model.User;
import com.hellojwt.springJWTSecurity.repository.UserRepository;

@Service
public class CustomeUserServiceImpl implements CustomUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserByUserName(String userName) {

		return userRepository.findByUserName(userName).orElseThrow();
	}

}
