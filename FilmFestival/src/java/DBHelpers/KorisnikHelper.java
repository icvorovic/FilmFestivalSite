/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHelpers;

import filmfestival.HibernateUtil;
import filmfestival.Korisnik;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Igor
 */
public class KorisnikHelper {
    Session session = null;
    
    public KorisnikHelper() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public Korisnik getKorisnikKorisnickoIme(String korisnickoIme) {
        List<Korisnik> korisnikList = null;

        final org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Query q = session.createQuery ("from Korisnik as korisnik where korisnik.korisnickoIme = '" + korisnickoIme + "'");
            korisnikList = (List<Korisnik>) q.list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        
        if (korisnikList == null) {
            return null;
        }
        
        return korisnikList.size() == 0 ? null : korisnikList.get(0);
    }

    public void registerNewKorisnik(Korisnik korisnik) {
        final org.hibernate.Transaction tx = session.beginTransaction();
        try {
            session.save(korisnik);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
    
    public Korisnik getKorisnik(String korisnickoIme, String lozinka) {
        List<Korisnik> korisnikList = null;

        final org.hibernate.Transaction tx = session.beginTransaction();

        try {
            Query q = session.createQuery ("from Korisnik as korisnik where korisnik.korisnickoIme = :korisnickoIme and korisnik.lozinka = :lozinka");
            
            q.setParameter("korisnickoIme", korisnickoIme);
            q.setParameter("lozinka", lozinka);
            
            korisnikList = (List<Korisnik>) q.list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        
        if (korisnikList == null) {
            return null;
        }
        
        return korisnikList.size() == 0 ? null : korisnikList.get(0);
    }
}
