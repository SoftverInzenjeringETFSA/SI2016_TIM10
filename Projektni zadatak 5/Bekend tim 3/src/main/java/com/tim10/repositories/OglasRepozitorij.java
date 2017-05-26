package com.tim10.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tim10.models.Oglas;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OglasRepozitorij extends CrudRepository<Oglas, Long> {

    @Query("select o from Oglas o where korisnik_id=?")
    public List<Oglas> findAlloglasiByUserId( Long id);

    @Modifying(clearAutomatically = true)
    @Query("delete from Oglas where korisnik_id=?")
    @Transactional
    public Integer deleteOglasibyUserId(Long id);
}