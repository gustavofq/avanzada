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
public class Tipo implements Serializable {
    
    @GeneratedValue
    @Id
    private int id;
    @Basic
    private String nombre;
     

    public Tipo() {
    }


    public Tipo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Tipo(String nombre){
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    } 
}
