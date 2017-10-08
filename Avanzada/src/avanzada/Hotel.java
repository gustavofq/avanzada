/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avanzada;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author maquinola
 */
public class Hotel {

    @OneToMany
    private List<Camarero> misCamareros = new LinkedList();
    @OneToMany
    private List<Cliente> misClientes = new LinkedList();
    @OneToMany
    private List<Departamento> misDepartamentos = new LinkedList();
    @OneToMany
    private List<Factura> misFacturas = new LinkedList();
    @OneToMany
    private List<Habitacion> misHabitaciones = new LinkedList();
    @OneToMany
    private List<Mesa> misMesas = new LinkedList();
    @OneToMany
    private List<Plato> misPlatos = new LinkedList();
    @OneToMany
    private List<Proveedor> misProveedores = new LinkedList();
    @OneToMany
    private List<RHabitacion> misRHabitaciones = new LinkedList();
    @OneToMany
    private List<RMesas> misRMesas = new LinkedList();
    @OneToMany
    private List<Recepcionista> misRecepcionistas = new LinkedList();
    @OneToMany
    private List<Servicio> misServicios = new LinkedList();
    @OneToMany
    private List<Tipo> misTipos = new LinkedList();

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        
        
    }
    
    public Hotel() {
    }
    
    

    public List<Camarero> getMisCamareros() {
        return misCamareros;
    }

    public List<Cliente> getMisClientes() {
        return misClientes;
    }

    public List<Departamento> getMisDepartamentos() {
        return misDepartamentos;
    }

    public List<Factura> getMisFacturas() {
        return misFacturas;
    }

    public List<Habitacion> getMisHabitaciones() {
        return misHabitaciones;
    }

    public List<Mesa> getMisMesas() {
        return misMesas;
    }

    public List<Plato> getMisPlatos() {
        return misPlatos;
    }

    public List<Proveedor> getMisProveedores() {
        return misProveedores;
    }

    public List<RHabitacion> getMisRHabitaciones() {
        return misRHabitaciones;
    }

    public List<RMesas> getMisRMesas() {
        return misRMesas;
    }

    public List<Recepcionista> getMisRecepcionistas() {
        return misRecepcionistas;
    }

    public List<Servicio> getMisServicios() {
        return misServicios;
    }

    public List<Tipo> getMisTipos() {
        return misTipos;
    }

    public void setMisCamareros(List<Camarero> misCamareros) {
        this.misCamareros = misCamareros;
    }

    public void setMisClientes(List<Cliente> misClientes) {
        this.misClientes = misClientes;
    }

    public void setMisDepartamentos(List<Departamento> misDepartamentos) {
        this.misDepartamentos = misDepartamentos;
    }

    public void setMisFacturas(List<Factura> misFacturas) {
        this.misFacturas = misFacturas;
    }

    public void setMisHabitaciones(List<Habitacion> misHabitaciones) {
        this.misHabitaciones = misHabitaciones;
    }

    public void setMisMesas(List<Mesa> misMesas) {
        this.misMesas = misMesas;
    }

    public void setMisPlatos(List<Plato> misPlatos) {
        this.misPlatos = misPlatos;
    }

    public void setMisProveedores(List<Proveedor> misProveedores) {
        this.misProveedores = misProveedores;
    }

    public void setMisRHabitaciones(List<RHabitacion> misRHabitaciones) {
        this.misRHabitaciones = misRHabitaciones;
    }

    public void setMisRMesas(List<RMesas> misRMesas) {
        this.misRMesas = misRMesas;
    }

    public void setMisRecepcionistas(List<Recepcionista> misRecepcionistas) {
        this.misRecepcionistas = misRecepcionistas;
    }

    public void setMisServicios(List<Servicio> misServicios) {
        this.misServicios = misServicios;
    }

    public void setMisTipos(List<Tipo> misTipos) {
        this.misTipos = misTipos;
    }

    
    
    
    
    
    
    
}
