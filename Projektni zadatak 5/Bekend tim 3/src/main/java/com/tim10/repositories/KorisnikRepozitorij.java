package com.tim10.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tim10.models.Korisnik;

public interface KorisnikRepozitorij extends CrudRepository<Korisnik, Long> {

    @Query("select k from Korisnik k where korisnicko_ime=? and sifra=?")
    public Korisnik findByUsernameAndPassword(String korisnickoIme, String sifra);
}
