/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHelpers;

import filmfestival.HibernateUtil;
import filmfestival.Festival;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Igor
 */
public class FestivalHelper {
    Session session = null;
    
    public FestivalHelper() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List<Festival> getListFestival(String nazivFestivala,
                                          String datumOd,
                                          String datumDo) {
        List<Festival> festivalList = null;

        final org.hibernate.Transaction tx = session.beginTransaction();

        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date datumPocetka = new Date();
            
            if (!datumOd.isEmpty()) {
                datumPocetka = (Date) format.parse(datumOd);
            }
            
            Date datumKraja = new Date();
            
            if (!datumDo.isEmpty()) {
                datumKraja = (Date) format.parse(datumDo);
            }
            
            festivalList = session.createCriteria(Festival.class)
                            .add(Restrictions.and(
                                Restrictions.or(
                                    Restrictions.eq("naziv", nazivFestivala),
                                    Restrictions.sqlRestriction("'' = '" + nazivFestivala + "'")
                                ),
                                Restrictions.or(
                                    Restrictions.ge("datumPocetka", datumPocetka),
                                    Restrictions.sqlRestriction("'' = '" + datumOd + "'")
                                ),
                                Restrictions.or(
                                    Restrictions.le("datumPocetka", datumKraja),
                                    Restrictions.sqlRestriction("'' = '" + datumDo + "'")
                                ),
                                Restrictions.gt("datumKraja", new Date())
                            ))                    
                            .list();     

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        
        return festivalList;
    }
}
