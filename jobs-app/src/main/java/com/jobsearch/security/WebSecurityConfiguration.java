package com.jobsearch.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// who are you and prove it
		auth.inMemoryAuthentication()
			.withUser("jkoncura@gmail.com")
			.password("password")
			.roles("USER");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// what access should I give you
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll() //permit anyone to see the homepage (root url)
			.antMatchers("/login").permitAll()
			.anyRequest().hasRole("USER").and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/logout")
				.permitAll();
	}
}
