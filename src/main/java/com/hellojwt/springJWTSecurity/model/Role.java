package com.hellojwt.springJWTSecurity.model;

public enum Role {

	USER("USER"), ADMIN("ADMIN");

	String name;

	private Role(String name) {
		this.name = name;
	}

}
