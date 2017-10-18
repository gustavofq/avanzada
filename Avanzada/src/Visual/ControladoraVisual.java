/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logica.Camarero;
import Logica.Cliente;
import Logica.Departamento;
import Logica.DetalleFactura;
import Logica.Factura;
import Logica.Hotel;
import java.util.List;

/**
 *
 * @author Facundo
 */
public class ControladoraVisual {
    
    //RELACIONES
    
    private Hotel unHotel = new Hotel();

    public ControladoraVisual(Hotel unHotel) {
        this.unHotel = unHotel;
    }
    
    public ControladoraVisual() {
    }

    
    //METODOS QUE LLAMAN A EMPRESA
    
    //CAMARERO
    
    public void altaCamarero(int dni, String nombre, String apellido) throws Exception {
        this.unHotel.altaCamarero(dni, nombre, apellido);
    }
    
    public Camarero DameElCamarero(int ID) {
        return this.unHotel.DameElCamarero(ID);
    }

    public void modificarCamarero(int dni, String nombre, String apellido, Camarero unCamarero) throws Exception {
        this.unHotel.modificarCamarero(dni, nombre, apellido, unCamarero);
    }

    public void borrarCamarero(Camarero unCamarero) throws Exception {
        this.unHotel.borrarCamarero(unCamarero);
    }

    public List<Camarero> mostrarCamareros() {
        return this.unHotel.mostrarCamareros();
    }
    
    
    
 
    //CLIENTE
    
    public void altaCliente(int dni, String nombre, String apellido, Double tarjetaDeCredito, String usuario, String contraseña) throws Exception {
        this.unHotel.altaCliente(dni, nombre, apellido, tarjetaDeCredito, usuario, contraseña);
    }
    
    public Cliente DameElCliente(int ID) {
        return this.unHotel.DameElCliente(ID);
    }

    public void modificarCliente(int dni, String nombre, String apellido, Double tarjetaDeCredito, String usuario, String contraseña, Cliente unCliente) throws Exception {
        this.unHotel.modificarCliente(dni, nombre, apellido, tarjetaDeCredito, usuario, contraseña, unCliente);
    }

    public void borrarCliente(Cliente unCliente) throws Exception {
        this.unHotel.borrarCliente(unCliente);
    }

    public List<Cliente> mostrarClientes() {
        return this.unHotel.mostrarClientes();
    }
    
    
    
    
    
    //DEPARTAMENTO
    
    public void altaDepartamento(int id, String nombre) throws Exception {
        this.unHotel.altaDepartamento(id, nombre);
    }
    
    public Departamento DameElDepartamento(int ID) {
        return this.unHotel.DameElDepartamento(ID);
    }

    public void modificarDepartamento(int id, String nombre, Departamento unDepartamento) throws Exception {
        this.unHotel.modificarDepartamento(id, nombre, unDepartamento);
    }

    public void borrarDepartamento(Departamento unDepartamento) throws Exception {
        this.unHotel.borrarDepartamento(unDepartamento);
    }

    public List<Departamento> mostrarDepartamentos() {
        return this.unHotel.mostrarDepartamentos();
    }
    
    
    //FACTURA
    
    public void altaFactura(int id, String Tipo, Double total) throws Exception {
        this.unHotel.altaFactura(id, Tipo, total);
    }
    
    public  Factura DameLaFactura(int ID) {
        return this.miPersistencia.dameUnDepartamento(ID);
    }

    public boolean comprobarFactura(int id) {
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
