/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Models.Tabledithi;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author TâmHoàngMinh
 */
@Stateless
public class TabledithiSB implements TabledithiSBLocal {

    @PersistenceContext(unitName = "JDBCPool")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    //In list index
    @Override
    public List<Tabledithi> findAll() {
        List<Tabledithi> list = new ArrayList<>();
        String query = "SELECT t FROM Tabledithi t";
        Query q = em.createQuery(query);
        list = q.getResultList();
        return list; // trả về nhiều một tập tất cả collection
        // trả về một đối tượng : getSingleResult
        // mọi phương thức đều phải return trừ void
        // return em.createQuery("SELECT c FROM Course c").getResultList();
    }

    //Search theo id (id > String)
    @Override
    public Tabledithi findOne(String cid) {
        return em.find(Tabledithi.class, cid);
    }

    //Insert dữ liệu
    @Override
    public boolean addTabledithi(Tabledithi t) {
        boolean check = true;
        try {
            em.persist(t);
        } catch (Exception e) {
            check = false;
        }
        return check;
    }

    //Xóa dữ liệu
    @Override
    public void deleteTabledithi(Tabledithi t) {

        em.remove(em.merge(t));
    }

    //Update
    @Override
    public void updateTabledithi(Tabledithi t) {
        em.merge(t);
    }

    
    //CHưa chạy đk Login
    
    @Override
    public Tabledithi Login(String uid, String upass) {
        String query = "SELECT a FROM Tabledithi a WHERE a.tablecollum1 = :tablecollum1 AND a.tablecollum2 = :tablecollum2";
      
            List<Tabledithi> list = em.createQuery(query)
                    .setParameter("tablecollum1", uid)
                    .setParameter("tablecollum2", upass)
                    .getResultList();
            if (list.size() == 1) {
                return list.get(0);
            } else {
                return null;
            }
        
    }

    //Search theo ten
    @Override
    public List<Tabledithi> findByName(String uname) {
        //        String query = "SELECT u FROM Users u WHERE u.fullname = :fullname";
        String query = "SELECT u FROM Tabledithi u WHERE u.tablecollum3 LIKE :tablecollum3";
        return em.createQuery(query)
                //                .setParameter("fullname", uname)
                .setParameter("tablecollum3", "%" + uname + "%")
                .getResultList();
    }

    
    //Search min max
    @Override
    public List<Tabledithi> SearchMinMax(int min, int max) {
        String query = "SELECT u FROM Tabledithi u WHERE u.tablecollum5 >= :min AND u.tablecollum5 <= :max";
        List<Tabledithi> list123 = em.createQuery(query).setParameter("min", min).setParameter("max", max).getResultList();
        if (list123.size() > 0) {
            return list123;
        } else {
            return null;
        }
    }

}
