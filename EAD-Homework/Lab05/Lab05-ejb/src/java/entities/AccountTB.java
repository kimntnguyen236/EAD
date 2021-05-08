/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author ThienKim
 */
public class AccountTB implements Serializable{
    private String accountno;
    private String accountname;
    private String pincode;
    private int balance;

    public AccountTB(String accountno, String accountname, String pincode, int balance) {
        this.accountno = accountno;
        this.accountname = accountname;
        this.pincode = pincode;
        this.balance = balance;
    }

    public AccountTB() {
    }
    

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    
}
