package com.tim10.repositories;

import com.tim10.models.Korisnik;
import com.tim10.models.Oglas;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tim10.models.ZainteresovaniKorisnik;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ZainteresovaniKorisnikRepozitorij extends CrudRepository<ZainteresovaniKorisnik, Long>{

    @Query("select zk from ZainteresovaniKorisnik zk where oglas_id=?")
    public List<ZainteresovaniKorisnik> findAllKorisniciByOglasId(Long id);

    @Modifying(clearAutomatically = true)
    @Query("delete from ZainteresovaniKorisnik where korisnik_id=?")
    @Transactional
    public Integer deleteZKbyUserId(Long id);
}
