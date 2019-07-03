package com.jobsearch.domain;

import java.io.Serializable;

import javax.crypto.Mac;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_SESSION")
public class UserSession implements Serializable  {
	
	private static final long serialVersionUID = -2296958178988905642L;

	@Id
	private Long id;
	
	@ManyToOne
	private Machine machine;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	
}
