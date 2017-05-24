package com.tim10.contollers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tim10.models.Oglas;
import com.tim10.repositories.OglasRepozitorij;

@RestController
@RequestMapping("oglasi")
public class OglasController extends BaseRestController<Oglas, OglasRepozitorij>{

	@RequestMapping("/byNazivOglasa/{nazivOglasa}")
	public List<Oglas> byNazivOglasa(@PathVariable String nazivOglasa)	{
		return repository.byNazivOglasa(nazivOglasa);
	}
}
