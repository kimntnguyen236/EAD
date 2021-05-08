/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ThienKim
 */
@Local
public interface BankSBLocal {
    boolean checkLogin(String accountname, int pincode);
    List<BankTransactions> findAllByAccountName(String accountname);
    int findBalance(String accountname);
}
