/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Calendar;
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
public class RMesas extends Reservas{
    
    @GeneratedValue
    @Id
    private int ID;
    @Basic
    private int numeroMesa;
    @Basic
    private Calendar fecha;
    @OneToOne
    private Cliente unCliente;

    public RMesas() {
    }

    public RMesas(int ID, int numeroMesa, Calendar fecha, Cliente unCliente) {
        this.ID = ID;
        this.numeroMesa = numeroMesa;
        this.fecha = fecha;
        this.unCliente = unCliente;
    }

    public int getID() {
        return ID;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }
    
    
    
    
    
}
