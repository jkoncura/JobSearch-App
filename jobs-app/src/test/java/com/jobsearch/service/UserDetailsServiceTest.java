package com.jobsearch.service;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceTest {
	
	@Test
	public void generateEncryptedPassword() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "password";
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println("encoded password: " + encodedPassword);
		
		assertThat(rawPassword, not(encodedPassword));
	}

}
