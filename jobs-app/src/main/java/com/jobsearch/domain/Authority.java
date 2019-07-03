package com.jobsearch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "AUTHORITY")
public class Authority implements GrantedAuthority {
	
	private static final long serialVersionUID = 7982809603640977204L;
	
	private String authority;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User user;

	@Override
	public String getAuthority() {
		return this.authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
