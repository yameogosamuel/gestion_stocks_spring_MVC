package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Articles implements Serializable{
	@Id @GeneratedValue
	private Long id;
	@NotNull
	private String ref;
	@NotNull
	@Size(min=4,max=80)
	private String desi;
	private int qte;
	@DecimalMin("1")
	private int stock_min;
	private double prix_u;
	private double prix_t;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String art_fam;
	private String art_rang;
	private String art_four;
	private String art_usa;
	private String art_uni;
	
	
	public Articles() {
		super();
	}


	public Articles(String ref, String desi, int qte, int stock_min,
			double prix_u, double prix_t, Date date, String art_fam,
			String art_rang, String art_four, String art_usa, String art_uni) {
		super();
		this.ref = ref;
		this.desi = desi;
		this.qte = qte;
		this.stock_min = stock_min;
		this.prix_u = prix_u;
		this.prix_t =prix_t ;
		this.date = date;
		this.art_fam = art_fam;
		this.art_rang = art_rang;
		this.art_four = art_four;
		this.art_usa = art_usa;
		this.art_uni = art_uni;
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public String getDesi() {
		return desi;
	}


	public void setDesi(String desi) {
		this.desi = desi;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	public int getStock_min() {
		return stock_min;
	}


	public void setStock_min(int stock_min) {
		this.stock_min = stock_min;
	}


	public double getPrix_u() {
		return prix_u;
	}


	public void setPrix_u(double prix_u) {
		this.prix_u = prix_u;
	}


	public double getPrix_t() {
		return prix_t;
	}


	public void setPrix_t(double prix_t) {
		this.prix_t = prix_t;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getArt_fam() {
		return art_fam;
	}


	public void setArt_fam(String art_fam) {
		this.art_fam = art_fam;
	}


	public String getArt_rang() {
		return art_rang;
	}


	public void setArt_rang(String art_rang) {
		this.art_rang = art_rang;
	}


	public String getArt_four() {
		return art_four;
	}


	public void setArt_four(String art_four) {
		this.art_four = art_four;
	}


	public String getArt_usa() {
		return art_usa;
	}


	public void setArt_usa(String art_usa) {
		this.art_usa = art_usa;
	}


	public String getArt_uni() {
		return art_uni;
	}


	public void setArt_uni(String art_uni) {
		this.art_uni = art_uni;
	}

	
	
}
