package com.tim10.services;

import com.tim10.models.Korisnik;
import com.tim10.repositories.KorisnikRepozitorij;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dragnic on 24.05.2017..
 */
@Service
public class AuthService {
    @Autowired
    private KorisnikRepozitorij userRepository;

    public Korisnik checkLoginData(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }


}