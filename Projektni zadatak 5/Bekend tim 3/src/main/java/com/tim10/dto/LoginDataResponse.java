package com.tim10.dto;

import com.tim10.models.Korisnik;

/**
 * Created by Dragnic on 24.05.2017..
 */
public class LoginDataResponse {

    private Korisnik korisnik;

    private String errorMessage;

    private String token;

    public LoginDataResponse() {

    }

    public LoginDataResponse(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

    public LoginDataResponse(Korisnik korisnik, String token) {
        this.setKorisnik(korisnik);
        this.setToken(token);
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}