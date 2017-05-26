package com.tim10.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tim10.models.Oglas;
import com.tim10.repositories.OglasRepozitorij;


import java.util.List;

@RestController
@RequestMapping("/oglasi")
public class OglasController extends BaseRestController<Oglas, OglasRepozitorij>{
    @Autowired
    private OglasRepozitorij oglasRepozitorij;


    @CrossOrigin
    @GetMapping(path="/allOglasiKorisnik")
    public @ResponseBody List<Oglas> allUserDocs(@RequestParam("id") Long id) {
        return oglasRepozitorij.findAlloglasiByUserId(id);
    }

    @CrossOrigin
    @RequestMapping(path="/deleteOglasi", method = RequestMethod.POST)
    public @ResponseBody Integer deleteOglasi (@RequestParam("id") Long id) {
        if (id == null) return 0;
        return oglasRepozitorij.deleteOglasibyUserId(id);
    }
}
