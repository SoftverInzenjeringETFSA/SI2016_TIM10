package com.tim10.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ZainteresovaniKorisnik {

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Oglas getOglas() {
		return oglas;
	}

	public void setOglas(Oglas oglas) {
		this.oglas = oglas;
	}

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Korisnik korisnik;
	
	@ManyToOne
	private Oglas oglas;
	
	public ZainteresovaniKorisnik ()	{}
}
