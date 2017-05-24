package com.tim10.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Korisnik {
	
	
	public long getId() {
		return id;
	}

	public void setId(long idKorisnika) {
		this.id = idKorisnika;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Boolean getPravoObjave() {
		return pravoObjave;
	}

	public void setPravoObjave(Boolean pravoObjave) {
		this.pravoObjave = pravoObjave;
	}

	public Integer getBrojObjava() {
		return brojObjava;
	}

	public void setBrojObjava(Integer brojObjava) {
		this.brojObjava = brojObjava;
	}
	
	
	@Id
	@GeneratedValue
	private long id;

	private String ime;
	
	private String prezime;
	
	private String eMail;
	
	private String korisnickoIme;
	
	private String sifra;

	private Boolean admin;
	
	private Boolean pravoObjave;
	
	private Integer brojObjava;
	
	public Korisnik ()	{}
	
	
}
