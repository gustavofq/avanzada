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
public class DetalleFactura implements Serializable {
    
    @GeneratedValue
    @Id
    private int ID;
    @Basic
    private String descripcion;
    @Basic
    private int cantidad;
    @Basic
    private Double Subtotal;

    public DetalleFactura(int ID, String descripcion, int cantidad, Double Subtotal) {
        this.ID = ID;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.Subtotal = Subtotal;
    }

    public DetalleFactura() {
    }

    public int getID() {
        return ID;
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
    
    
    
    
}
