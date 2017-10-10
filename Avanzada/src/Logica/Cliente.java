/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Facu
 */
public class Cliente {
    @GeneratedValue
    @Id
    private int DNI;
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Basic
    private Double tarjetaDeCredito;

    public Cliente() {
    }

    public Cliente(int DNI, String nombre, String apellido, Double tarjetaDeCredito) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Double getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTarjetaDeCredito(Double tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    
}
