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
import javax.persistence.ManyToOne;

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
    @ManyToOne
    private Habitacion unaHabitacion;
     

    public Tipo() {
    }

    public Tipo(int id, String nombre, Habitacion unaHabitacion) {
        this.id = id;
        this.nombre = nombre;
        this.unaHabitacion = unaHabitacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Habitacion getUnaHabitacion() {
        return unaHabitacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnaHabitacion(Habitacion unaHabitacion) {
        this.unaHabitacion = unaHabitacion;
    }

    
   
    
}
