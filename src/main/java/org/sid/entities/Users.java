package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Users implements Serializable{
	@Id @GeneratedValue
	private Long id;
	@NotNull
	@Size(min=4,max=80)
	private String matr;
	@Size(min=4,max=80)
	private String nom;
	@Size(min=4,max=80)
	private String prenom;
	private String dateN;
	private String login;
	@Size(min=6)
	private String pass;
	
	public Users() {
		super();
	}

	public Users(@NotNull @Size(min = 4, max = 80) String matr, @Size(min = 4, max = 80) String nom,
			@Size(min = 4, max = 80) String prenom,  String dateN, String login, @Size(min=6) String pass) {
		super();
		this.matr = matr;
		this.nom = nom;
		this.prenom = prenom;
		this.dateN = dateN;
		this.login = login;
		this.pass = pass;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateN() {
		return dateN;
	}

	public void setDateN(String dateN) {
		this.dateN = dateN;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
