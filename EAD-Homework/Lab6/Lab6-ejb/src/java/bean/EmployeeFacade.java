/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author WhiteMouse
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {

    @PersistenceContext(unitName = "Lab6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    @Override
    public boolean checkLogin(int id, String pass) {
        String sql="SELECT * FROM Employee WHERE id=? AND password=?";
       Employee employee = (Employee) em.createNativeQuery(sql)
               .setParameter(1,id)
               .setParameter(2, pass).getSingleResult();
        if (employee!=null) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Employee> findSalary(int min, int max) {
         String sql="SELECT e FROM Employee e WHERE e.salary Between : min AND : max ";
        List<Employee> list = em.createQuery(sql)
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
        return list;
    }
    
}
