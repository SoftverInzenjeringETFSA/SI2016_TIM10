package com.tim10.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tim10.models.Oglas;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OglasRepozitorij extends CrudRepository<Oglas, Long> {

    @Query("select o from Oglas o where korisnik_id=?")
    public List<Oglas> findAlloglasiByUserId( Long id);

    //pretraga po nazivu oglasa, da sadrzi podstring
    @Query("select o from Oglas o where naziv_oglasa like %:id% ")
    public List<Oglas> findAllByRentalName( @Param("id") String id);

    //koliko oglasa ima korisnik
    @Query("select count(*) from Oglas where korisnik_id=? ")
    public Integer CountUserRentals(Long id);

    @Modifying(clearAutomatically = true)
    @Query("delete from Oglas where korisnik_id=?")
    @Transactional
    public Integer deleteOglasibyUserId(Long id);

    //pretraga prioritetiziranje oglasa
    //pretraga po nazivu oglasa, da sadrzi podstring
    @Query("select o from Oglas o order by placen desc")
    public List<Oglas> sortbyPlacen();
}