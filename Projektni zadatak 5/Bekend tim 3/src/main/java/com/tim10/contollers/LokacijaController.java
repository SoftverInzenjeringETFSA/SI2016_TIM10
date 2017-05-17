package com.tim10.contollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tim10.models.Lokacija;
import com.tim10.repositories.LokacijaRepozitorij;

@RestController
@RequestMapping("/lokacije")
public class LokacijaController extends BaseRestController<Lokacija, LokacijaRepozitorij>{

}
