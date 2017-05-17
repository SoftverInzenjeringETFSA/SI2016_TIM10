package com.tim10.contollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tim10.models.ZainteresovaniKorisnik;
import com.tim10.repositories.ZainteresovaniKorisnikRepozitorij;

@RestController
@RequestMapping("/zainteresovaniKorisnici")
public class ZainteresovaniKorisnikController extends
	BaseRestController<ZainteresovaniKorisnik, ZainteresovaniKorisnikRepozitorij>{

}
