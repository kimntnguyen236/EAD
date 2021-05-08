/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Project;
import java.util.List;
import javax.ejb.Stateful;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThienKim
 */
@Stateful
public class ProjectSB implements ProjectSBLocal {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProjectSB() {
        setCon();
    }

    private Connection setCon() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Sem04Database";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjectSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    @Override
    public List<Project> findAll() {
        List<Project> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Project";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Project p = new Project();
//                p.setProjectcode(rs.getString("projectcode"));
//                p.setProjectname(rs.getString("projectname"));
//                p.setDuration(rs.getString("duration"));
//                p.setCost(rs.getInt("cost"));
                p.setProjectcode(rs.getString(1));
                p.setProjectname(rs.getString(2));
                p.setDuration(rs.getString(3));
                p.setCost(rs.getInt(4));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Project findOne(String code) {
        Project p = new Project();
        String query = "SELECT * FROM Project WHERE projectcode=?";
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
            ps.setString(1, code);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectSB.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return p;
        return null;
    }

    @Override
    public boolean deleteProject(String code) {
        String query = "DELETE FROM Project WHERE projectcode=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, code);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void updateProject(String code, int cost) {
        String query = "UPDATE Project SET cost=? WHERE projectcode=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, cost);
            ps.setString(2, code);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectSB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Project> searchByCost(int min, int max) {
        List<Project> list = new ArrayList<>();
        String query = "SELECT * FROM Project WHERE cost >= ? AND cost <= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, min);
            ps.setInt(2, max);
            rs = ps.executeQuery();
            while (rs.next()) {
                Project p = new Project();
//                p.setProjectcode(rs.getString("projectcode"));
//                p.setProjectname(rs.getString("projectname"));
//                p.setDuration(rs.getString("duration"));
//                p.setCost(rs.getInt("cost"));
                p.setProjectcode(rs.getString(1));
                p.setProjectname(rs.getString(2));
                p.setDuration(rs.getString(3));
                p.setCost(rs.getInt(4));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean save(Project p) {
        try {
            String sql = "INSERT INTO Project VALUES(?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getProjectcode());
            ps.setString(2, p.getProjectname());
            ps.setString(3, p.getDuration());
            ps.setInt(4, p.getCost());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Project> search(String pname) {
        List<Project> list = new ArrayList<>();
        String query = "SELECT * FROM Project WHERE projectname LIKE ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + pname + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Project p = new Project();
//                p.setProjectcode(rs.getString("projectcode"));
//                p.setProjectname(rs.getString("projectname"));
//                p.setDuration(rs.getString("duration"));
//                p.setCost(rs.getInt("cost"));
                p.setProjectcode(rs.getString(1));
                p.setProjectname(rs.getString(2));
                p.setDuration(rs.getString(3));
                p.setCost(rs.getInt(4));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean checkLogin(String code, String pname) {
        try { 
            String sql = "SELECT * FROM Project WHERE projectcode=? AND projectname=?";
            ps= connection.prepareStatement(sql);
            ps.setString(1, code);
            ps.setString(2, pname);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
