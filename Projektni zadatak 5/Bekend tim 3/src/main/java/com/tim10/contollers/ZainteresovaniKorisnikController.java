package com.tim10.contollers;

import com.tim10.models.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tim10.models.ZainteresovaniKorisnik;
import com.tim10.repositories.ZainteresovaniKorisnikRepozitorij;

import java.util.List;

@RestController
@RequestMapping("/zainteresovaniKorisnici")
public class ZainteresovaniKorisnikController extends
	BaseRestController<ZainteresovaniKorisnik, ZainteresovaniKorisnikRepozitorij>{

	@Autowired
	private ZainteresovaniKorisnikRepozitorij zkRepozitorij;


	@CrossOrigin
	@GetMapping(path="/allZKOglas")
	public @ResponseBody
	List<ZainteresovaniKorisnik> allZKOglas(@RequestParam("id") Long id) {
		return zkRepozitorij.findAllKorisniciByOglasId(id);
	}

	@CrossOrigin
	@RequestMapping(path="/deleteZK", method = RequestMethod.POST)
	public @ResponseBody Integer deleteZK (@RequestParam("id") Long id) {
		if (id == null) return 0;
		return zkRepozitorij.deleteZKbyUserId(id);
	}

	@CrossOrigin
	@GetMapping(path="/zainteresovan")
	public @ResponseBody
	Integer allZKOglas(@RequestParam("idk") Long idk,@RequestParam("ido") Long ido) {
		return zkRepozitorij.Zainteresovan(idk, ido);
	}

	@CrossOrigin
	@RequestMapping(path="/deletezkk", method = RequestMethod.POST)
	public @ResponseBody Integer deleteZK (@RequestParam("idk") Long idk,@RequestParam("ido") Long ido) {
		if (idk == null || ido == null) return 0;
		return zkRepozitorij.deleteZKbyUserIdandOglasID(idk, ido);
	}
}
