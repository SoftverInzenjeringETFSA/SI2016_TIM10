package com.tim10.contollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tim10.models.Oglas;
import com.tim10.repositories.OglasRepozitorij;

@RestController
@RequestMapping("/oglasi")
public class OglasController extends BaseRestController<Oglas, OglasRepozitorij>{

}
