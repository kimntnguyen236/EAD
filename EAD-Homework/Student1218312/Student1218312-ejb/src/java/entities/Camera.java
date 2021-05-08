/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ThienKim
 */
public class Camera implements Serializable {

    @NotNull
    private String cameraid;
    
    @NotNull
    private String cameraname;
    
    @Min(1)
    private double cameraprice;

    public Camera() {
    }

    public String getCameraid() {
        return cameraid;
    }

    public void setCameraid(String cameraid) {
        this.cameraid = cameraid;
    }

    public String getCameraname() {
        return cameraname;
    }

    public void setCameraname(String cameraname) {
        this.cameraname = cameraname;
    }

    public double getCameraprice() {
        return cameraprice;
    }

    public void setCameraprice(double cameraprice) {
        this.cameraprice = cameraprice;
    }

    
}
