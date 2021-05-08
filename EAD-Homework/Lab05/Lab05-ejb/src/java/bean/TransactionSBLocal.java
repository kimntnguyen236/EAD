/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.*;
import javax.ejb.Local;

/**
 *
 * @author ThienKim
 */
@Local
public interface TransactionSBLocal {
    AccountTB checkLogin(AccountTB accountTB);
    boolean tranfer(AccountTB accFrom, AccountTB accTo, int amount, String comment);
}
