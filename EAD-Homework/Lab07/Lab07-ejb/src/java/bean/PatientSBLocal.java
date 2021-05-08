/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Patient;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ThienKim
 */
@Local
public interface PatientSBLocal {
    List<Patient> findAll();
//    void addPatient(Patient patient);
    boolean addPatient(Patient patient);
    void deletePatient(int pid);
    Patient updatePatient(Patient patient);
    Patient findOne(int pid);
}
