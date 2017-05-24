package com.tim10.repositories;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.repository.query.Param;
=======
>>>>>>> d87d8f78b518ea25fcbed6fc5130a259e20b7aec
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tim10.models.Oglas;
import org.springframework.data.repository.query.Param;

import java.util.List;

<<<<<<< HEAD
	@Query("select o from Oglas o where o.nazivOglasa=:nazivOglasa")
	public List<Oglas> byNazivOglasa (@Param("nazivOglasa") String nazivOglasa);
	
	
	//@Query("select o from Oglas o where o.nazivOglasa=:nazivOglasa")
	//public List<Oglas> findByNazivOglasa(@Param("nazivOglasa") String nazivOglasa);
}
=======
public interface OglasRepozitorij extends CrudRepository<Oglas, Long> {

}
>>>>>>> d87d8f78b518ea25fcbed6fc5130a259e20b7aec
