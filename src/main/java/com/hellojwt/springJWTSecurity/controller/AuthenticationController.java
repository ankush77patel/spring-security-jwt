package com.hellojwt.springJWTSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hellojwt.springJWTSecurity.model.AuthenticationResponse;
import com.hellojwt.springJWTSecurity.model.User;
import com.hellojwt.springJWTSecurity.service.AuthenticationService;

@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody User user) {
		return ResponseEntity.ok(authenticationService.register(user));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody User user) {
		return ResponseEntity.ok(authenticationService.authentication(user));
	}

}
