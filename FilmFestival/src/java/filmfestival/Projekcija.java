package filmfestival;
// Generated Jan 20, 2018 12:55:52 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Projekcija generated by hbm2java
 */
public class Projekcija  implements java.io.Serializable {


     private int idprojekcija;
     private Festival festival;
     private Film film;
     private String mesto;
     private String sala;
     private Date vreme;
     private Integer cenaUlaznice;
     private Set<Rezervacija> rezervacijas = new HashSet<Rezervacija>(0);

    public Projekcija() {
    }

	
    public Projekcija(int idprojekcija, Festival festival, Film film) {
        this.idprojekcija = idprojekcija;
        this.festival = festival;
        this.film = film;
    }
    public Projekcija(int idprojekcija, Festival festival, Film film, String mesto, String sala, Date vreme, Integer cenaUlaznice, Set<Rezervacija> rezervacijas) {
       this.idprojekcija = idprojekcija;
       this.festival = festival;
       this.film = film;
       this.mesto = mesto;
       this.sala = sala;
       this.vreme = vreme;
       this.cenaUlaznice = cenaUlaznice;
       this.rezervacijas = rezervacijas;
    }
   
    public int getIdprojekcija() {
        return this.idprojekcija;
    }
    
    public void setIdprojekcija(int idprojekcija) {
        this.idprojekcija = idprojekcija;
    }
    public Festival getFestival() {
        return this.festival;
    }
    
    public void setFestival(Festival festival) {
        this.festival = festival;
    }
    public Film getFilm() {
        return this.film;
    }
    
    public void setFilm(Film film) {
        this.film = film;
    }
    public String getMesto() {
        return this.mesto;
    }
    
    public void setMesto(String mesto) {
        this.mesto = mesto;
    }
    public String getSala() {
        return this.sala;
    }
    
    public void setSala(String sala) {
        this.sala = sala;
    }
    public Date getVreme() {
        return this.vreme;
    }
    
    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }
    public Integer getCenaUlaznice() {
        return this.cenaUlaznice;
    }
    
    public void setCenaUlaznice(Integer cenaUlaznice) {
        this.cenaUlaznice = cenaUlaznice;
    }
    public Set<Rezervacija> getRezervacijas() {
        return this.rezervacijas;
    }
    
    public void setRezervacijas(Set<Rezervacija> rezervacijas) {
        this.rezervacijas = rezervacijas;
    }




}


