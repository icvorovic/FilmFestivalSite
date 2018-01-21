/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import filmfestival.Festival;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Igor
 */

@SessionScoped
@ManagedBean
public class FestivalSearchController {
    private Festival festivalSearch = new Festival();
    private List<Festival> searchResult = new ArrayList<>();
    private String datumOd = "";
    private String datumDo = "";
    private String naziv = "";
    
    public void searchFestival() {
        System.out.println("PRETRAGA FESTIVALA");
        
        for (int i = 0; i < 3; i++) {
            Festival f = new Festival();
            f.setNaziv(naziv);
            f.setMesta("BABKA, KGBABJA");
            
            searchResult.add(f);
        }
    }
    
    public Festival getFestivalSearch() {
        return festivalSearch;
    }

    public void setFestivalSearch(Festival festivalSearch) {
        this.festivalSearch = festivalSearch;
    }

    public List<Festival> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Festival> searchResult) {
        this.searchResult = searchResult;
    }

    public String getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(String datumOd) {
        this.datumOd = datumOd;
    }

    public String getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(String datumDo) {
        this.datumDo = datumDo;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    
}
