package com.tim10.models;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Oglas {

	public long getId() {
		return id;
	}

	public void setId(long idOglasa) {
		this.id = idOglasa;
	}

	public String getNazivOglasa() {
		return nazivOglasa;
	}

	public void setNazivOglasa(String nazivOglasa) {
		this.nazivOglasa = nazivOglasa;
	}

	public String getVrstaOglasa() {
		return vrstaOglasa;
	}

	public void setVrstaOglasa(String vrstaOglasa) {
		this.vrstaOglasa = vrstaOglasa;
	}

	public String getVrstaNekrenine() {
		return vrstaNekrenine;
	}

	public void setVrstaNekrenine(String vrstaNekrenine) {
		this.vrstaNekrenine = vrstaNekrenine;
	}

	public Double getKvadratura() {
		return kvadratura;
	}

	public void setKvadratura(Double kvadratura) {
		this.kvadratura = kvadratura;
	}

	public Double getCijena() {
		return cijena;
	}

	public void setCijena(Double cijena) {
		this.cijena = cijena;
	}

	public Integer getBrojProstorija() {
		return brojProstorija;
	}

	public void setBrojProstorija(Integer brojProstorija) {
		this.brojProstorija = brojProstorija;
	}

	public Integer getBrojSpratova() {
		return brojSpratova;
	}

	public void setBrojSpratova(Integer brojSpratova) {
		this.brojSpratova = brojSpratova;
	}

	public Date getDatumObjave() {
		return datumObjave;
	}

	public void setDatumObjave(Date datumObjave) {
		this.datumObjave = datumObjave;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}

	public Integer getBrojPregleda() {
		return brojPregleda;
	}

	public void setBrojPregleda(Integer brojPregleda) {
		this.brojPregleda = brojPregleda;
	}

	public Boolean getPlacen() {
		return placen;
	}

	public void setPlacen(Boolean placen) {
		this.placen = placen;
	}

	
	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}


	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	@Id
	@GeneratedValue
	private long id;
	
	private String nazivOglasa;
	
	private String vrstaOglasa;
	
	private String vrstaNekrenine;
	
	@OneToOne
	private Korisnik korisnik;
	
	private Double kvadratura;
	
	private Double cijena;
	
	private Integer brojProstorija;
	
	private Integer brojSpratova;
	
	@Column(insertable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@Basic(optional = false)
	private Date datumObjave;
	
	private Boolean aktivan;
	
	private Integer brojPregleda;
	
	private Boolean placen;
	
	private String adresa;

	private String grad;

	private String slika;
	
	public Oglas ()	{}
	
}
