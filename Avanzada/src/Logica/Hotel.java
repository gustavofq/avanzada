/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.OneToMany;
import jdk.nashorn.internal.runtime.Undefined;

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

    
    ControladoraPersistencia miPersistencia = new ControladoraPersistencia();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        
        
    }
    
    public Hotel() {
        CargarListas();
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

    
    
    ///////////// METODOS ABML: ///////////////////
    
    //CAMARERO
    
    public void altaCamarero(int dni, String nombre, String apellido) throws Exception {
        if (comprobarCamarero(dni) == false) {
            Camarero unCamarero = new Camarero(dni, nombre, apellido);
            misCamareros.add(unCamarero);
            miPersistencia.AltaCamarero(unCamarero);
        }
    }
    
    public Camarero DameElCamarero(int ID) {
        return this.miPersistencia.dameUnCamarero(ID);
    }

    public boolean comprobarCamarero(int dni) {
        boolean aux = false;
        
        for(Camarero unCamarero : misCamareros){
            if(unCamarero.getDni() == dni){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarCamarero(int dni, String nombre, String apellido, Camarero unCamarero) throws Exception {
        misCamareros.remove(unCamarero);
        unCamarero.setNombre(nombre);
        unCamarero.setApellido(apellido);
        miPersistencia.EditarCamarero(unCamarero);
    }

    public void borrarCamarero(Camarero unCamarero) throws Exception {
        misCamareros.remove(unCamarero);
        miPersistencia.BajaCamarero(unCamarero);
    }

    public List<Camarero> mostrarCamareros() {
        return misCamareros;
    }
    
    
    
    //CLIENTE
    
    public void altaCliente(int dni, String nombre, String apellido, Double tarjetaDeCredito, String usuario, String contraseña) throws Exception {
        if (comprobarCliente(dni) == false) {
            Cliente unCliente = new Cliente(dni, nombre, apellido, tarjetaDeCredito, usuario, contraseña);
            misClientes.add(unCliente);
            miPersistencia.AltaCliente(unCliente);
        }
    }
    
    public Cliente DameElCliente(int ID) {
        return this.miPersistencia.dameUnCliente(ID);
    }

    public boolean comprobarCliente(int dni) {
        boolean aux = false;
        
        for(Cliente unCliente : misClientes){
            if(unCliente.getDni() == dni){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarCliente(int dni, String nombre, String apellido, Double tarjetaDeCredito, String usuario, String contraseña, Cliente unCliente) throws Exception {
        misClientes.remove(unCliente);
        unCliente.setNombre(nombre);
        unCliente.setApellido(apellido);
        unCliente.setTarjetaDeCredito(tarjetaDeCredito);
        unCliente.setUsuario(usuario);
        unCliente.setContraseña(contraseña);
        miPersistencia.EditarCliente(unCliente);
    }

    public void borrarCliente(Cliente unCliente) throws Exception {
        misClientes.remove(unCliente);
        miPersistencia.BajaCliente(unCliente);
    }

    public List<Cliente> mostrarClientes() {
        return misClientes;
    }
    
    
    
    
    //DEPARTAMENTO
    
    public void altaDepartamento(int id, String nombre) throws Exception {
        if (comprobarDepartamento(id) == false) {
            Departamento unDepartamento = new Departamento(id, nombre);
            misDepartamentos.add(unDepartamento);
            miPersistencia.AltaDepartamento(unDepartamento);
        }
    }
    
    public Departamento DameElDepartamento(int ID) {
        return this.miPersistencia.dameUnDepartamento(ID);
    }

    public boolean comprobarDepartamento(int id) {
        boolean aux = false;
        
        for(Departamento unDepartamento : misDepartamentos){
            if(unDepartamento.getId() == id){
                aux = true;
            }
        }
        
        return aux;
    }
    

    public void modificarDepartamento(int id, String nombre, Departamento unDepartamento) throws Exception {
        misDepartamentos.remove(unDepartamento);
        unDepartamento.setNombre(nombre);
        miPersistencia.EditarDepartamento(unDepartamento);
    }

    public void borrarDepartamento(Departamento unDepartamento) throws Exception {
        misDepartamentos.remove(unDepartamento);
        miPersistencia.BajaDepartamento(unDepartamento);
    }

    public List<Departamento> mostrarDepartamentos() {
        return misDepartamentos;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
