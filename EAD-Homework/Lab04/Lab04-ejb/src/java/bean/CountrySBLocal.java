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
public interface CountrySBLocal {
        List<CountryCity> findAll();
//        List<CountryCity> findByName(String cname);
        List<CountryTB> listCountry();
        void createCity(CityTB city);
        List<CityTB> listCityName();
        List<CountryCity> findByName(String name, String ctname);
}
