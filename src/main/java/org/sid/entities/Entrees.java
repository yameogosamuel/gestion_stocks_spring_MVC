package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Entrees implements Serializable{
	
		@Id @GeneratedValue
		private Long id;
		@NotNull
		private String ref;
		@NotNull
		@Size(min=4,max=80)
		private String desi;
		private double prix;
		private int qte;
		@Temporal(TemporalType.DATE)
		private Date date;
		private String condi;
		private String nomFour;

		public Entrees() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Entrees(String ref, String desi, double prix, int qte, Date date, String condi, String nomFour) {
			super();
			this.ref = ref;
			this.desi = desi;
			this.prix = prix;
			this.qte = qte;
			this.date = date;
			this.condi = condi;
			this.nomFour = nomFour;
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

		public double getPrix() {
			return prix;
		}

		public void setPrix(double prix) {
			this.prix = prix;
		}

		public int getQte() {
			return qte;
		}

		public void setQte(int qte) {
			this.qte = qte;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getCondi() {
			return condi;
		}

		public void setCondi(String condi) {
			this.condi = condi;
		}

		public String getNomFour() {
			return nomFour;
		}

		public void setNomFour(String nomFour) {
			this.nomFour = nomFour;
		}
		
		
   }
