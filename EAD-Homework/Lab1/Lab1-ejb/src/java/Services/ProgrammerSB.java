/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javax.ejb.Stateless;
import Entities.Programmer;
import java.util.List;
import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThienKim
 */
@Stateless
public class ProgrammerSB implements ProgrammerSBLocal {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProgrammerSB() {
        setConn();
    }

    private Connection setConn() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Sem04DB";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProgrammerSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    @Override
    public List<Programmer> findAll() {
        List<Programmer> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Programmer";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Programmer p = new Programmer();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setSkill(rs.getString("skill"));
                p.setSalary(rs.getInt("salary"));

                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammerSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean saveProgrammer(Programmer p) {
        try {
            String sql = "INSERT INTO Programmer VALUES(?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getSkill());
            ps.setInt(3, p.getSalary());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProgrammerSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
