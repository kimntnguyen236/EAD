/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.*;
import entities.VCompany;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author ThienKim
 */
@Stateless
public class CompanySB implements CompanySBLocal {

    @PersistenceContext(unitName = "Sem04")
    private EntityManager em;

    @Override
    public List<VCompany> findAll() {
        return em.createNamedQuery("VCompany.findAll", VCompany.class).getResultList();
    }

    @Override
    public StaffTB findOne(String staffid) {
        return em.createNamedQuery("StaffTB.findByStaffid", StaffTB.class)
                .setParameter("staffid", staffid)
                .getSingleResult();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public StaffTB checkLogin(String id, String password) {
        String query = "SELECT s FROM StaffTB s WHERE s.staffid = :staffid AND s.staffpassword = :staffpassword";
        StaffTB staff = (StaffTB) em.createQuery(query)
                .setParameter("staffid", id)
                .setParameter("staffpassword", password)
                .getSingleResult();
        if (staff == null) {
            return null;
        } else {
            return staff;
        }
    }
}
