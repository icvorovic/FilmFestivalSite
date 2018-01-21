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
import util.UtilClass;

/**
 *
 * @author Igor
 */
@SessionScoped
@ManagedBean
public class RegisterController {
    private Korisnik registerKorisnik = new Korisnik();
    private String potvrdaLozinke = "";
    private KorisnikHelper helper = new KorisnikHelper();
    private String poruka = "";
    
    public void registerUser() {
        poruka = "";
        
        if (helper.getKorisnikKorisnickoIme(registerKorisnik.getKorisnickoIme()) == null) {
            
            
            if (!UtilClass.validateEmail(registerKorisnik.getEmail())) {
                poruka = "GRESKA: Neispravan format mail adrese. ";
                return;
            }
            
            if (!UtilClass.validatePhone(registerKorisnik.getKontaktTelefon())) {
                poruka = "GRESKA: Neispravan format telefona. (0bb bbb bbbb ili obb bbb bbb) ";
                return;
            }
            
            if (!registerKorisnik.getLozinka().equals(potvrdaLozinke)) {
                poruka = "GRESKA: Potvrdjena lozinka nije ista kao prava lozinka. ";
                return;
            }
                        
            helper.registerNewKorisnik(registerKorisnik);
            
            poruka = "Uspesno ste se registrovali.";
            
        } else {
            poruka = "GRESKA: Uneto korisnicko ime vec postoji.";
        }
    }

    public Korisnik getRegisterKorisnik() {
        return registerKorisnik;
    }

    public void setRegisterKorisnik(Korisnik registerKorisnik) {
        this.registerKorisnik = registerKorisnik;
    }

    public String getPotvrdaLozinke() {
        return potvrdaLozinke;
    }

    public void setPotvrdaLozinke(String potvrdaLozinke) {
        this.potvrdaLozinke = potvrdaLozinke;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    
    
}
