/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Programmer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ThienKim
 */
@Local
public interface ProgrammerSBLocal {
    // hiển thị tất cả
    List<Programmer> findAll();
    // create
    boolean saveProgrammer(Programmer p);
    // edit
    // searchByName
    // delete
}
