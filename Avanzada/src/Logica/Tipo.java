/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Facu
 */
public class Tipo {
    
    @GeneratedValue
    @Id
    private int ID;
    @Basic
    private String nombre;
    @ManyToOne
    private Habitacion unaHabitacion;
     

    public Tipo() {
    }

    public Tipo(int ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    
}
