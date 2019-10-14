package org.sid.entities;

import java.io.Serializable;

public class Login implements Serializable{
	
	private String login;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String login) {
		super();
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	

}
