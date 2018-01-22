/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DBHelpers.FestivalHelper;
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
    private FestivalHelper helper = new FestivalHelper();
    private String datumOd = "";
    private String datumDo = "";
    private String naziv = "";
    
    public void searchFestival() {
        searchResult = helper.getListFestival(naziv, datumOd, datumDo);
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
