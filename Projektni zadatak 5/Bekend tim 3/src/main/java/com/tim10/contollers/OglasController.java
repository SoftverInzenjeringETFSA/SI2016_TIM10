package com.tim10.contollers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> d87d8f78b518ea25fcbed6fc5130a259e20b7aec
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tim10.models.Oglas;
import com.tim10.repositories.OglasRepozitorij;


import java.util.List;

@RestController
@RequestMapping("oglasi")
public class OglasController extends BaseRestController<Oglas, OglasRepozitorij>{

<<<<<<< HEAD
	@RequestMapping("/byNazivOglasa/{nazivOglasa}")
	public List<Oglas> byNazivOglasa(@PathVariable String nazivOglasa)	{
		return repository.byNazivOglasa(nazivOglasa);
	}
=======
        
>>>>>>> d87d8f78b518ea25fcbed6fc5130a259e20b7aec
}
