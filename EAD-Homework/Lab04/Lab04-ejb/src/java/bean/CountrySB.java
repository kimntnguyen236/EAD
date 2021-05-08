/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.*;
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
public class CountrySB implements CountrySBLocal {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public CountrySB() {
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
            Logger.getLogger(CountrySB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    @Override
    public List<CountryCity> findAll() {
        List<CountryCity> list = new ArrayList<CountryCity>();
        try {
            String sql = "SELECT * FROM CountryCity";
//            hoặc dùng view
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CountryCity c = new CountryCity();
                c.setCityid(rs.getInt("cityid"));
                c.setCityname(rs.getString("cityname"));
                c.setPopulation(rs.getInt("population"));
                c.setZipcode(rs.getInt("zipcode"));
                c.setCountryname(rs.getString("countryname"));
                c.setCountrycode(rs.getString("countrycode"));
                c.setLanguagecode(rs.getString("languagecode"));

                list.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CountrySB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<CountryTB> listCountry() {
        List<CountryTB> list = new ArrayList<CountryTB>();
        try {
            String sql = "SELECT * FROM CountryTB";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CountryTB c = new CountryTB();
                c.setCountryname(rs.getString("countryname"));
                c.setCountrycode(rs.getString("countrycode"));
                c.setLanguagecode(rs.getString("languagecode"));

                list.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CountrySB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void createCity(CityTB city) {
        try {
            String sql = "INSERT INTO CityTB VALUES (?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, city.getCityname());
            ps.setInt(2, city.getPopulation());
            ps.setInt(3, city.getZipcode());
            ps.setString(4, city.getCountryname());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CountrySB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Override
//    public List<CountryCity> findByName(String cname) {
//        List<CountryCity> list = new ArrayList<CountryCity>();
//        try {
//            String sql = "SELECT * FROM CountryCity WHERE countryname = ? ";
////            hoặc dùng view
//            ps = connection.prepareStatement(sql);
//            ps.setString(1, cname);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                CountryCity c = new CountryCity();
//                c.setCityid(rs.getInt("cityid"));
//                c.setCityname(rs.getString("cityname"));
//                c.setPopulation(rs.getInt("population"));
//                c.setZipcode(rs.getInt("zipcode"));
//                c.setCountryname(rs.getString("countryname"));
//                c.setCountrycode(rs.getString("countrycode"));
//                c.setLanguagecode(rs.getString("languagecode"));
//
//                list.add(c);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CountrySB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }

    @Override
    public List<CityTB> listCityName() {
        List<CityTB> list = new ArrayList<CityTB>();
        try {
            String sql = "SELECT * FROM CityTB";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CityTB c = new CityTB();
//                c.setCityid(rs.getInt("cityid"));
                c.setCityname(rs.getString("cityname"));
//                c.setPopulation(rs.getInt("population"));
//                c.setZipcode(rs.getInt("zipcode"));
//                c.setCountryname(rs.getString("countryname"));

                list.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CountrySB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<CountryCity> findByName(String name, String ctname) {
        List<CountryCity> list = new ArrayList<>();
        String sql = "SELECT * FROM CountryCity WHERE countryname=? AND cityname=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, ctname);
            rs = ps.executeQuery();
            while (rs.next()) {                
                CountryCity c = new CountryCity();
                c.setCityid(rs.getInt("cityid"));
                c.setCityname(rs.getString("cityname"));
                c.setPopulation(rs.getInt("population"));
                c.setZipcode(rs.getInt("zipcode"));
                c.setCountryname(rs.getString("countryname"));
                c.setCountrycode(rs.getString("countrycode"));
                c.setLanguagecode(rs.getString("languagecode"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CountrySB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
