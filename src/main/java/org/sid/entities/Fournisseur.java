package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Fournisseur implements Serializable{
	@Id @GeneratedValue()
	private Long id;
	@NotEmpty
	@Size(min=4, max=80)
	private String nom;
	@Size(min=4, max=80)
	private String adr;
	private String pays;
	private String tel;
	@NotEmpty //(message = "{error.email.empty}")
    @Email //(message = "{error.email.format}")
	private String email;
	
	public Fournisseur() {
		super();
	}

	public Fournisseur(@NotEmpty @Size(min=4, max=80) String nom, @Size(min = 4, max = 80) String adr, String pays,
			String tel,
			@NotEmpty(message = "{error.email.empty}") @Email(message = "{error.email.format}") String email) {
		super();
		this.nom = nom;
		this.adr = adr;
		this.pays = pays;
		this.tel = tel;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
