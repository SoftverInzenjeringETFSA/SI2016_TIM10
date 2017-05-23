package com.tim10.contollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tim10.models.Oglas;
import com.tim10.repositories.OglasRepozitorij;


import java.util.List;

@RestController
@RequestMapping("/oglasi")
public class OglasController extends BaseRestController<Oglas, OglasRepozitorij>{

        
}
