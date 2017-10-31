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
    private int id;
    @Basic
    private String Estado;

    public Mesa() {
    }

    public Mesa(int id, String Estado) {
        this.id = id;
        this.Estado = Estado;
    }

    public Mesa(String Estado){
        this.Estado = Estado;
    }
    
    public int getId() {
        return id;
    }

    public String getEstado() {
        return Estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    
    
    
    
}
