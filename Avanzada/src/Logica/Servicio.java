/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Facu
 */
public class Servicio {
    
    @GeneratedValue
    @Id
    private int ID;
    @Basic
    private String nombre;
    @Basic
    private String descripcion;

    public Servicio() {
    }

    public Servicio(int ID, String nombre, String descripcion) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
