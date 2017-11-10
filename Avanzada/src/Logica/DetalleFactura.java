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
public class DetalleFactura implements Serializable {
    
    @GeneratedValue
    @Id
    private int id;
    @Basic
    private String descripcion;
    @Basic
    private int cantidad;
    @Basic
    private Double Subtotal;
    @OneToOne
    private Habitacion unaHabitacion;
    
    
    public DetalleFactura() {
    }

    public DetalleFactura(int id, String descripcion, int cantidad, Double Subtotal, Habitacion unaHabitacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.Subtotal = Subtotal;
        this.unaHabitacion = unaHabitacion;
    }

    public DetalleFactura(String descripcion, int cantidad, Double Subtotal, Habitacion unaHabitacion) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.Subtotal = Subtotal;
        this.unaHabitacion = unaHabitacion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Double getSubtotal() {
        return Subtotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(Double Subtotal) {
        this.Subtotal = Subtotal;
    }

    public Habitacion getUnaHabitacion() {
        return unaHabitacion;
    }

    public void setUnaHabitacion(Habitacion unaHabitacion) {
        this.unaHabitacion = unaHabitacion;
    }

    
    
    
}
