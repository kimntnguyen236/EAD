/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Camera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ThienKim
 */
@Local
public interface CameraSBLocal {
    List<Camera> findAll();
    boolean deleteCamera(String cid);
    List<Camera> searchByPrice(float min, float max);
    boolean createCamera(Camera c);
    Camera findOne(String cid);
}
