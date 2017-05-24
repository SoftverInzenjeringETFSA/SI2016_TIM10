package com.tim10.repositories;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tim10.models.Oglas;

public interface OglasRepozitorij extends CrudRepository<Oglas, Long>{

	@Query("select o from Oglas o where o.nazivOglasa=:nazivOglasa")
	public List<Oglas> byNazivOglasa (@Param("nazivOglasa") String nazivOglasa);
	
	
	//@Query("select o from Oglas o where o.nazivOglasa=:nazivOglasa")
	//public List<Oglas> findByNazivOglasa(@Param("nazivOglasa") String nazivOglasa);
}
