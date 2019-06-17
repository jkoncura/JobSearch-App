package com.jobsearch.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

public class Settings {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean newNotification;
	
	@ManyToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isNewNotification() {
		return newNotification;
	}

	public void setNewNotification(boolean newNotification) {
		this.newNotification = newNotification;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
