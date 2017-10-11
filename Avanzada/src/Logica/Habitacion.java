/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Facu
 */
@Entity
public class Habitacion {
    
    @GeneratedValue
    @Id
    private int ID;
    @Basic
    private String estado;
    @Basic
    private int montoPorNoche;
    @OneToOne
    private Tipo unTipo;

    public Habitacion() {
    }

    public Habitacion(int ID, String estado, int montoPorNoche, Tipo unTipo) {
        this.ID = ID;
        this.estado = estado;
        this.montoPorNoche = montoPorNoche;
        this.unTipo = unTipo;
    }

    public int getID() {
        return ID;
    }

    public String getEstado() {
        return estado;
    }

    public int getMontoPorNoche() {
        return montoPorNoche;
    }

    public Tipo getUnTipo() {
        return unTipo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMontoPorNoche(int montoPorNoche) {
        this.montoPorNoche = montoPorNoche;
    }

    public void setUnTipo(Tipo unTipo) {
        this.unTipo = unTipo;
    }
    
    
    
}
