package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Famille implements Serializable{
	@Id @GeneratedValue()
	private Long id;
	@NotNull
	@Size(min=4)
	private String nom;
	@Size(min=4)
	private String desi;
	
	public Famille() {
		super();
	}

	public Famille(@NotNull @Size(min = 4) String nom, @Size(min = 4) String desi) {
		super();
		this.nom = nom;
		this.desi = desi;
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

	public String getDesi() {
		return desi;
	}

	public void setDesi(String desi) {
		this.desi = desi;
	}
	
	

}
