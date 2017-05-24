package com.tim10.contollers;

import com.tim10.dto.LoginDataRequest;
import com.tim10.dto.LoginDataResponse;
import com.tim10.models.Korisnik;
import com.tim10.models.Role;
import com.tim10.services.AuthService;
import com.tim10.services.JwtService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by Dragnic on 24.05.2017..
 */
@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService _authService;

    @RequestMapping(path="", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<LoginDataResponse> login(@RequestBody LoginDataRequest request) {
        try {
            Korisnik user = _authService.checkLoginData(request.getEmail(), request.getPassword());

            if (user != null) {

                user.setSifra(null);
                Long id=(long) 1;
                Role role= new Role(id,"Administator");
                String token=null;
                if(user.getRoleId()==role){
                    token= JwtService.issueToken(true,true);
                }
                else {token = JwtService.issueToken(true,true);}


                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(new LoginDataResponse(user, token));
            }
            else {
                throw new ServiceException("");
            }

        }
        catch (ServiceException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new LoginDataResponse("Incorrect username or password."));
        }
    }

}
