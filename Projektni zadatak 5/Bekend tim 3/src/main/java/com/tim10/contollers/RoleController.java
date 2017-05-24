package com.tim10.contollers;

import com.tim10.models.Role;
import com.tim10.repositories.RoleRepozitorij;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by Dragnic on 24.05.2017..
 */
@RestController
@RequestMapping("/roles")
public class RoleController  extends BaseRestController<Role, RoleRepozitorij>{

    @Autowired
    private RoleRepozitorij roleRepository;


    @CrossOrigin
    @GetMapping(path="/get")
    public @ResponseBody Role getById(@RequestParam("id") Long id) {
        return roleRepository.findById(id);
    }
}