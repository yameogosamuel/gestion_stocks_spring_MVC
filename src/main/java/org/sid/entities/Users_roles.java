package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Users_roles implements Serializable{
	
	@Id @GeneratedValue
	private Long id;
	@NotNull
	private String login;
	private String role;
	
	public Users_roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users_roles(@NotNull String login, String role) {
		super();
		this.login = login;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
