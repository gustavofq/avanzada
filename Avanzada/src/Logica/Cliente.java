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
    
    @Id
    private int DNI;
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Basic
    private Double tarjetaDeCredito;
    @Basic
    private String usuario;
    @Basic
    private String contraseña;

    public Cliente() {
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

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
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

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

   

    
}
