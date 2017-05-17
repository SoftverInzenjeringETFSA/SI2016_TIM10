package com.tim10.contollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tim10.models.Korisnik;
import com.tim10.repositories.KorisnikRepozitorij;

@RestController
@RequestMapping("/korisnici")
public class KorisnikController extends BaseRestController<Korisnik, KorisnikRepozitorij>{

}
