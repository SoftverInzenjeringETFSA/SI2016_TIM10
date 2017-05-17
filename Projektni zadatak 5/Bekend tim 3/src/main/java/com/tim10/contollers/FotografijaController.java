package com.tim10.contollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tim10.models.Fotografija;
import com.tim10.repositories.FotografijaRepozitorij;

@RestController
@RequestMapping("/fotografije")
public class FotografijaController 
	extends BaseRestController<Fotografija, FotografijaRepozitorij> {

}
