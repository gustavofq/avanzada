/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Facu
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class RMesas extends Reservas implements Serializable{
    
    @Basic
    private int numeroMesa;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fecha;
    @OneToOne
    private Cliente unCliente;

    public RMesas() {
    }

    public RMesas(int numeroMesa, Calendar fecha, Cliente unCliente) {
        this.numeroMesa = numeroMesa;
        this.fecha = fecha;
        this.unCliente = unCliente;
    }

    public RMesas(int numeroMesa, Calendar fecha, Cliente unCliente, int id) {
        super(id);
        this.numeroMesa = numeroMesa;
        this.fecha = fecha;
        this.unCliente = unCliente;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }
    
    public int getID(){
        return super.getId();
    }
    
    
    
}
