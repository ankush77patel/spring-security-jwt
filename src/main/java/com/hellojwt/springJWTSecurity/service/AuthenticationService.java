package com.hellojwt.springJWTSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hellojwt.springJWTSecurity.model.AuthenticationResponse;
import com.hellojwt.springJWTSecurity.model.User;
import com.hellojwt.springJWTSecurity.repository.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	public AuthenticationResponse register(User request) {
		System.out.println(request.getRole());
		request.setPassword(encoder.encode(request.getPassword()));
		User user = userRepository.save(request);
		String token = jwtService.generateToken(user);
		System.out.println(user);
		return new AuthenticationResponse(token);
	}

	public AuthenticationResponse authentication(User user) {

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		User findByUserName = userRepository.findByUserName(user.getUsername()).orElseThrow();
		System.out.println(user.getRole()==findByUserName.getRole());
		String token = jwtService.generateToken(findByUserName);

		return new AuthenticationResponse(token);

	}

}
