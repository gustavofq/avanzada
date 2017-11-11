/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Facu
 */
@Entity
public class Factura implements Serializable {
    
    @GeneratedValue
    @Id
    private int id;
    @Basic
    private String Tipo;
    @Basic
    private Double total;
    @OneToOne
    private Cliente unCliente;
    @OneToMany
    private List<DetalleFactura> unosDetalles;

    public Factura() {
    }

    public Factura(int id, String Tipo, Double total, Cliente unCliente, List<DetalleFactura> unosDetalles) {
        this.id = id;
        this.Tipo = Tipo;
        this.total = total;
        this.unCliente = unCliente;
        this.unosDetalles = unosDetalles;
    }

    public Factura(String Tipo, Double total, Cliente unCliente) {
        this.Tipo = Tipo;
        this.total = total;
        this.unCliente = unCliente;
    }  
    
    public int getId() {
        return id;
    }

    public String getTipo() {
        return Tipo;
    }

    public Double getTotal() {
        return total;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public List<DetalleFactura> getUnosDetalles() {
        return unosDetalles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public void setUnosDetalles(List<DetalleFactura> unosDetalles) {
        this.unosDetalles = unosDetalles;
    }

    public void agregarDetalleFactura(String descripcion, int cantidad, Double Subtotal, Habitacion unaHabitacion){
        DetalleFactura unDetalleFactura = new DetalleFactura(descripcion, cantidad, Subtotal, unaHabitacion);
        unosDetalles.add(unDetalleFactura);
    }
    
}
