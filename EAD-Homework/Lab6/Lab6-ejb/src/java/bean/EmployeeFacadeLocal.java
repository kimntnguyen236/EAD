/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Employee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author WhiteMouse
 */
@Local
public interface EmployeeFacadeLocal {
    boolean checkLogin(int id, String pass);
    List<Employee> findSalary(int min, int max);
    //-----------------------------

    void create(Employee employee);

    void edit(Employee employee);

    void remove(Employee employee);

    Employee find(Object id);

    List<Employee> findAll();

    List<Employee> findRange(int[] range);

    int count();
    
}
