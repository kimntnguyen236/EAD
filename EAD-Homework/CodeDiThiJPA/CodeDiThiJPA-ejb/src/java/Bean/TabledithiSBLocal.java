/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Models.Tabledithi;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author TâmHoàngMinh
 */
@Local
public interface TabledithiSBLocal {
    List<Tabledithi> findAll() ;
    Tabledithi findOne(String cid);
    boolean addTabledithi(Tabledithi t);
    void deleteTabledithi(Tabledithi t);
    void updateTabledithi(Tabledithi t) ;
    Tabledithi Login(String uid, String upass);
    List<Tabledithi> findByName(String uname);
    List<Tabledithi> SearchMinMax(int min, int max);
}
