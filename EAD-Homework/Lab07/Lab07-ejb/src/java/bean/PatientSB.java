/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import entities.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ThienKim
 */
@Stateless
public class PatientSB implements PatientSBLocal {

    @PersistenceContext(unitName = "Sem04")
    private EntityManager em;

    @Override
    public List<Patient> findAll() {
        return em.createNamedQuery("Patient.findAll", Patient.class).getResultList();
//        return em.createNamedQuery("SELECT p FROM Patient p", Patient.class).getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }

//    @Override
//    public void addPatient(Patient patient) {
//        persist(patient);
//    }
    @Override
    public void deletePatient(int pid) {
        try {
            em.getTransaction().begin();
            Patient patient = em.find(Patient.class, pid);
            if (patient != null) {
                em.remove(patient);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Patient updatePatient(Patient patient) {
        try {
            em.getTransaction().begin();
            em.merge(patient);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return patient;
    }

    @Override
    public Patient findOne(int pid) {
        return em.find(Patient.class, pid);
    }

    @Override
    public boolean addPatient(Patient patient) {
        String sql = "INSERT INTO Patient VALUES (?,?,?,?)";
        em.createNativeQuery(sql, Patient.class).setParameter("name", patient.getName())
                                        .setParameter("address", patient.getAddress())
                                        .setParameter("joindate", patient.getJoindate())
                                        .setParameter("status", patient.getStatus());

        return true;
    }

}
