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
import javax.persistence.OneToOne;

/**
 *
 * @author Facu
 */
@Entity
public class Habitacion implements Serializable {
    
    @GeneratedValue
    @Id
    private int id;
    @Basic
    private boolean ocupado;
    @Basic
    private int montoPorNoche;
    @OneToOne
    private Tipo unTipo;

    public Habitacion() {
    }

    public Habitacion(int id, boolean estado, int montoPorNoche, Tipo unTipo) {
        this.id = id;
        this.ocupado = estado;
        this.montoPorNoche = montoPorNoche;
        this.unTipo = unTipo;
    }
    
    public Habitacion(boolean estado, int montoPorNoche, Tipo unTipo){
        this.ocupado = estado;
        this.montoPorNoche = montoPorNoche;
        this.unTipo = unTipo;
    }

    public int getId() {
        return id;
    }

    public boolean getEstado() {
        return ocupado;
    }

    public int getMontoPorNoche() {
        return montoPorNoche;
    }

    public Tipo getUnTipo() {
        return unTipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(boolean estado) {
        this.ocupado = estado;
    }

    public void setMontoPorNoche(int montoPorNoche) {
        this.montoPorNoche = montoPorNoche;
    }

    public void setUnTipo(Tipo unTipo) {
        this.unTipo = unTipo;
    }

    public String verificarEstado(){
        String estado;
        if(this.ocupado == true){
            estado = "Ocupado";
        }else if(this.ocupado == false){
            estado = "Disponible";
        }else{
            estado = "Indeterminado";
        } 
    return estado;    
    }

    @Override
    public String toString() {
        return Integer.toString(this.id);
    }
    
    
 
}
