/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Project;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ThienKim
 */
@Local
public interface ProjectSBLocal {
    List<Project> findAll();
    Project findOne(String code);
    boolean deleteProject(String code);
    void updateProject(String code, int cost);
    List<Project> searchByCost(int min, int max);
    boolean save(Project p);
    List<Project> search(String pname);
    boolean checkLogin(String code, String pname);
}
