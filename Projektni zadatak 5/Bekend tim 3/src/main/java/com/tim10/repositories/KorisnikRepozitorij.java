package com.tim10.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tim10.models.Korisnik;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface KorisnikRepozitorij extends CrudRepository<Korisnik, Long> {

    @Query("select k from Korisnik k where korisnicko_ime=? and sifra=?")
    public Korisnik findByUsernameAndPassword(String korisnickoIme, String sifra);


    @Modifying(clearAutomatically = true)
    @Query("UPDATE Korisnik k SET broj_objava = broj_objava +1 WHERE id=?")
    @Transactional
    public Integer UpdateBrojObjava(Long id);

    @Query("select brojObjava from Korisnik k where id=?")
    public int GetBrojObjava(Long id);
}
