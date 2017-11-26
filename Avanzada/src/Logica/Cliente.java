/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Facu
 */
@Entity
public class Cliente implements Serializable {
    
    @Id
    private int dni;
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

    public Cliente(String nombre, int dni){
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public Cliente(int dni, String nombre, String apellido, Double tarjetaDeCredito, String usuario, String contraseña) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tarjetaDeCredito = tarjetaDeCredito;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getDni() {
        return dni;
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

    public void setDni(int dni) {
        this.dni = dni;
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
