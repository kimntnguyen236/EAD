/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.BankTransactions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author ThienKim
 */
@Stateless
public class BankSB implements BankSBLocal {

    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public BankSB() {
        setCon();
    }

    private Connection setCon() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Sem04DB";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BankSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    @Override
    public boolean checkLogin(String accountname, int pincode) {
        try {
            String sql = "SELECT * FROM BankAccount WHERE accountname=? AND pincode=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, accountname);
            pstmt.setInt(2, pincode);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BankSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<BankTransactions> findAllByAccountName(String accountname) {
        List<BankTransactions> list = new ArrayList<>();
        String query = "SELECT * FROM BankTransactions WHERE accountname=?";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, accountname);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BankTransactions t = new BankTransactions();
                t.setId(rs.getInt(1));
                t.setTransdate(rs.getDate(2));
                t.setWithdraw(rs.getInt(3));
                t.setDeposit(rs.getInt(4));
                t.setBalance(rs.getInt(5));
                t.setAccountname(rs.getString(6));

                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BankSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int findBalance(String accountname) {
        BankTransactions t = new BankTransactions();
        String query = "SELECT top 1 balance FROM BankTransactions WHERE accountname=? order by transdate desc";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, accountname);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                t.setBalance(rs.getInt("balance"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BankSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t.getBalance();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
