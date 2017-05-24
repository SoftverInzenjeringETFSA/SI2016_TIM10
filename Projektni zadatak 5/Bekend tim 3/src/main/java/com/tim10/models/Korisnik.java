package com.tim10.models;

import javax.persistence.*;

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
	
	@Id
	@GeneratedValue
	private long id;

	private String ime;
	
	private String prezime;
	
	private String eMail;
	
	private String korisnickoIme;
	
	private String sifra;

	private boolean isVerified;

	@OneToOne(targetEntity = Role.class)
	@JoinColumn(name = "role_id")
	private Role roleId;

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = true;
	}
	public Korisnik ()	{}
	
	
}
