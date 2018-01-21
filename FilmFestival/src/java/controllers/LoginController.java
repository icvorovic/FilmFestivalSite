/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DBHelpers.KorisnikHelper;
import filmfestival.Korisnik;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Igor
 */
@SessionScoped
@ManagedBean
public class LoginController {
    private Korisnik ulogovanKorisnik = new Korisnik();
    private Korisnik loginKorisnik = new Korisnik();
    private KorisnikHelper helper = new KorisnikHelper();
    private String poruka = "";
    
    public String loginUser() {
        ulogovanKorisnik = helper.getKorisnik(loginKorisnik.getKorisnickoIme(),
                                              loginKorisnik.getLozinka());
        
        System.out.println("ULOGUJEM SE");
        
        poruka = "";
        
        if (ulogovanKorisnik == null) {
            poruka = "GRESKA: Neispravni kredencijali!";
            return null;
        }
        
        return "home";
    }

    public Korisnik getLoginKorisnik() {
        return loginKorisnik;
    }

    public void setLoginKorisnik(Korisnik loginKorisnik) {
        this.loginKorisnik = loginKorisnik;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Korisnik getUlogovanKorisnik() {
        return ulogovanKorisnik;
    }

    public void setUlogovanKorisnik(Korisnik ulogovanKorisnik) {
        this.ulogovanKorisnik = ulogovanKorisnik;
    }
    
}
