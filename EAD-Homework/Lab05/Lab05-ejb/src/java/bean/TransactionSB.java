/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.AccountTB;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author ThienKim
 */
@Stateful
@TransactionManagement(TransactionManagementType.BEAN)
public class TransactionSB implements TransactionSBLocal {

    @Resource
    UserTransaction ut;

    private Connection connection;
    private PreparedStatement psFrom,psTo,psSave;
    private ResultSet rs;

    public TransactionSB() {
        setCon();
    }

    private Connection setCon() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Sem4DB";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TransactionSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    @Override
    public AccountTB checkLogin(AccountTB accountTB) {
        try {
            String sql = "SELECT * FROM AccountTB WHERE accountno=? AND pincode=?";
            psFrom = connection.prepareStatement(sql);
            psFrom.setString(1, accountTB.getAccountno());
            psFrom.setString(2, accountTB.getPincode());
            rs = psFrom.executeQuery();
            if (rs.next()) {
                return accountTB;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountTB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accountTB;
    }

    @Override
    public boolean tranfer(AccountTB accFrom, AccountTB accTo, int amount, String comment) {
        String sqlFROM = "UPDATE AccountTB SET balance -= ? WHERE accountno = ?";
        String sqlTO = "UPDATE AccountTB SET balance += ? WHERE accountno = ?";
        String sqlSave = "INSERT INTO SaveTransactionTB VALUES (?,?,?,?)";

        try {
            psFrom = connection.prepareStatement(sqlFROM);
            psTo = connection.prepareStatement(sqlTO);
            psSave = connection.prepareStatement(sqlSave);
            // bắt đầu giao tác dòng 28
            ut.begin();
            // cập nhật from (commit)
            psFrom.setInt(1, amount);
            psFrom.setString(2, accFrom.getAccountno());
            psFrom.executeUpdate();
            ut.commit();
            
            ut.begin();
            // cập nhật to (commit)
            psTo.setInt(1, amount);
            psTo.setString(2, accTo.getAccountno());
            psTo.executeUpdate();
            ut.commit();
            
            ut.begin();
            // cập nhật số dư (commit)
            psSave.setString(1, LocalDate.now().toString());
            psSave.setInt(2, amount);
            psSave.setString(3, comment);
            psSave.setString(4, accFrom.getAccountno());
            psSave.executeUpdate();
            ut.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException | SQLException ex) {
            Logger.getLogger(TransactionSB.class.getName()).log(Level.SEVERE, null, ex);
            try {
                ut.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                Logger.getLogger(TransactionSB.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
