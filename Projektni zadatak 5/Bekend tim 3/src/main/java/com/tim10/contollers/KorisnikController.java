package com.tim10.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tim10.models.Korisnik;
import com.tim10.repositories.KorisnikRepozitorij;

@RestController
@RequestMapping("/korisnici")
public class KorisnikController extends BaseRestController<Korisnik, KorisnikRepozitorij>{

    @Autowired
    private KorisnikRepozitorij korisnikRepozitorij;

    @CrossOrigin
    @RequestMapping(path="/update", method = RequestMethod.POST)
    public @ResponseBody Integer updateBrojObjava (@RequestParam("id") Long id) {
        if (id == null) return 0;
        return korisnikRepozitorij.UpdateBrojObjava(id);
    }

    @CrossOrigin
    @GetMapping(path="/brojObjava")
    public @ResponseBody int brojObjava(@RequestParam("id") Long id) {
        return korisnikRepozitorij.GetBrojObjava(id);
    }
}
