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

    @Query("select count(*) from ZainteresovaniKorisnik zk where korisnik_id=? and oglas_id=?")
    public Integer Zainteresovan(Long idk, Long ido);

    @Modifying(clearAutomatically = true)
    @Query("delete from ZainteresovaniKorisnik where korisnik_id=? and oglas_id=?")
    @Transactional
    public Integer deleteZKbyUserIdandOglasID(Long idk, Long ido);
}
