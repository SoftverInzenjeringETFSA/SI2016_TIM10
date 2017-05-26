package com.tim10.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tim10.models.Oglas;

import java.util.List;

public interface OglasRepozitorij extends CrudRepository<Oglas, Long> {

    @Query("select o from Oglas o where korisnik_id=?")
    public List<Oglas> findAlloglasiByUserId( Long id);
}