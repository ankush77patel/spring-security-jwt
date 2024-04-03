package com.hellojwt.springJWTSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJwtSecurityApplication {

	public static void main(String[] args) {
		
		String a="aa";
		String b="aa";
		String c="";
		
		if(c!=null && (a==b) || b.equals(a))
			System.out.println("Tested === ");
		SpringApplication.run(SpringJwtSecurityApplication.class, args);
	}

}
