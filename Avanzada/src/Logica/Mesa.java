/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Facu
 */
@Entity
public class Mesa implements Serializable {
    
    @GeneratedValue
    @Id
    private int ID;
    @Basic
    private String Estado;

    public Mesa() {
    }

    public Mesa(int ID, String Estado) {
        this.ID = ID;
        this.Estado = Estado;
    }

    public int getID() {
        return ID;
    }

    public String getEstado() {
        return Estado;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
