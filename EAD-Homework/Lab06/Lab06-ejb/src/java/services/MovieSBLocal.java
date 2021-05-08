/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Movie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ThienKim
 */
@Local
public interface MovieSBLocal {
    List<Movie> findAll();
    Movie fineOne(int id);
    void save(Movie movie);
    boolean delete(int id);
    boolean update(Movie movie);
}
