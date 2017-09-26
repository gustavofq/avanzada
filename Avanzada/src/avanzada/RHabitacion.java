/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzada;

import java.util.Calendar;

/**
 *
 * @author Facu
 */
public class RHabitacion extends Reservas{
    
    private int ID;
    private int numeroHab;
    private Calendar fechaEntrada;
    private Calendar fechaSalida;
    private int cantidad;
    private int numeroTarjeta;
    private Tipo unTipo;
    private Cliente unCliente;

    public RHabitacion() {
    }

    public RHabitacion(int ID, int numeroHab, Calendar fechaEntrada, Calendar fechaSalida, int cantidad, int numeroTarjeta, Tipo unTipo, Cliente unCliente) {
        this.ID = ID;
        this.numeroHab = numeroHab;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cantidad = cantidad;
        this.numeroTarjeta = numeroTarjeta;
        this.unTipo = unTipo;
        this.unCliente = unCliente;
    }

    public int getID() {
        return ID;
    }

    public int getNumeroHab() {
        return numeroHab;
    }

    public Calendar getFechaEntrada() {
        return fechaEntrada;
    }

    public Calendar getFechaSalida() {
        return fechaSalida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public Tipo getUnTipo() {
        return unTipo;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNumeroHab(int numeroHab) {
        this.numeroHab = numeroHab;
    }

    public void setFechaEntrada(Calendar fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(Calendar fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setUnTipo(Tipo unTipo) {
        this.unTipo = unTipo;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }
    
    
}
