package com.jobsearch.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// who are you and prove it
		auth.inMemoryAuthentication()
			.passwordEncoder(getPasswordEncoder())
			.withUser("jkoncura@gmail.com")
			.password(getPasswordEncoder().encode("password"))
			.roles("USER");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// what access should I give you
		http
			.authorizeRequests()
			.antMatchers("/").permitAll() //permit anyone to see the homepage (root url)
			.antMatchers("/login").permitAll()
			.anyRequest().hasRole("USER").and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/dashboard")
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/logout")
				.permitAll();
	}
}
