/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;

/**
 *
 * @author ThienKim
 */
@Singleton
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class VisitorCountSB {
private int counter;

    public VisitorCountSB() {
        counter++;
    }
    
    // Write có thay đổi giá trị
    @Lock(LockType.WRITE)
    @AccessTimeout(Long.MIN_VALUE)
    public int getCounter(){
        return counter++;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
