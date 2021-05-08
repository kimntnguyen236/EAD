/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Movie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ThienKim
 */
@Stateless
public class MovieSB implements MovieSBLocal {

    @PersistenceContext(unitName = "Sem04")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<Movie> findAll() {
        return em.createNamedQuery("Movie.findAll").getResultList();
    }

    @Override
    public Movie fineOne(int id) {
        return (Movie) em.createNamedQuery("Movie.findByMovieid")
                .setParameter("movieid", id)
                .getResultList();
    }

    @Override
    public void save(Movie movie) {
        em.persist(movie);
    }

    @Override
    public boolean delete(int id) {
        Movie movie = em.find(Movie.class, id);
        em.remove(movie);
        return true;
    }

    @Override
    public boolean update(Movie movie) {
        em.merge(movie);
        return true;
    }
}
