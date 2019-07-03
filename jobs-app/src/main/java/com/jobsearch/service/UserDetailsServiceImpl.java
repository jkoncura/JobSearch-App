package com.jobsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobsearch.domain.User;
import com.jobsearch.repository.CustomSecurityUser;
import com.jobsearch.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//access the database, see if there is a user with that name and check if passwords match.
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username and password invalid");
 		}
		return new CustomSecurityUser(user);
		
	}
}