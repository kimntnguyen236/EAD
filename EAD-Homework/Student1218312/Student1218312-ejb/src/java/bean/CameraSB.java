/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Camera;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;

/**
 *
 * @author ThienKim
 */
@Stateful
public class CameraSB implements CameraSBLocal {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public CameraSB() {
        setCon();
    }

    private Connection setCon() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=StoreDB";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CameraSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    @Override
    public List<Camera> findAll() {
        List<Camera> list = new ArrayList<>();
        String query = "SELECT * FROM Camera";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Camera c = new Camera();
                c.setCameraid(rs.getString(1));
                c.setCameraname(rs.getString(2));
                c.setCameraprice(rs.getFloat(3));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CameraSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean deleteCamera(String cid) {
        String query = "DELETE FROM Camera WHERE cameraid=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cid);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CameraSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Camera> searchByPrice(float min, float max) {
        List<Camera> list = new ArrayList<>();
        String query = "SELECT * FROM Camera WHERE cameraprice >= ? AND cameraprice <= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setFloat(1, min);
            ps.setFloat(2, max);
            rs = ps.executeQuery();
            while (rs.next()) {
                Camera c = new Camera();
//                p.setProjectcode(rs.getString("projectcode"));
//                p.setProjectname(rs.getString("projectname"));
//                p.setDuration(rs.getString("duration"));
//                p.setCost(rs.getInt("cost"));
                c.setCameraid(rs.getString(1));
                c.setCameraname(rs.getString(2));
                c.setCameraprice(rs.getFloat(3));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CameraSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean createCamera(Camera c) {
        try {
            String sql = "INSERT INTO Camera VALUES(?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, c.getCameraid());
            ps.setString(2, c.getCameraname());
            ps.setDouble(3, c.getCameraprice());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Camera.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Camera findOne(String cid) {
        Camera p = new Camera();
        String query = "SELECT * FROM Camera WHERE cameraid=?";
        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, code);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                p.setProjectcode(rs.getString("projectcode"));
//                p.setProjectname(rs.getString("projectname"));
//                p.setDuration(rs.getString("duration"));
//                p.setCost(Integer.parseInt(rs.getString("cost")));
//            }
            ps = connection.prepareStatement(query);
            ps.setString(1, cid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CameraSB.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return p;
        return null;
    }
}
