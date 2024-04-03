package com.hellojwt.springJWTSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hellojwt.springJWTSecurity.model.User;
import com.hellojwt.springJWTSecurity.service.CustomUserService;


@RequestMapping("/v1/userController")
@RestController
public class UserController {

	@Autowired
	private CustomUserService userService;
	
	@GetMapping("/getUserDetailsByUserName/{userName}")
	public ResponseEntity<User> getUserDetails(@PathVariable("userName") String userName) {
		
		return ResponseEntity.ok(userService.findUserByUserName(userName));
	}
	
	@GetMapping("/getAdminAccess")
	public ResponseEntity<HttpStatus> getAdminAccess() {
		System.out.println("This is admin");
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
